package org.gklsan.springboot.myjavalearning;

import org.gklsan.springboot.myjavalearning.dao.StudentDAO;
import org.gklsan.springboot.myjavalearning.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
//      createStudent(studentDAO);
//      createMultipleStudents(studentDAO);
      findStudent(studentDAO);
    };
  }

  private void findStudent(StudentDAO studentDAO) {
    System.out.println("Finding student by id...");
    Student foundStudent = studentDAO.findById(1);

    System.out.println("Found student: " + foundStudent);
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
