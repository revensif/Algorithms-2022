package lesson7;

import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     * <p>
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    //Алгоритм был взят с сайта https://www.sanfoundry.com/java-program-longest-common-subsequence-algorithm/
    //Оценка трудоёмкости T = O(n * m), где n - длина первой строки
    //Оценка ресурсоёмкости R = O(n * m), а m - длина второй строки
    public static String longestCommonSubSequence(String first, String second) {
        int n = first.length();
        int m = second.length();
        int[][] matrix = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (first.charAt(i) == second.charAt(j))
                    matrix[i][j] = matrix[i + 1][j + 1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j + 1]);
            }
        }
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n && j < m) {
            if (first.charAt(i) == second.charAt(j)) {
                sb.append(first.charAt(i));
                i++;
                j++;
            } else if (matrix[i + 1][j] >= matrix[i][j + 1])
                i++;
            else
                j++;
        }
        return sb.toString();
    }


    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     * <p>
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    //Алгоритм взят с сайта https://neerc.ifmo.ru/wiki/index.php?title=Задача_о_наибольшей_возрастающей_подпоследовательности
    //Оценка трудоёмкости T = O(n^2), где n - размер списка
    //Оценка ресурсоёмкости R = O(n)
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        if (list.size() <= 1) return list;
        int n = list.size();
        int[] prev = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < n; j++) {
                if (list.get(j) < list.get(i) && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int pos = 0;
        int length = d[0];
        for (int i = 0; i < n; i++) {
            if (d[i] > length) {
                pos = i;
                length = d[i];
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (pos != -1) {
            answer.add(list.get(pos));
            pos = prev[pos];
        }
        Collections.reverse(answer);
        return answer;
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     * <p>
     * В файле с именем inputName задано прямоугольное поле:
     * <p>
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     * <p>
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     * <p>
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }
}
