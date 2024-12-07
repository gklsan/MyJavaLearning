package org.gklsan.springboot.myjavalearning.rest;

import org.gklsan.springboot.myjavalearning.entity.Student;
import org.gklsan.springboot.myjavalearning.exceptions.StudentNotFoundException;
import org.gklsan.springboot.myjavalearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

  @PostMapping("/students")
  public Student addStudent(@RequestBody Student theStudent) {
    theStudent.setId(0);
    return studentService.save(theStudent);
  }

  @PutMapping("/students")
  public Student updateStudent(@RequestBody Student theStudent) {
    return studentService.save(theStudent);
  }

  @DeleteMapping("/students/{student_id}")
  public String deleteStudent(@PathVariable int student_id) {
    if (student_id < 1) {
      throw new StudentNotFoundException("Student id not found - " + student_id);
    }

    studentService.deleteById(student_id);
    return "Deleted student id - " + student_id;
  }
}
