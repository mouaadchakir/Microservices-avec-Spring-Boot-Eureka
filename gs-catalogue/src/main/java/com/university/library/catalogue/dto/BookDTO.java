package com.university.library.catalogue.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Integer publicationYear;
    private Integer availableCopies;
    private Integer totalCopies;
    private String category;
}
