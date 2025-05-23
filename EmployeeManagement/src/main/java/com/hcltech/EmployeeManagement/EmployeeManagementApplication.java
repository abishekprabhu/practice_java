package com.hcltech.EmployeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}

/* ---------> Employee JSON output
* {
  "employeeName": "Alice Kumar",
  "email": "alice@company.com",
  "batch": "5116", ->CRUD
  "marks": [
    {
      "examName": "Assessment 1", -> exam CRUD
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

/*
*
* [
 {
   "batchCode": "JAVA-FSD-5116",
   "exams": [
     {
       "examName": "Java Basics",
       "examDate": "2025-05-20",
       "scores": [
         {
           "employeeName": "Abishek Prabhu",
           "score": 95
         },
         {
           "employeeName": "Ravi Kumar",
           "score": 90
         }
       ]
     },
     {
       "examName": "Spring Boot",
       "examDate": "2025-05-22",
       "scores": [
         {
           "employeeName": "Ravi Kumar",
           "score": 97
         },
         {
           "employeeName": "Abishek Prabhu",
           "score": 88
         }
       ]
     }
   ]
 }
]
* */