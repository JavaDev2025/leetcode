package com.github.alex4790354.p09TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ATMWithdraw {

    // Пытаемся выдать amount минимальным числом купюр из кассеты denom->count.
    // Возвращаем карту выдачи denom->count или null, если невозможно.
    public static Map<Integer, Integer> withdrawMinNotes(int amount, Map<Integer, Integer> cassette) {
        if (amount < 0) return null;
        if (amount == 0) return new LinkedHashMap<>();

        // Отсортируем номиналы по убыванию (сохраняем порядок для вывода).
        List<Integer> denoms = new ArrayList<>(cassette.keySet());
        denoms.sort(Comparator.reverseOrder());

        // Лучший (глобальный) результат
        Result best = new Result();

        // Подготовим массивы для быстрого доступа
        int n = denoms.size();
        int[] d = new int[n];
        int[] have = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = denoms.get(i);
            have[i] = Math.max(0, cassette.getOrDefault(d[i], 0));
        }

        // Верхняя граница (жадная оценка снизу по количеству купюр)
        // Если даже теоретический минимум > уже найденного best.cnt, то ветку можно отсечь.
        // Здесь best.cnt стартует как Integer.MAX_VALUE.
        backtrack(0, amount, d, have, new int[n], 0, best);

        if (best.cnt == Integer.MAX_VALUE) return null;

        // Собираем ответ в порядке убывания номиналов
        Map<Integer, Integer> ans = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) if (best.take[i] > 0) ans.put(d[i], best.take[i]);
        return ans;
    }

    // Рекурсивный перебор с отсечками: idx — индекс номинала, rem — остаток суммы,
    // curCnt — уже взято купюр; best — лучшее найденное решение.
    private static void backtrack(int idx, int rem, int[] d, int[] have, int[] curTake, int curCnt, Result best) {
        if (rem == 0) { // нашли точное разложение
            if (curCnt < best.cnt) {
                best.cnt = curCnt;
                best.take = Arrays.copyOf(curTake, curTake.length);
            }
            return;
        }
        if (idx == d.length) return; // номиналы закончились
        if (curCnt >= best.cnt) return; // уже хуже, чем лучшее

        int denom = d[idx];
        int maxCanUse = Math.min(have[idx], rem / denom);

        // ВАЖНО: перебираем от максимально возможного вниз — быстрее находит хорошее решение
        for (int use = maxCanUse; use >= 0; use--) {
            int newRem = rem - use * denom;
            int newCnt = curCnt + use;

            // Оценка снизу: даже если остаток newRem полностью закрыть купюрами следующего номинала,
            // нужно минимум ceil(newRem / nextDenomMax). Для грубой отсечки можно
            // поделить на текущий же номинал (даёт нижнюю границу).
            if (newRem > 0) {
                int lowerBoundMore = (newRem + denom - 1) / denom; // очень грубо
                if (newCnt + lowerBoundMore >= best.cnt) continue; // без шансов улучшить
            }

            curTake[idx] = use;
            backtrack(idx + 1, newRem, d, have, curTake, newCnt, best);
            curTake[idx] = 0; // откат
        }
    }

    // Контейнер для лучшего результата
    private static class Result {
        int cnt = Integer.MAX_VALUE;
        int[] take = new int[0];
    }

    // Утилита печати результата
    public static void printResult(int amount, Map<Integer, Integer> res) {
        if (res == null) {
            System.out.println("Невозможно выдать сумму: " + amount);
        } else {
            int totalNotes = res.values().stream().mapToInt(i -> i).sum();
            System.out.println("Выдаём " + amount + " руб. (" + totalNotes + " купюр):");
            for (Map.Entry<Integer, Integer> e : res.entrySet()) {
                System.out.println(e.getKey() + " руб. x " + e.getValue());
            }
        }
    }

    // 6) Простой main-тест
    public static void main(String[] args) {
        Map<Integer, Integer> cassette = new HashMap<>();
        cassette.put(5000, 1);
        cassette.put(1000, 1);
        cassette.put(500, 1);
        cassette.put(100, 9);

        int amount = 1500;
        Map<Integer, Integer> res = withdrawMinNotes(amount, cassette);
        printResult(amount, res);

        // Доп. проверка невозможности
        int badAmount = 1601; // при указанных остатках может не получиться (зависит от кассеты)
        printResult(badAmount, withdrawMinNotes(badAmount, cassette));
    }

}
