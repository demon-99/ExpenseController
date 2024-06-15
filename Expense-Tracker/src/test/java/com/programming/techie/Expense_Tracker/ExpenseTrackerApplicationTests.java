package com.programming.techie.Expense_Tracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ExpenseTrackerApplicationTests {

	@Test
	void contextLoads() {
	}

}
