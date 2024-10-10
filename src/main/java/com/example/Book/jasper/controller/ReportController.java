package com.example.Book.jasper.controller;

import com.example.Book.jasper.dto.ReportFiltrationCriteria;
import com.example.Book.jasper.service.ExportReportUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@Slf4j
@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class ReportController {

    private final ExportReportUseCase exportReportUseCase;

    @GetMapping
    public byte[] generateReport(@RequestBody ReportFiltrationCriteria reportFiltrationCriteria)
            throws JRException, FileNotFoundException {

        log.info("ReportController -> generateReport(@RequestBody FilterReport filterReport)");
        return exportReportUseCase.execute(reportFiltrationCriteria);
    }

}
