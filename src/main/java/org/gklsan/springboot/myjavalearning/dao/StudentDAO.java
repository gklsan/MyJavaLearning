package org.gklsan.springboot.myjavalearning.dao;

import org.gklsan.springboot.myjavalearning.entity.Student;

public interface StudentDAO {
  void save(Student theStudent);
  Student findById(int id);
}
