package org.gklsan.springboot.myjavalearning;

import org.gklsan.springboot.myjavalearning.dao.StudentDAO;
import org.gklsan.springboot.myjavalearning.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(
        scanBasePackages = {
                "org.gklsan.springboot.crud",
                "org.gklsan.springboot.myjavalearning"
        }
)

//@SpringBootApplication
public class MyJavaLearningApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyJavaLearningApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      System.out.println("Hello World");
      createStudent(studentDAO);
      createMultipleStudents(studentDAO);
//      findStudent(studentDAO);
//      updateStudent(studentDAO);
//      removeStudent(studentDAO);
//      deleteAllStudents(studentDAO);
    };
  }

  private void deleteAllStudents(StudentDAO studentDAO) {
    System.out.println("Deleting all students...");
    int deletedCount = studentDAO.deleteAll();
    System.out.println("Deleted " + deletedCount + " students");

  }

  private void removeStudent(StudentDAO studentDAO) {
    System.out.println("Removing student...");
    studentDAO.deleteById(4);
  }

  private void updateStudent(StudentDAO studentDAO) {
    System.out.println("Updating student...");
    Student student = studentDAO.findById(1);
    student.setFirstName("Updated First Name");
    student.setLastName("Updated Last Name");
    studentDAO.update(student);
  }

  private void findStudent(StudentDAO studentDAO) {
    System.out.println("Finding student by id...");
    Student foundStudent = studentDAO.findById(1);

    System.out.println("Found student: " + foundStudent);

    System.out.println("Finding all students...");
    List<Student> studentList = studentDAO.findAll();
    for (Student student : studentList) {
      System.out.println("Student: " + student);
    }

    System.out.println("Finding student by last name...");
    List<Student> foundStudentByLastName = studentDAO.queryByLastName("doe");
    for (Student student : foundStudentByLastName) {
      System.out.println("Student: " + student);
    }
  }

  private void createMultipleStudents(StudentDAO studentDAO) {
    System.out.println("Creating multiple students...");
    Student tmpStudent1 = new Student("Gokul 1", "P", "gokul1@p.com");
    Student tmpStudent2 = new Student("Gokul 2", "P", "gokul2@p.com");
    Student tmpStudent3 = new Student("Gokul 3", "P", "gokul3@p.com");

    System.out.println("Saving the students...");
    studentDAO.save(tmpStudent1);
    studentDAO.save(tmpStudent2);
    studentDAO.save(tmpStudent3);
  }


  private void createStudent(StudentDAO studentDAO) {
    System.out.println("Creating student...");
    Student tmpStudent = new Student("John", "Doe", "test@test.com");

    System.out.println("Saving the student...");
    studentDAO.save(tmpStudent);

    System.out.println("Saved student: " + tmpStudent.getId());

    System.out.println("Finding student by id...");
    Student foundStudent = studentDAO.findById(tmpStudent.getId());

    System.out.println("Found student: " + foundStudent);

  }

}
