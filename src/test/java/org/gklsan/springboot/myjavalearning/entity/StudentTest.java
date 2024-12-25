package org.gklsan.springboot.myjavalearning.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

  private Student student;
  private Department department;

  @BeforeEach
  void setUp() {
    department = new Department();
    department.setId(1L);
    department.setName("Computer Science");

    student = new Student();
    student.setId(1L);
    student.setFirstName("John");
    student.setLastName("Doe");
    student.setEmail("john.doe@example.com");
    student.setDepartment(department);
  }

  @Test
  @DisplayName("Basic Property Tests \n Should correctly set and get ID")
  void shouldSetAndGetId() {
    Long expectedId = 2L;
    student.setId(expectedId);
    assertEquals(expectedId, student.getId());
  }

  @Test
  @DisplayName("Should correctly set and get first name")
  void shouldSetAndGetFirstName() {
    String expectedFirstName = "Jane";
    student.setFirstName(expectedFirstName);
    assertEquals(expectedFirstName, student.getFirstName());
  }

  @Test
  @DisplayName("Should correctly set and get last name")
  void shouldSetAndGetLastName() {
    String expectedLastName = "Smith";
    student.setLastName(expectedLastName);
    assertEquals(expectedLastName, student.getLastName());
  }

  @Test
  @DisplayName("Should correctly set and get email")
  void shouldSetAndGetEmail() {
    String expectedEmail = "jane.smith@example.com";
    student.setEmail(expectedEmail);
    assertEquals(expectedEmail, student.getEmail());
  }

  @Test
  @DisplayName("Should correctly set and get department")
  void shouldSetAndGetDepartment() {
    Department newDepartment = new Department();
    newDepartment.setId(2L);
    newDepartment.setName("Physics");

    student.setDepartment(newDepartment);
    assertEquals(newDepartment, student.getDepartment());
  }

  @Nested
  @DisplayName("Custom Method Tests")
  class CustomMethodTests {
    @Test
    @DisplayName("getFullName should return correctly formatted full name")
    void getFullNameShouldReturnCorrectFormat() {
      String expectedFullName = "John Doe";
      assertEquals(expectedFullName, student.getFullName());
    }

    @Test
    @DisplayName("getFullName should handle null values")
    void getFullNameShouldHandleNullValues() {
      student.setFirstName(null);
      student.setLastName(null);
      assertEquals("null null", student.getFullName());
    }
  }

  @Nested
  @DisplayName("ToString Tests")
  class ToStringTests {
    @Test
    @DisplayName("toString should contain all relevant fields")
    void toStringShouldContainAllFields() {
      String toString = student.toString();

      assertTrue(toString.contains(student.getId().toString()));
      assertTrue(toString.contains(student.getFirstName()));
      assertTrue(toString.contains(student.getLastName()));
      assertTrue(toString.contains(student.getEmail()));
    }
  }

  @Nested
  @DisplayName("Lombok Generated Tests")
  class LombokGeneratedTests {
    @Test
    @DisplayName("equals should work correctly")
    void equalsShouldWorkCorrectly() {
      Student student1 = new Student();
      student1.setId(1L);
      student1.setFirstName("John");
      student1.setLastName("Doe");
      student1.setEmail("john.doe@example.com");
      student1.setDepartment(department);

      Student student2 = new Student();
      student2.setId(1L);
      student2.setFirstName("John");
      student2.setLastName("Doe");
      student2.setEmail("john.doe@example.com");
      student2.setDepartment(department);

      assertEquals(student1, student2);
    }

    @Test
    @DisplayName("hashCode should be consistent")
    void hashCodeShouldBeConsistent() {
      Student student1 = new Student();
      student1.setId(1L);
      student1.setFirstName("John");
      student1.setLastName("Doe");
      student1.setEmail("john.doe@example.com");
      student1.setDepartment(department);

      int initialHashCode = student1.hashCode();
      int secondHashCode = student1.hashCode();

      assertEquals(initialHashCode, secondHashCode);
    }
  }
}