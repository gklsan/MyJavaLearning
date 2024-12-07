package org.gklsan.springboot.myjavalearning.service;

import org.gklsan.springboot.myjavalearning.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

  Student findById(int studentId);

  List<Student> findAll();

  Student save(Student theStudent);

  void deleteById(int id);
}
