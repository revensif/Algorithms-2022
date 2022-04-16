package lesson1;

import kotlin.NotImplementedError;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@SuppressWarnings("unused")
public class JavaTasks {
    /**
     * Сортировка времён
     * <p>
     * Простая
     * (Модифицированная задача с сайта acmp.ru)
     * <p>
     * Во входном файле с именем inputName содержатся моменты времени в формате ЧЧ:ММ:СС AM/PM,
     * каждый на отдельной строке. См. статью википедии "12-часовой формат времени".
     * <p>
     * Пример:
     * <p>
     * 01:15:19 PM
     * 07:26:57 AM
     * 10:00:03 AM
     * 07:56:14 PM
     * 01:15:19 PM
     * 12:40:31 AM
     * <p>
     * Отсортировать моменты времени по возрастанию и вывести их в выходной файл с именем outputName,
     * сохраняя формат ЧЧ:ММ:СС AM/PM. Одинаковые моменты времени выводить друг за другом. Пример:
     * <p>
     * 12:40:31 AM
     * 07:26:57 AM
     * 10:00:03 AM
     * 01:15:19 PM
     * 01:15:19 PM
     * 07:56:14 PM
     * <p>
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    static public void sortTimes(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка адресов
     * <p>
     * Средняя
     * <p>
     * Во входном файле с именем inputName содержатся фамилии и имена жителей города с указанием улицы и номера дома,
     * где они прописаны. Пример:
     * <p>
     * Петров Иван - Железнодорожная 3
     * Сидоров Петр - Садовая 5
     * Иванов Алексей - Железнодорожная 7
     * Сидорова Мария - Садовая 5
     * Иванов Михаил - Железнодорожная 7
     * <p>
     * Людей в городе может быть до миллиона.
     * <p>
     * Вывести записи в выходной файл outputName,
     * упорядоченными по названию улицы (по алфавиту) и номеру дома (по возрастанию).
     * Людей, живущих в одном доме, выводить через запятую по алфавиту (вначале по фамилии, потом по имени). Пример:
     * <p>
     * Железнодорожная 3 - Петров Иван
     * Железнодорожная 7 - Иванов Алексей, Иванов Михаил
     * Садовая 5 - Сидоров Петр, Сидорова Мария
     * <p>
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    static public void sortAddresses(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка температур
     * <p>
     * Средняя
     * (Модифицированная задача с сайта acmp.ru)
     * <p>
     * Во входном файле заданы температуры различных участков абстрактной планеты с точностью до десятых градуса.
     * Температуры могут изменяться в диапазоне от -273.0 до +500.0.
     * Например:
     * <p>
     * 24.7
     * -12.6
     * 121.3
     * -98.4
     * 99.5
     * -12.6
     * 11.0
     * <p>
     * Количество строк в файле может достигать ста миллионов.
     * Вывести строки в выходной файл, отсортировав их по возрастанию температуры.
     * Повторяющиеся строки сохранить. Например:
     * <p>
     * -98.4
     * -12.6
     * -12.6
     * 11.0
     * 24.7
     * 99.5
     * 121.3
     */
    //Оценка трудоёмкости T = O(n)
    //Оценка ресурсоёмкости R = O(n)
    static public void sortTemperatures(String inputName, String outputName) throws IOException {
        try (BufferedWriter buffWr = new BufferedWriter(new FileWriter(outputName))) {
            int[] temperNumb = new int[7731];
            int const1 = 273;
            List<String> lines = Files.readAllLines(Paths.get(inputName), StandardCharsets.UTF_8);
            if (lines.size() != 0) {
                for (String line : lines) {
                    String[] lineDiv = line.split("\\.");
                    int intNumb = Integer.parseInt(lineDiv[0]);
                    int decNumb = Integer.parseInt(lineDiv[1]);
                    int finalNumb;
                    if (Double.parseDouble(line) < 0) {
                        finalNumb = ((intNumb + const1) * 10) - decNumb;
                    } else finalNumb = ((intNumb + const1) * 10) + decNumb;
                    temperNumb[finalNumb] += 1;
                }
                for (int i = 0; i < temperNumb.length; i++) {
                    for (int k = 0; k < temperNumb[i]; k++) {
                        buffWr.write((i - (const1 * 10)) / 10.0 + "\n");
                    }
                }
            }
        }
    }


    /**
     * Сортировка последовательности
     * <p>
     * Средняя
     * (Задача взята с сайта acmp.ru)
     * <p>
     * В файле задана последовательность из n целых положительных чисел, каждое в своей строке, например:
     * <p>
     * 1
     * 2
     * 3
     * 2
     * 3
     * 1
     * 2
     * <p>
     * Необходимо найти число, которое встречается в этой последовательности наибольшее количество раз,
     * а если таких чисел несколько, то найти минимальное из них,
     * и после этого переместить все такие числа в конец заданной последовательности.
     * Порядок расположения остальных чисел должен остаться без изменения.
     * <p>
     * 1
     * 3
     * 3
     * 1
     * 2
     * 2
     * 2
     */
    //Оценка трудоёмкости T = O(n)
    //Оценка ресурсоёмкости R = O(n)
    static public void sortSequence(String inputName, String outputName) throws IOException {
        try (BufferedWriter buffWr = new BufferedWriter(new FileWriter(outputName))) {
            Map<Integer, Integer> map = new HashMap<>();
            List<String> lines = Files.readAllLines(Paths.get(inputName), StandardCharsets.UTF_8);
            if (lines.size() != 0) {
                for (String line : lines) {
                    if (map.get(Integer.parseInt(line)) == null) map.put(Integer.parseInt(line), 1);
                    else map.put(Integer.parseInt(line), map.get(Integer.parseInt(line)) + 1);
                }
                int maxAmount = 1;
                List<Integer> minKey = new ArrayList<>();
                for (int value : map.values()) {
                    if (maxAmount < value) maxAmount = value;
                }
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (maxAmount == entry.getValue()) minKey.add(entry.getKey());
                }
                Integer minDigit = Collections.min(minKey);
                for (String line : lines) {
                    if (Integer.parseInt(line) != minDigit) {
                        buffWr.write(line + "\n");
                    }
                }
                for (int i = 0; i < maxAmount; i++) {
                    buffWr.write(minDigit.toString() + "\n");
                }
            }
        }
    }

    /**
     * Соединить два отсортированных массива в один
     * <p>
     * Простая
     * <p>
     * Задан отсортированный массив first и второй массив second,
     * первые first.size ячеек которого содержат null, а остальные ячейки также отсортированы.
     * Соединить оба массива в массиве second так, чтобы он оказался отсортирован. Пример:
     * <p>
     * first = [4 9 15 20 28]
     * second = [null null null null null 1 3 9 13 18 23]
     * <p>
     * Результат: second = [1 3 4 9 9 13 15 20 23 28]
     */
    //Оценка трудоёмкости T = (N)
    //Оценка ресурсоёмкости R = O(1)
    static <T extends Comparable<T>> void mergeArrays(T[] first, T[] second) {
        int i = 0;
        int j = first.length;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i].compareTo(second[j]) < 0) {
                second[k] = first[i];
                i++;
            } else {
                second[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            second[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            second[k] = second[j];
            j++;
            k++;
        }
    }
}