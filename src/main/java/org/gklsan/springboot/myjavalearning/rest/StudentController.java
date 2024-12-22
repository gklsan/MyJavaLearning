package org.gklsan.springboot.myjavalearning.rest;

import org.gklsan.springboot.myjavalearning.entity.Student;
import org.gklsan.springboot.myjavalearning.exceptions.StudentNotFoundException;
import org.gklsan.springboot.myjavalearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class StudentController extends StudentNotFoundException {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentController(StudentRepository studentRepositoryObj) {
    super("Student not found with id: ");

    this.studentRepository = studentRepositoryObj;
  }

  @QueryMapping //("students")
  Iterable<Student> students() {
    return studentRepository.findAll();
  }

  @QueryMapping
  Optional<Student> studentById(@Argument Integer id) {
    return studentRepository.findById(id);
  }

  @MutationMapping
  Student createStudent(@Argument("student") StudentInput studentInput) {
    Student student = new Student();
    student.setFirstName(studentInput.firstName());
    student.setLastName(studentInput.lastName());
    student.setEmail(studentInput.email());
    return studentRepository.save(student);
  }

  record StudentInput(String firstName, String lastName, String email) {}

  @MutationMapping
  Boolean deleteStudent(@Argument Integer id) {
    studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    studentRepository.deleteById(id);
    return true;
  }

}
