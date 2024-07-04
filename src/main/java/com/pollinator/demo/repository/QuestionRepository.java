package com.pollinator.demo.repository;

import com.pollinator.demo.model.Question;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Custom query methods can be defined here if needed
}