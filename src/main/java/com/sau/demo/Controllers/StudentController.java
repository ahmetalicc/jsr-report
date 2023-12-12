package com.sau.demo.Controllers;


import com.sau.demo.Models.Student;
import com.sau.demo.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/student")
public class StudentController {

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;

    @GetMapping("/all")

    public ResponseEntity<Object> getStudents(Model model) {
        Iterable<Student> studentList = studentRepository.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        return ResponseEntity.ok().headers(responseHeaders).body(studentList);

    }

    @GetMapping("/pdf")
    //@ResponseBody
    public ResponseEntity<byte[]> getPdf() throws JRException {
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(studentRepository.findAll());
        JasperReport compileReport = JasperCompileManager.compileReport("src/main/resources/jsr.jrxml");
        HashMap<String, Object> map = new HashMap<>();
        JasperPrint report = JasperFillManager.fillReport(compileReport, map, ds);
        //JasperExportManager.exportReportToPdfFile(report, "grade.pdf");
        byte[] data = JasperExportManager.exportReportToPdf(report);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=grade.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }
}
