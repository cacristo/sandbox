package com.exercise.sandbox.service;

import com.exercise.sandbox.entity.Word;

import java.util.List;

/**
 * Interface {@link Word} entity
 */
@FunctionalInterface
public interface WordService {

    /**
     * Retrieve list.
     *
     * @return {@link List<Word>}
     */
    List<Word> searchWords();
}
