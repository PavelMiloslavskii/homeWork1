package main.java.ru.miloslavskii.task2;

import java.io.File;
import java.util.Map;

public class StartApp {
    public static void main(String[] args) {
        // Два вида пути к файлу
        File absolutePath = new File("C:\\Users\\Паша\\Downloads\\homeWork1\\src\\main\\java\\ru\\miloslavskii\\task2\\input.txt");
        File relativePath = new File("src/main/java/ru/miloslavskii/task2/input.txt");

        FrequentWord frequentWord = new FrequentWord();

        // Считать строки из файла
        frequentWord.readFile(relativePath);

        // Подсчет количества слов
        Map<String, Integer> currentMap = null;
        try {
            currentMap = frequentWord.countWords(frequentWord.getSplitStr());
            System.out.println(currentMap);
        } catch (NullPointerException ex) {
            System.out.println("**Файл пуст**");
        }
        // Вывод статистики слов
        frequentWord.findingTheFrequency(currentMap);
    }
}
