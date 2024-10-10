package com.example.Book.book.repository;

import com.example.Book.book.entity.Book;
import com.example.Book.jasper.dto.ReportFiltrationCriteria;
import com.example.Book.jasper.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query(value = "select b.name as name, b.type as type, a.authorName as authorName"
            + " from Book b join b.author a"
            + " where ( :#{#criteria.types} is null or b.type in :#{#criteria.types})"
            + " and ( :#{#criteria.authorIds} is null or a.id in :#{#criteria.authorIds}) ")
    List<ReportModel> findReportModel(ReportFiltrationCriteria criteria);
}
