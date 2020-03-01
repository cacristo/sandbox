package com.exercise.sandbox.algorithm;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.entity.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for testing the algorithms over list.
 */
public class ArrayListPermutableElementsTest {
    private static final Logger LOG = LoggerFactory.getLogger(ArrayListPermutableElementsTest.class);

    /**
     * Display the city giving the higher number of real words from the dictionary (table eurovisiondb.words).
     */
    @Test
    void testMostPermutableCity() {
        List<City> cities = getMockCities();
        List<Word> words = getMockWords();

        List<City> cities7Collection = cities.stream().filter(c -> c.getName().length() == 7).collect(Collectors.toList());
        List<Word> words5to7Collection = words.stream().filter(c -> c.getName().length() >= 5 && c.getName().length() <= 7).collect(Collectors.toList());

        Map<String, List<String>> mostPermutableCity = ArrayListPermutableElements.findMostPermutableCity(cities7Collection, words5to7Collection);

        // validation
        Assertions.assertNotNull(mostPermutableCity);
        Assertions.assertEquals(1, mostPermutableCity.size());

        List<String> resultList;
        // this Map will contains ALWAYS one element
        for (Map.Entry<String, List<String>> entry : mostPermutableCity.entrySet()) {
            resultList = entry.getValue();
            // validation
            Assertions.assertNotNull(resultList);
            Assertions.assertEquals(2, resultList.size());
            // log
            LOG.info("## ## The most permutable city founded indicated below ## ##");
            LOG.info("{} gives {}", entry.getKey(), resultList);
        }
    }

    /**
     * The list of {@link Word} to use for test.
     *
     * @return {@link List<Word>} list of elements
     */
    private List<Word> getMockWords() {
        List<Word> words = new ArrayList<>();
        words.add(new Word(1, "Cacaa"));
        words.add(new Word(2, "Cauass"));
        words.add(new Word(3, "Cadddd"));
        words.add(new Word(4, "shout"));
        words.add(new Word(5, "tonus"));
        words.add(new Word(10, "Baston"));
        words.add(new Word(6, "Rataa"));
        words.add(new Word(7, "Jaccaca"));
        words.add(new Word(8, "Bolas"));
        words.add(new Word(9, "Tetris"));
        return words;
    }

    /**
     * The list of {@link City} to use for test.
     *
     * @return {@link List<City>} list of elements
     */
    private List<City> getMockCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City(27, "Houston"));
        cities.add(new City(23, "Bouston"));
        cities.add(new City(27, "Baghdad"));
        cities.add(new City(29, "Bangalore"));
        cities.add(new City(43, "Ahmadabad"));
        cities.add(new City(47, "Alexandria"));
        cities.add(new City(50, "Ankara"));
        return cities;
    }
}
