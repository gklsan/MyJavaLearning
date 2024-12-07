package org.gklsan.springboot.myjavalearning.rest;

import org.gklsan.springboot.myjavalearning.dao.StudentDAO;
import org.gklsan.springboot.myjavalearning.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private final StudentDAO studentDAO;

  @Autowired
  public StudentRestController(StudentDAO studentDAO) {
      this.studentDAO = studentDAO;
  }

  @GetMapping("/hello")
  public String sayHello() {
      return "Hello World!";
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
      return studentDAO.findAll();
  }

  @GetMapping("/students/{student_id}")
  public Student getStudent(@PathVariable int student_id) {
    if (student_id < 1) {
      throw new StudentNotFoundException("Student id not found - " + student_id);
    }

    return studentDAO.findById(student_id);
  }

  @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
    StudentErrorResponse error = new StudentErrorResponse();
    error.setStatus(404);
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }


}
