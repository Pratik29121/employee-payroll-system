# Employee Payroll & Salary Slip Management System

## 🚀 Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- OpenPDF
- Maven

## 📌 Features
- Employee CRUD APIs
- Salary Management
- PDF Salary Slip Generation
- MySQL Integration
- RESTful APIs
- Exception Handling

## 📂 API Endpoints

### Employee APIs
- POST `/employees`
- GET `/employees`
- GET `/employees/{id}`

### Payroll APIs
- POST `/payroll/salary/{empId}`
- GET `/payroll/salary-slip/{salaryId}`

## 🧾 Sample Salary Slip
Generated dynamically using backend data and OpenPDF.

## 🛠️ How to Run
1. Create MySQL DB: `payroll_db`
2. Update `application.properties`
3. Run:
```bash
mvn spring-boot:run

Then:
```bash
git add README.md
git commit -m "Add README documentation"
git push
