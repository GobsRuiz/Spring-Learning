package com.example.thymelaef.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="News")
public class News {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    // @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    // public LocalDate date;

    @NotBlank //Can't be null
    public String title;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "author_id", referencedColumnName = "id")
    // private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // public Author getAuthor() {
    //     return author;
    // }

    // public void setAuthor(Author author) {
    //     this.author = author;
    // }

    // @NotBlank
    // @Lob // Long text
    // public String description;
}
