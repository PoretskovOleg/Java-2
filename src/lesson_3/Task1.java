package lesson_3;

import java.util.*;

public class Task1 {

    public static void main(String[] args) {

        String[] words = initArWords();
        System.out.println("Массив слов: " + Arrays.toString(words));

        Set<String> uniqueWords = getUniqueWords(words);
        System.out.println("Массив уникальных слов: " + uniqueWords);

        Iterator<String> uniqIterator = uniqueWords.iterator();

        printCountRepeatWords(words, uniqIterator);
    }

    private static Set<String> getUniqueWords(String[] words) {

        List<String> listWords = Arrays.asList(words);
        return new HashSet<>(listWords);
    }

    private static void printCountRepeatWords(String[] words, Iterator<String> iterator) {

        Map<String, Integer> countRepeatWords = getCountRepeatWords(words, iterator);

        for (Map.Entry<String, Integer> word : countRepeatWords.entrySet()) {
            System.out.printf("Слово %s повторяется %d раз%n", word.getKey(), word.getValue());
        }
    }

    private static Map<String, Integer> getCountRepeatWords(String[] words, Iterator<String> iterator) {

        Map<String, Integer> countRepeatWords = new TreeMap<>();

        int count;
        while (iterator.hasNext()) {
            count = 0;
            String uniqWord = iterator.next();
            for (String word : words) {
                if (uniqWord.equals(word)) {
                    count++;
                }
            }
            countRepeatWords.put(uniqWord, count);
        }
        return countRepeatWords;
    }

    private static String[] initArWords() {

        return new String[]{
            "F", "B", "D", "A", "C", "B", "D", "B", "C", "E", "F"
        };
    }
}
