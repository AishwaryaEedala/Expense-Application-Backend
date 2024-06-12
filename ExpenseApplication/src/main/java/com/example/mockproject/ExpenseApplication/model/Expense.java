package com.example.mockproject.ExpenseApplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Expense")

public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
@Column(name="date")
    private Instant Expensedate;
@Column(name="description")
    private String Description;
@Column(name="location")
    private String Location;
@Column(name="rupees")
    private String rupees;
@Enumerated(EnumType.STRING)
@Column(name="category_name")
    private String category_name;



}
