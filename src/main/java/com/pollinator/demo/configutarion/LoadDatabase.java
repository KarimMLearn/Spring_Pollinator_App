package com.pollinator.demo.configutarion;
import com.pollinator.demo.model.Question;
import com.pollinator.demo.repository.QuestionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(QuestionRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Question("Do you love me do u do u")));
            log.info("Preloading " + repository.save(new Question("I am your master")));
        };
    }
}