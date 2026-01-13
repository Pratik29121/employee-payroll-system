package service;

import com.example.payroll.entity.Salary;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public byte[] generateSlip(Salary salary) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("Salary Slip"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Employee Name: " +
                    salary.getEmployee().getName()));
            document.add(new Paragraph("Designation: " +
                    salary.getEmployee().getDesignation()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Basic Salary: " + salary.getBasic()));
            document.add(new Paragraph("HRA: " + salary.getHra()));
            document.add(new Paragraph("Bonus: " + salary.getBonus()));
            document.add(new Paragraph("PF: " + salary.getPf()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Net Salary: " +
                    salary.getNetSalary()));

            document.close();
        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }

        return out.toByteArray();
    }
}
