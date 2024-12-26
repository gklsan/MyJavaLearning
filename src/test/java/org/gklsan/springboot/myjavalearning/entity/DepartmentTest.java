package org.gklsan.springboot.myjavalearning.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

  private Department department;
  private Student student1;
  private Student student2;

  @BeforeEach
  void setUp() {
    department = new Department();
    department.setId(1L);
    department.setName("Computer Science");
    department.setStaffCount(10);

    student1 = new Student();
    student1.setId(1L);
    student1.setFirstName("John");
    student1.setLastName("Doe");
    student1.setEmail("john.doe@example.com");
    student1.setDepartment(department);

    student2 = new Student();
    student2.setId(2L);
    student2.setFirstName("Jane");
    student2.setLastName("Smith");
    student2.setEmail("jane.smith@example.com");
    student2.setDepartment(department);
  }

  @Nested
  @DisplayName("Basic Property Tests")
  class BasicPropertyTests {
    @Test
    @DisplayName("Should correctly set and get ID")
    void shouldSetAndGetId() {
      Long expectedId = 2L;
      department.setId(expectedId);
      assertEquals(expectedId, department.getId());
    }

    @Test
    @DisplayName("Should correctly set and get name")
    void shouldSetAndGetName() {
      String expectedName = "Physics";
      department.setName(expectedName);
      assertEquals(expectedName, department.getName());
    }

    @Test
    @DisplayName("Should correctly set and get staff count")
    void shouldSetAndGetStaffCount() {
      int expectedCount = 15;
      department.setStaffCount(expectedCount);
      assertEquals(expectedCount, department.getStaffCount());
    }
  }

  @Nested
  @DisplayName("Student Relationship Tests")
  class StudentRelationshipTests {
    @Test
    @DisplayName("Should correctly set and get students list")
    void shouldSetAndGetStudentsList() {
      List<Student> studentList = Arrays.asList(student1, student2);
      department.setStudents(studentList);

      assertEquals(2, department.getStudents().size());
      assertTrue(department.getStudents().contains(student1));
      assertTrue(department.getStudents().contains(student2));
    }

    @Test
    @DisplayName("Should handle empty student list")
    void shouldHandleEmptyStudentList() {
      department.setStudents(new ArrayList<>());
      assertNotNull(department.getStudents());
      assertTrue(department.getStudents().isEmpty());
    }

    @Test
    @DisplayName("Should handle null student list")
    void shouldHandleNullStudentList() {
      department.setStudents(null);
      assertNull(department.getStudents());
    }
  }

  @Nested
  @DisplayName("Lombok Generated Tests")
  class LombokGeneratedTests {
    @Test
    @DisplayName("NoArgsConstructor should create valid object")
    void noArgsConstructorShouldCreateValidObject() {
      Department newDepartment = new Department();
      assertNotNull(newDepartment);
    }

    @Test
    @DisplayName("equals should work correctly")
    void equalsShouldWorkCorrectly() {
      Department dept1 = new Department();
      dept1.setId(1L);
      dept1.setName("Computer Science");
      dept1.setStaffCount(10);

      Department dept2 = new Department();
      dept2.setId(1L);
      dept2.setName("Computer Science");
      dept2.setStaffCount(10);

      assertEquals(dept1, dept2);
    }

    @Test
    @DisplayName("hashCode should be consistent")
    void hashCodeShouldBeConsistent() {
      Department dept1 = new Department();
      dept1.setId(1L);
      dept1.setName("Computer Science");
      dept1.setStaffCount(10);

      int initialHashCode = dept1.hashCode();
      int secondHashCode = dept1.hashCode();

      assertEquals(initialHashCode, secondHashCode);
    }

    @Test
    @DisplayName("toString should contain all fields")
    void toStringShouldContainAllFields() {
      String toString = department.toString();

      assertTrue(toString.contains(department.getId().toString()));
      assertTrue(toString.contains(department.getName()));
      assertTrue(toString.contains(String.valueOf(department.getStaffCount())));
    }
  }

  @Nested
  @DisplayName("Boundary Tests")
  class BoundaryTests {
    @Test
    @DisplayName("Should handle negative staff count")
    void shouldHandleNegativeStaffCount() {
      department.setStaffCount(-1);
      assertEquals(-1, department.getStaffCount());
    }

    @Test
    @DisplayName("Should handle zero staff count")
    void shouldHandleZeroStaffCount() {
      department.setStaffCount(0);
      assertEquals(0, department.getStaffCount());
    }

    @Test
    @DisplayName("Should handle large staff count")
    void shouldHandleLargeStaffCount() {
      department.setStaffCount(Integer.MAX_VALUE);
      assertEquals(Integer.MAX_VALUE, department.getStaffCount());
    }
  }
}