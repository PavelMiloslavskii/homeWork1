package main.java.ru.miloslavskii.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

public class FrequentWord {
    private String[] splitStr;

    public String[] getSplitStr() {
        return splitStr;
    }

    // Парсинг строк из файла
    public void readFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = br.readLine()) != null) {
                str.append(line.toLowerCase()).append(" ");
                // Разбиение строк на слова
                splitStr(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void splitStr(StringBuilder str) {
        splitStr = str.toString().split("[\\s,.]+");
    }

    // Подсчет и сортировка слов
    public Map<String, Integer> countWords(String[] words) throws NullPointerException {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String s : words) {
            if (!treeMap.containsKey(s)) {
                treeMap.put(s, 1);
            } else {
                treeMap.put(s, treeMap.get(s) + 1);
            }
        }
        return treeMap;
    }

    // Вывод статистики
    public void findingTheFrequency(Map<String, Integer> map) {
        if (map == null) {
            return;
        }
        int maxValueInMap = (Collections.max(map.values()));
        int maxLength = splitStr.length;
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue() == maxValueInMap) {
                double resultFrequency = (double) maxValueInMap / maxLength * 100;
                System.out.println("Частое слово -> '" + pair.getKey() + "'");
                System.out.println("Частота появление слова в тексте -> " + resultFrequency  + "%");
            }
        }
    }
}
