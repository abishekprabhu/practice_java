package com.hcltech.EmployeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}

/*
* {
  "employeeName": "Alice Kumar",
  "email": "alice@company.com",
  "batch": "5116",
  "marks": [
    {
      "examName": "Assessment 1",
      "score": 85
    },
    {
      "examName": "Assessment 2",
      "score": 90
    }
  ]
}
*/
/*
* Batch: Represents a training batch (e.g., Batch 5116).

Employee: Represents a trainee (linked to a Batch, has many Marks).

Exam: Assigned to a Batch (many Marks).

Marks: Links an Employee to an Exam with a score.*/