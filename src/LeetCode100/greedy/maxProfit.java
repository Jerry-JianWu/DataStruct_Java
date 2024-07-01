package LeetCode100.greedy;

public class maxProfit {
    class Solution{
        public int maxProfit(int[] prices){
            if(prices == null || prices.length < 2){
                return 0;
            }
            int minPirce = Integer.MAX_VALUE;
            int maxProfit = 0;
            for(int price : prices){
                if(price < minPirce){
                    minPirce = price;
                }else if(price - minPirce > maxProfit){
                    maxProfit = price - minPirce;
                }
            }
            return maxProfit;
        }
    }
}
