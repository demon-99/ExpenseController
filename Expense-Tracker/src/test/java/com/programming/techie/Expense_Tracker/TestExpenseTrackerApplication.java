package com.programming.techie.Expense_Tracker;

import org.springframework.boot.SpringApplication;

public class TestExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.from(ExpenseTrackerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
