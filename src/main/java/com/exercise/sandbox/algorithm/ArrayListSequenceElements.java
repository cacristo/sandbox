package com.exercise.sandbox.algorithm;

import com.exercise.sandbox.entity.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class responsible to manage algorithm over list.
 */
public class ArrayListSequenceElements {

    /**
     * Default constructor
     */
    private ArrayListSequenceElements() {
        /* hide constructor */
    }

    /**
     * Order the City by alphabetical ascendant, then display the biggest sequence based on the City.Id ascendant, adjacent or not
     * <p>
     * GOAL example (LIMITED at 30 cities):
     * the extract of the biggest sequence of IDs in ascending order (N = 8 items) : 67 75 87 103 176 260 290 326
     *
     * @param cities {@link List<City>} list of elements
     * @return display the longest sequence based on the City.Id ascendant, adjacent or not
     */
    public static List<Integer> findLongestSequence(List<City> cities) {
        List<Integer> integersP = cities.stream().map(City::getId).collect(Collectors.toList());
        List<Integer> integersM = cities.stream().map(City::getId).collect(Collectors.toList());

        integersP.remove(integersP.size() - 1);
        List<Integer> p = integersP;
        List<Integer> m = integersM;

        int bigL = 0;
        //for i in range 0 to N-1 (entry list)
        for (int i = 0; i < cities.size() - 1; i++) {

            // Binary search for the largest positive j ≤ L
            // such that X[M[j]] <= X[i]
            int low = 1;
            int hi = bigL;
            while (low <= hi) {
                double res = Math.ceil((low + hi) / 2);
                int mid = (int) res;
                if (cities.get(m.get(mid)).getId() < cities.get(i).getId()) {
                    low = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            // After searching, low is 1 greater than the
            // length of the longest prefix of X[i]
            int newL = low;

            // The predecessor of X[i] is the last index of
            // the subsequence of length newL-1
            p.set(i, m.get(newL - 1));
            m.set(newL, i);

            if (newL > bigL) {
                // If we found a subsequence longer than any we've
                // found yet, update L
                bigL = newL;
            }
        }
        // Reconstruct the longest increasing subsequence
        List<Integer> subsequence = new ArrayList<>();
        int k = m.get(bigL);
        for (int i = 0; i < bigL; i++) {
            //for i in range 0 to L -1:
            subsequence.add(cities.get(k).getId());
            k = p.get(k);
        }
        Collections.reverse(subsequence);
        return subsequence;
    }

}
