package com.pollinator.demo.repository;

import com.pollinator.demo.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    // Additional query methods can be defined here
}