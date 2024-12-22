package org.gklsan.springboot.myjavalearning.repository;

import org.gklsan.springboot.myjavalearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// custom routes names
//@RepositoryRestResource(path = "people")

public interface StudentRepository extends JpaRepository<Student, Integer> {}
