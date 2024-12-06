package org.gklsan.springboot.myjavalearning.dao;

import org.gklsan.springboot.myjavalearning.entity.Student;

import java.util.List;

public interface StudentDAO {
  void save(Student theStudent);
  Student findById(int id);
  List<Student> findAll();
  List<Student> queryByLastName(String lastName);
  void update(Student theStudent);
  void deleteById(int id);
  int deleteAll();
}
