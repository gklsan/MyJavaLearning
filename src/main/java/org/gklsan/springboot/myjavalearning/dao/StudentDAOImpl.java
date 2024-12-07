package org.gklsan.springboot.myjavalearning.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.gklsan.springboot.myjavalearning.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

  private EntityManager entityManager;

  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Student save(Student theStudent) {
    return entityManager.merge(theStudent);
  }

  @Override
  public Student findById(int id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    TypedQuery<Student> findAllQuery = entityManager.createQuery("from Student", Student.class);
    return findAllQuery.getResultList();
  }

  @Override
  public List<Student> queryByLastName(String lastName) {
    TypedQuery<Student> queryByLastNameQuery = entityManager.createQuery("from Student where lastName=:lastName", Student.class);
    queryByLastNameQuery.setParameter("lastName", lastName);
    return queryByLastNameQuery.getResultList();
  }

  @Override
  public void update(Student theStudent) {
    entityManager.merge(theStudent);
  }

  @Override
  public void deleteById(int id) {
    Student student = entityManager.find(Student.class, id);
    entityManager.remove(student);
  }

  @Override
  public int deleteAll() {
    return entityManager.createQuery("delete from Student").executeUpdate();
  }
}
