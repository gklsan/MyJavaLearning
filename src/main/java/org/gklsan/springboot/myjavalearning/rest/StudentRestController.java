package org.gklsan.springboot.myjavalearning.rest;

import org.gklsan.springboot.myjavalearning.entity.Student;
import org.gklsan.springboot.myjavalearning.exceptions.StudentNotFoundException;
import org.gklsan.springboot.myjavalearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private final StudentService studentService;

  @Autowired
  public StudentRestController(StudentService theStudentService) {
      studentService = theStudentService;
  }

  @GetMapping("/hello")
  public String sayHello() {
      return "Hello World!";
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
      return studentService.findAll();
  }

  @GetMapping("/students/{student_id}")
  public Student getStudent(@PathVariable int student_id) {
    if (student_id < 1) {
      throw new StudentNotFoundException("Student id not found - " + student_id);
    }

    return studentService.findById(student_id);
  }
}
