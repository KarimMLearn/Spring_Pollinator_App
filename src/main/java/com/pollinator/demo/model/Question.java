package com.pollinator.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("question")
public class Question {

    @Id
    private Long id;

    @Column("question_text")
    private String questionText;

    // Constructors, getters, setters
    // Omitted for brevity
}