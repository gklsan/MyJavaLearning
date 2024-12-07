package org.gklsan.springboot.myjavalearning.repository;

import org.gklsan.springboot.myjavalearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {}
