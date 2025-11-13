/*
 * Copyright (c) 2025 Gac Andrzej
 * Licencja MIT. Pełną treść licencji znajdziesz w pliku LICENSE w katalogu głównym projektu.
 */
package cwiczenia10;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Klasa testująca algorytmy sortowania.
 */
class AlgorithmsTest {
    static Algorithms algorithms;
    int[] arr;

    /**
     * Metoda wykonywana raz, przed wszystkimi testami w klasie.
     */
    @BeforeAll
    static void beforeAll() {
        algorithms = new Algorithms();
    }

    /**
     * Metoda wykonywana raz, po wszystkich testach w klasie.
     */
    @AfterAll
    static void afterAll() {
        algorithms = null;
    }

    /**
     * Inicjalizuje obiekt Algorithms i tworzy tablicę z losowymi liczbami przed każdym testem.
     */
    @BeforeEach
    void setUp() {

        int n = 50_000; // rozmiar tablicy
        Random random = new Random();

        // Tworzymy tablicę int[] z losowymi liczbami 0..999_999
        arr = random.ints(n, 0, 1_000_000).toArray();
    }

    /**
     * Usuwa obiekt Algorithms po każdym teście.
     */
    @AfterEach
    void tearDown() {
        arr = null;
    }

    // testy
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

// bez duplikacji
void testTimeout(String name, Consumer<int[]> sorter, int n) {
    int[] arr = new Random().ints(n, 0, 1_000_000).toArray();
    int[] expected = arr.clone();
    Arrays.sort(expected);
    assertTimeout(Duration.ofSeconds(5), () -> {
        int[] copy = arr.clone();
        sorter.accept(copy);
        assertArrayEquals(expected, copy, name + " nie posortował tablicy poprawnie!");
    });
}

    @Test
    void bubbleSortTimeoutWithConsumer() {
        testTimeout("Bubble Sort", algorithms::bubbleSort, 10_000);
    }



}