package cwiczenia10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {
    Algorithms algorithms;
    int[] arr;

    @BeforeEach
    void setUp() {
        algorithms = new Algorithms();
        int n = 50_000; // rozmiar tablicy
        Random random = new Random();

        // Tworzymy tablicę int[] z losowymi liczbami 0..999_999
        arr = random.ints(n, 0, 1_000_000).toArray();
    }

    @AfterEach
    void tearDown() {
        algorithms = null;
        arr = null;
    }

    @Test
    void insertionSort() {
        int[] copy = arr.clone();
        int[] expected = arr.clone();
        Arrays.sort(expected);
        algorithms.insertionSort(copy);
        assertArrayEquals(expected, copy, "Insertion Sort nie posortował poprawnie tablicy");
    }

    @Test
    void selectionSort() {
        int[] copy = arr.clone();
        int[] expected = arr.clone();
        Arrays.sort(expected);
        algorithms.selectionSort(copy);
        assertArrayEquals(expected, copy, "Selection Sort nie posortował poprawnie tablicy");
    }

    @Test
    void bubbleSort() {
        int[] copy = arr.clone();
        int[] expected = arr.clone();
        Arrays.sort(expected);        // oczekiwany wynik
        algorithms.bubbleSort(copy);  // sortowanie Twoim algorytmem
        assertArrayEquals(expected, copy, "Bubble Sort nie posortował poprawnie tablicy");
    }

    // timeout
    @Test
    void bubbleSortTimeout() {
        int n = 10_000;
        Random random = new Random();
        int[] arr = random.ints(n, 0, 1_000_000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        assertTimeout(Duration.ofSeconds(5),
                () -> {
                    int[] copy = arr.clone();
                    algorithms.bubbleSort(copy);
                    assertArrayEquals(expected, copy,
                            "Bubble Sort nie posortował tablicy poprawnie!");
                },
                "Bubble Sort przekroczył maksymalny czas wykonania!");
    }

    @Test
    void insertionSortTimeout() {
        int n = 10_000;
        Random random = new Random();
        int[] arr = random.ints(n, 0, 1_000_000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        assertTimeout(Duration.ofSeconds(5),
                () -> {
                    int[] copy = arr.clone();
                    algorithms.insertionSort(copy);
                    assertArrayEquals(expected, copy,
                            "Insertion Sort nie posortował tablicy poprawnie!");
                },
                "Insertion Sort przekroczył maksymalny czas wykonania!");
    }

    @Test
    void selectionSortTimeout() {
        int n = 10_000;
        Random random = new Random();
        int[] arr = random.ints(n, 0, 1_000_000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        assertTimeout(Duration.ofSeconds(5),
                () -> {
                    int[] copy = arr.clone();
                    algorithms.selectionSort(copy);
                    assertArrayEquals(expected, copy,
                            "Selection Sort nie posortował tablicy poprawnie!");
                },
                "Selection Sort przekroczył maksymalny czas wykonania!");
    }

    // assertTimeoutPreemptively
    @Test
    void bubbleSortPreemptive() {
        int[] expected = arr.clone();
        Arrays.sort(expected);

        assertTimeoutPreemptively(Duration.ofSeconds(5),
                () -> {
                    int[] copy = arr.clone();
                    algorithms.bubbleSort(copy);
                    assertArrayEquals(expected, copy,
                            "Bubble Sort nie posortował tablicy poprawnie!");
                },
                "Bubble Sort przekroczył maksymalny czas wykonania!");
    }

    @Test
    void insertionSortPreemptive() {
        int[] expected = arr.clone();
        Arrays.sort(expected);

        assertTimeoutPreemptively(Duration.ofSeconds(5),
                () -> {
                    int[] copy = arr.clone();
                    algorithms.insertionSort(copy);
                    assertArrayEquals(expected, copy,
                            "Insertion Sort nie posortował tablicy poprawnie!");
                },
                "Insertion Sort przekroczył maksymalny czas wykonania!");
    }

    @Test
    void selectionSortPreemptive() {
        int[] expected = arr.clone();
        Arrays.sort(expected);

        assertTimeoutPreemptively(Duration.ofSeconds(5),
                () -> {
                    int[] copy = arr.clone();
                    algorithms.selectionSort(copy);
                    assertArrayEquals(expected, copy,
                            "Selection Sort nie posortował tablicy poprawnie!");
                },
                "Selection Sort przekroczył maksymalny czas wykonania!");
    }

}