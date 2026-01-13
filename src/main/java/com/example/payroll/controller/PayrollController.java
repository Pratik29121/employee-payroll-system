package com.example.payroll.controller;

import com.example.payroll.entity.Employee;
import com.example.payroll.entity.Salary;
import com.example.payroll.repository.EmployeeRepository;
import com.example.payroll.repository.SalaryRepository;
import com.example.payroll.service.PdfService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    private final EmployeeRepository employeeRepository;
    private final SalaryRepository salaryRepository;
    private final PdfService pdfService;

    public PayrollController(EmployeeRepository employeeRepository,
                             SalaryRepository salaryRepository,
                             PdfService pdfService) {
        this.employeeRepository = employeeRepository;
        this.salaryRepository = salaryRepository;
        this.pdfService = pdfService;
    }

    @PostMapping("/salary/{empId}")
    public Salary createSalary(@PathVariable Long empId,
                               @RequestBody Salary salary) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        salary.setEmployee(employee);
        return salaryRepository.save(salary);
    }

    @GetMapping("/salary-slip/{salaryId}")
    public ResponseEntity<byte[]> downloadSlip(@PathVariable Long salaryId) {
        Salary salary = salaryRepository.findById(salaryId)
                .orElseThrow(() -> new RuntimeException("Salary not found"));
        byte[] pdf = pdfService.generateSlip(salary);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=salary-slip.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
