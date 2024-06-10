package com.example.mockproject.ExpenseApplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {
    private Long Id;
    private Instant Expensedate;
    private String Description;
    private String Location;
    private String rupees;
    private String category_name;
}
