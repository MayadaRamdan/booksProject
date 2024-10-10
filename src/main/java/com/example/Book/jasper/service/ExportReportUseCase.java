package com.example.Book.jasper.service;

import com.example.Book.book.repository.BookRepo;
import com.example.Book.jasper.dto.ReportFiltrationCriteria;
import com.example.Book.jasper.model.ReportModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ExportReportUseCase {


    private final BookRepo bookRepo;

    public byte[] execute(ReportFiltrationCriteria reportFiltrationCriteria) throws JRException, FileNotFoundException {

        log.info("ExportReportUseCase -> execute");

        List<ReportModel> reportModels = bookRepo.findReportModel(reportFiltrationCriteria);

        File file = ResourceUtils.getFile("classpath:books.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportModels);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
