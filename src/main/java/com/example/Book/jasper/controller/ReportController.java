package com.example.Book.jasper.controller;

import com.example.Book.jasper.dto.ReportFiltrationCriteria;
import com.example.Book.jasper.service.ExportReportUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@Slf4j
@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class ReportController {

    private final ExportReportUseCase exportReportUseCase;

    @GetMapping
    public ResponseEntity<byte[]> generateReport(@RequestBody ReportFiltrationCriteria reportFiltrationCriteria)
            throws JRException, FileNotFoundException {

        log.info("ReportController -> generateReport(@RequestBody FilterReport filterReport)");

        byte[] bytes = exportReportUseCase.execute(reportFiltrationCriteria);

        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf; charset=UTF-8")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"books-report.pdf\"")
                .body(bytes);
    }

}
