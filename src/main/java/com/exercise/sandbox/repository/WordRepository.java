package com.exercise.sandbox.repository;

import com.exercise.sandbox.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage {@link Word} entity
 */
public interface WordRepository extends JpaRepository<Word, Integer> {
}
