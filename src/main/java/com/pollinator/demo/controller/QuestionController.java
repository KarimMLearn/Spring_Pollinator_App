package com.pollinator.demo.controller;

import com.pollinator.demo.model.Question;
import com.pollinator.demo.repository.QuestionRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class QuestionController {

    private final QuestionRepository repository;

    QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/questions")
    List<Question> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion) {
        return repository.save(newQuestion);
    }

    // Single item

    @GetMapping("/questions/{id}")
    Question one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
    }

    @PutMapping("/questions/{id}")
    Question replaceEmployee(@RequestBody Question newQuestion, @PathVariable Long id) {

        return repository.findById(id)
                .map(Question -> {
                    Question.setQuestionText(newQuestion.getQuestionText());
                    return repository.save(Question);
                })
                .orElseGet(() -> {
                    return repository.save(newQuestion);
                });
    }

    @DeleteMapping("/questions/{id}")
    void deleteQuestion(@PathVariable Long id) {
        repository.deleteById(id);
    }
}