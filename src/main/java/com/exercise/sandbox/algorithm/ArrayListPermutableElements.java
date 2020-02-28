package com.exercise.sandbox.algorithm;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.entity.Word;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class responsible to manage permutable algorithms over list.
 */
public class ArrayListPermutableElements {

    /**
     * Default constructor
     */
    private ArrayListPermutableElements() {
        /* hide constructor */
    }

    /**
     * Most permutable city
     * Display the city giving the higher number of real words from the dictionary (table eurovisiondb.words), following these rules :
     * <ul>
     * <li>city with 7 letters exactly [rule b1]</li>
     * <li>permutation from 5 to 7 letters [rule b2]</li>
     * <li>- Extract from the table Cities having name length=7</li>
     * <li>- From this list, permute all letters by group of 5, 6 and 7 (i.e. that gives a huge number of permutation possible 7!/(7-5)!*5! + 7!/(7-6)!...)</li>
     * <li>- Then you have to find from this list, the city name which have the higher number of words in the dictionary</li>
     * </ul>
     * Example Houston gives shout, tonus ...
     * It's not mandatory to deal with 'S'. Dictionary words are singular.
     * 
     * @param cities {@link List<City>} list of elements
     * @param words  {@link List<Word>} list of elements
     * @return {@link Map<String, List<String>>} with the most permutable city
     */
    public static Map<String, List<String>> findMostPermutableCity(List<City> cities, List<Word> words) {
        List<String> cityName = cities.stream().map(City::getName).collect(Collectors.toList());

        Map<String, List<String>> tempListMap = new HashMap<>();
        Map<String, List<String>> permutableMap = new HashMap<>();

        // for each city generate:
        // 1. the permutable values into
        // 2. initialize the name into the final map
        for (String string : cityName) {
            permutableMap.put(string, prepareData(string));
            tempListMap.put(string, new ArrayList<>());
        }

        // when detect a valid work add it into the temporary map
        words.stream().forEach(w ->
                permutableMap.keySet().forEach(r -> {
                    if (permutableMap.get(r).stream().anyMatch(str -> str.toUpperCase().contains(w.getName().toUpperCase()))) {
                        tempListMap.get(r).add(w.getName());
                    }
                })
        );

        // identify the most permutable city
        int hi = 0;
        String key = null;
        for (String a : tempListMap.keySet()) {
            if (key == null || tempListMap.get(a).size() > hi) {
                key = a;
                hi = tempListMap.get(a).size();
            }
        }
        // Add the most permutable city into new map and return it
        Map<String, List<String>> resultListMap = new HashMap<>();
        resultListMap.put(key, tempListMap.get(key));
        return resultListMap;
    }

    /**
     * Init the list of results by base word, then call the permutation method
     *
     * @param base
     * @return
     */
    public static List<String> prepareData(String base) {
        List<String> result = new ArrayList<>();
        permutation(StringUtils.EMPTY, base, result);
        return result;
    }

    /**
     * Generate one permutable word, according the prefix and base word,then save it at result list.
     *
     * @param prefix the prefix word
     * @param base   the base word
     * @param result {@link List<String>} with all possibilities founded
     */
    private static void permutation(String prefix, String base, List<String> result) {
        int n = base.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + base.charAt(i), base.substring(0, i) + base.substring(i + 1, n), result);
        }
    }
}
