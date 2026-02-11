// Q. Best time to buy and sell stock so that it can make a maximum profit

public class BuyAndSellStock {
    public static int BestTimeToBuyAndSell(int prices[]) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            int cost = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, cost);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    public static void main (String args[]) {
        int prices[] = {7, 1, 5, 3, 6, 4};

        System.out.println(BestTimeToBuyAndSell(prices));
    }
}
