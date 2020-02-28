package com.exercise.sandbox.service;

import com.exercise.sandbox.entity.Word;
import com.exercise.sandbox.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to manage {@link Word} entity
 */
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    /**
     * @see WordService#searchWords() for more information
     */
    @Override
    public List<Word> searchWords() {
        return wordRepository.findAll();
    }
}
