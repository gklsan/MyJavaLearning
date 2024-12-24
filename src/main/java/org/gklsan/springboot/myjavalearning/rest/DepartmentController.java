package org.gklsan.springboot.myjavalearning.rest;

import org.gklsan.springboot.myjavalearning.entity.Department;
import org.gklsan.springboot.myjavalearning.exceptions.StudentNotFoundException;
import org.gklsan.springboot.myjavalearning.repository.DepartmentRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DepartmentController extends StudentNotFoundException {

  private final DepartmentRepository departmentRepository;

  public DepartmentController(DepartmentRepository departmentRepository) {
    super("Department not found with id: ");
    this.departmentRepository = departmentRepository;
  }

  @QueryMapping
  public List<Department> departments() {
    return departmentRepository.findAll();
  }

  @QueryMapping
  public Department departmentById(@Argument Long id) {
    return departmentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Department not found with id: " + id));
  }

  @MutationMapping
  Department createDepartment(@Argument("department") DepartmentInput departmentInput) {
    Department department = new Department();
    department.setName(departmentInput.name());
    department.setStaffCount(departmentInput.staffCount());
    return departmentRepository.save(department);
  }

  @MutationMapping
  Department updateDepartment(@Argument("department") DepartmentInput departmentInput) {
    Department department = departmentRepository.findById(departmentInput.id()).orElseThrow(() -> new StudentNotFoundException("Department not found with id: " + departmentInput.id()));
    department.setName(departmentInput.name());
    department.setStaffCount(departmentInput.staffCount());
    return departmentRepository.save(department);
  }

  @MutationMapping
  Boolean deleteDepartment(@Argument Long id) {
    departmentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Department not found with id: " + id));
    departmentRepository.deleteById(id);
    return true;
  }

  record DepartmentInput(Long id, String name, Integer staffCount) {}
}
