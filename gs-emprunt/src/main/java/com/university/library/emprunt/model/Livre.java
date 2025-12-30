package com.university.library.emprunt.model;

import lombok.Data;

@Data
public class Livre {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private String publisher;
    private String category;
    private Integer totalCopies;
    private Integer availableCopies;
}
