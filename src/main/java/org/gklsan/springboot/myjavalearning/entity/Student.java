package org.gklsan.springboot.myjavalearning.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Data
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @ManyToOne
  @JoinColumn(name = "department_id", nullable = false)
  Department department;

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
