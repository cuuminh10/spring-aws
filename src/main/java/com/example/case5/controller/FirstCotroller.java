package com.example.case5.controller;

import com.example.case5.model.Question;
import com.example.case5.repository.QuestionRepository;
import com.example.case5.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class FirstCotroller {

    private final QuestionService questionService;

    public FirstCotroller(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("hello")
    public ResponseEntity<?> addQuestions() {
        Question question1 = new Question();
        question1.setTitle("123");
        question1.setDescription("123");
        questionService.addQuestions(question1);

        return ResponseEntity.ok("1233");
    }

    @GetMapping("find")
    public ResponseEntity<Question> findQuestions() {
        try {

            Question question = questionService.findQuestions();

            return ResponseEntity.ok(question);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return  ResponseEntity.ok(new Question());
    }
}
