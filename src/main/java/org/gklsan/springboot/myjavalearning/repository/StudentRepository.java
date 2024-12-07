package org.gklsan.springboot.myjavalearning.repository;

import org.gklsan.springboot.myjavalearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// custom routes names
//@RepositoryRestResource(path = "people")

public interface StudentRepository extends JpaRepository<Student, Integer> {}
