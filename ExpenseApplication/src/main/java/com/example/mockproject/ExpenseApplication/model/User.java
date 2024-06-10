package com.example.mockproject.ExpenseApplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long Id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;


}
