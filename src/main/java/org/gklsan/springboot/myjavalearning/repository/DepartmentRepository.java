package org.gklsan.springboot.myjavalearning.repository;

import org.gklsan.springboot.myjavalearning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> { }
