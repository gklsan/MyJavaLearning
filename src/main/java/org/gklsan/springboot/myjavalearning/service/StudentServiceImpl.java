package org.gklsan.springboot.myjavalearning.service;

import jakarta.transaction.Transactional;
import org.gklsan.springboot.myjavalearning.dao.StudentDAO;
import org.gklsan.springboot.myjavalearning.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  private final StudentDAO studentDAO;

  @Autowired
  public StudentServiceImpl(StudentDAO theStudentDAO) {
    studentDAO = theStudentDAO;
  }

  @Override
  public List<Student> findAll() {
    return studentDAO.findAll();
  }

  @Override
  @Transactional
  public Student save(Student theStudent) {
    return studentDAO.save(theStudent);
  }

  @Override
  @Transactional
  public void deleteById(int id) {
    studentDAO.deleteById(id);
  }

  @Override
  public Student findById(int studentId) {
    return studentDAO.findById(studentId);
  }
}
