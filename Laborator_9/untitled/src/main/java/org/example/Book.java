package org.example;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private String language;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "number_of_pages")
    private int numberOfPages;

}
