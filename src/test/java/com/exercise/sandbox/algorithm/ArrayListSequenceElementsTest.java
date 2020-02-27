package com.exercise.sandbox.algorithm;

import com.exercise.sandbox.entity.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for testing the algorithms over list.
 */
public class ArrayListSequenceElementsTest {

    /**
     * GOAL example (LIMITED at 30 cities):
     * the extract of the biggest sequence of IDs in ascending order (N = 8 items) : 67 75 87 103 176 260 290 326
     */
    @Test
    void testLongestSequenceAlgorithm() {
        //67 75 87 103 176 260 290 326
        List<City> cities = getMockCities();

        List<City> citiesSorted = cities.stream().sorted(Comparator.comparing(City::getName)).collect(Collectors.toList());

        List<Integer> longestSequence = ArrayListSequenceElements.findLongestSequence(citiesSorted);
        Assertions.assertEquals(8, longestSequence.size());
        longestSequence.forEach(value -> System.out.print(" " + value));
    }

    /**
     * The list of {@link City} to use for test.
     *
     * @return {@link List<City>} list of elements
     */
    private List<City> getMockCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City(27, "Baghdad"));
        cities.add(new City(29, "Bangalore"));
        cities.add(new City(43, "Ahmadabad"));
        cities.add(new City(47, "Alexandria"));
        cities.add(new City(50, "Ankara"));
        cities.add(new City(67, "Abidian"));
        cities.add(new City(75, "Addis Ababa"));
        cities.add(new City(87, "Al-Jizah"));
        cities.add(new City(103, "Alepoo"));
        cities.add(new City(108, "Banduna"));
        cities.add(new City(124, "Acadir"));
        cities.add(new City(130, "Baku"));
        cities.add(new City(147, "Al-Khartum..."));
        cities.add(new City(157, "Accra"));
        cities.add(new City(160, "Antananarivo"));
        cities.add(new City(176, "Algiers"));
        cities.add(new City(197, "Acra"));
        cities.add(new City(227, "Al-Madinah"));
        cities.add(new City(230, "Anshan"));
        cities.add(new City(233, "Abadan"));
        cities.add(new City(234, "Bamako"));
        cities.add(new City(255, "Adana"));
        cities.add(new City(260, "Amman"));
        cities.add(new City(262, "Ad-Dammam"));
        cities.add(new City(290, "Amritsar"));
        cities.add(new City(297, "Adelaide"));
        cities.add(new City(302, "Almatv"));
        cities.add(new City(307, "Allahabad"));
        cities.add(new City(317, "Ahvaz"));
        cities.add(new City(326, "Aurangabad"));
        return cities;
    }
}
