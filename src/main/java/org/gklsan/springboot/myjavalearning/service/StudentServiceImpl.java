package org.gklsan.springboot.myjavalearning.service;

import jakarta.transaction.Transactional;
import org.gklsan.springboot.myjavalearning.entity.Student;
import org.gklsan.springboot.myjavalearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
  private StudentRepository studentRepository;

  @Autowired
  public StudentServiceImpl(StudentRepository theStudentRepository) {
    studentRepository = theStudentRepository;
  }

  @Override
  public Student findById(int studentId) {
    Optional<Student> theStudent = studentRepository.findById(studentId);
    Student theStudent1 = null;
    if(theStudent.isPresent()) {
      theStudent1 = theStudent.get();
    } else {
      throw new RuntimeException("Did not find student id - " + studentId);
    }
    return theStudent1;
  }

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Override
  @Transactional
  public Student save(Student theStudent) {
    return studentRepository.save(theStudent);
  }

  @Transactional
  public void deleteById(int id) {
    studentRepository.deleteById(id);
  }
}
