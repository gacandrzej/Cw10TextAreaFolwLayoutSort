# Algorytmy Sortowania w Javie

Projekt edukacyjny w Javie prezentujący implementację klasycznych algorytmów sortowania:
- Bubble Sort
- Insertion Sort
- Selection Sort

Projekt zawiera również testy jednostkowe JUnit 5, które weryfikują poprawność działania algorytmów oraz umożliwiają pomiar czasu wykonywania.

---

## 📌 Spis treści
1. [Opis projektu](#opis-projektu)
2. [Technologie](#technologie)
3. [Instalacja](#instalacja)
4. [Użycie](#użycie)
5. [Przykład kodu](#przykład-kodu)
6. [Testy jednostkowe](#testy-jednostkowe)
7. [Diagram sekwencji](#diagram-sekwencji)
8. [Zrzuty ekranu](#zrzuty-ekranu)
9. [Autor](#autor)
10. [Licencja](#licencja)

---

## 📝Opis projektu
Projekt ma na celu:
- Poznanie JTextArea, actionListenera w praktyce.
- Poznanie klasycznych algorytmów sortowania w praktyce.
- Porównanie efektywności sortowania różnych metod.
- Wykorzystanie tablic `int[]` oraz testów jednostkowych w JUnit 5.
- Ćwiczenie pracy z losowymi danymi (`Random` i streamy).

---

## ⚙️Technologie
- Java 25
- Swing (GUI)
- JUnit 5 (testy jednostkowe)
- Random streams w Javie 8+

---

## 💻Instalacja
```bash
# Sklonuj repozytorium
git clone https://github.com/gacandrzej/Cw10TextAreaFolwLayoutSort.git

# Przejdź do katalogu projektu
cd Cw10TextAreaFolwLayoutSort

# Kompilacja
javac -d bin src/**/*.java

# Uruchomienie GUI (przykład)
java -cp bin cwiczenia10.Main
```

---

## 🚀Użycie

- Uruchom GUI projektu.

- Wprowadź liczby do sortowania lub wygeneruj losową tablicę.

- Wybierz metodę sortowania: Bubble, Insertion lub Selection.

- Kliknij Sortuj, aby wyświetlić posortowane dane.


---

## 📌Przykład kodu
```java
 przyciskSortujTablice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaWypiszPosortowanaTablice.setText("");
                // konwersja List<Integer> → int[]
                int[] arr = liczby.stream().mapToInt(Integer::intValue).toArray();

                Algorithms alg = new Algorithms();

                // przykładowo testujemy każdy algorytm osobno
                testSort("Bubble Sort", arr.clone(), alg::bubbleSort);
                testSort("Insertion Sort", arr.clone(), alg::insertionSort);
                testSort("Selection Sort", arr.clone(), alg::selectionSort);
               // for (Integer i: liczby) areaWypiszPosortowanaTablice.append(i+" ");
            }
        });
```

---

## 🧪Testy jednostkowe
```java
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
```
Uruchamianie:
```bash
# Uruchomienie testów w terminalu
  javac -cp junit-platform-console-standalone-1.10.0.jar -d bin test/**/*.java
  java -jar junit-platform-console-standalone-1.10.0.jar --class-path bin --scan-class-path
```

---

## 📊Diagram sekwencji

```mermaid
sequenceDiagram
    autonumber
    participant Test as AlgorithmsTest
    participant Alg as Algorithms
    participant Arrays as JavaArrays

    Note over Test: @BeforeEach - setUp
    Test->>Alg: new Algorithms()
    Test->>Test: create random int[] arr

    Note over Test: Test insertionSort()
    Test->>Alg: insertionSort(copy of arr)
    Alg->>Arrays: sort expected array
    Alg-->>Test: sorted copy
    Test->>Test: assertArrayEquals(expected, copy)

    Note over Test: Test selectionSort()
    Test->>Alg: selectionSort(copy of arr)
    Alg->>Arrays: sort expected array
    Alg-->>Test: sorted copy
    Test->>Test: assertArrayEquals(expected, copy)

    Note over Test: Test bubbleSort()
    Test->>Alg: bubbleSort(copy of arr)
    Alg->>Arrays: sort expected array
    Alg-->>Test: sorted copy
    Test->>Test: assertArrayEquals(expected, copy)

    Note over Test: Timeout tests
    Test->>Alg: bubbleSort(copy of arr) with assertTimeout(Duration.ofSeconds(5))
    Alg-->>Test: sorted copy or timeout exception

```
---

## 🖼️Zrzuty ekranu
![img_1.png](img_1.png)

---

## 👤Autor
- [GitHub: gacandrzej](https://github.com/gacandrzej)


- Email: [gacandrzej@gmail.com](mailto:gacandrzej@gmail.com)


---

## Licencja
- MIT License © 2025 gacandrzej