package org.gklsan.springboot.myjavalearning.rest;

import org.gklsan.springboot.myjavalearning.entity.Student;
import org.gklsan.springboot.myjavalearning.exceptions.StudentNotFoundException;
import org.gklsan.springboot.myjavalearning.repository.DepartmentRepository;
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
  private final DepartmentRepository departmentRepository;

  @Autowired
  public StudentController(StudentRepository studentRepositoryObj, DepartmentRepository departmentRepository) {
    super("Student not found with id: ");

    this.studentRepository = studentRepositoryObj;
    this.departmentRepository = departmentRepository;
  }

  @QueryMapping //("students")
  Iterable<Student> students() {
    return studentRepository.findAll();
  }

  @QueryMapping
  Optional<Student> studentById(@Argument Long id) {
    return studentRepository.findById(id);
  }

  @MutationMapping
  Student createStudent(@Argument("student") StudentInput studentInput) {
    Student student = new Student();
    student.setFirstName(studentInput.firstName());
    student.setLastName(studentInput.lastName());
    student.setEmail(studentInput.email());
    departmentRepository.findById(studentInput.departmentId()).ifPresent(student::setDepartment);
    return studentRepository.save(student);
  }

  @MutationMapping
  Boolean deleteStudent(@Argument Long id) {
    studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    studentRepository.deleteById(id);
    return true;
  }

  @MutationMapping
  Student updateStudent(@Argument("student") StudentInput studentInput) {
    Student student = studentRepository.findById(studentInput.id()).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentInput.id()));
    student.setFirstName(studentInput.firstName());
    student.setLastName(studentInput.lastName());
    student.setEmail(studentInput.email());
    return studentRepository.save(student);
  }

  record StudentInput(Long id, String firstName, String lastName, String email, Long departmentId) {}
}
