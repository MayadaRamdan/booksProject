package com.example.Book.jasper.dto;

import com.example.Book.book.enums.BookType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ReportFiltrationCriteria implements Serializable {

    private List<BookType> types;
    private List<Long> authorIds;
}
