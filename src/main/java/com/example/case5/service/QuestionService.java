package com.example.case5.service;

import com.example.case5.model.Question;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    public void addQuestions(Question question) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            // Begin a unit of work
            Transaction tx = session.beginTransaction();
            Long id = (Long) session.save(question);
            tx.commit();
        }
    }

    public Question findQuestions() {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            Question question1 = session.load(Question.class, 1000L);
            return question1;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
