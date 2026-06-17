package com.github.alex4790354.p11XOR;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE; // минимальная цена (точка покупки)
        int maxProfit = 0;                // максимальная прибыль

        for (int price : prices) { // enhanced loop (пункт 12)
            if (price < minPrice) {
                minPrice = price; // обновляем минимальную цену
            } else {
                int profit = price - minPrice; // потенциальная прибыль
                if (profit > maxProfit) {
                    maxProfit = profit; // обновляем максимум
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices1)); // Ожидается: 5
        System.out.println(maxProfit(prices2)); // Ожидается: 0
    }
}
