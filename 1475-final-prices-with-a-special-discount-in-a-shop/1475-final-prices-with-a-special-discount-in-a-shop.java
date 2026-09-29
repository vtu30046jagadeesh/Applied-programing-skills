class Solution {
    public int[] finalPrices(int[] prices) {
        int[] r = new int[prices.length];
        int[] stack = new int[prices.length];
        int sp = -1;
        stack[++sp] = 0;
        for(int i = 1; i < prices.length; i++) {
            while(sp >= 0 && prices[stack[sp]] >= prices[i]) {
                int index = stack[sp--];
                r[index] = prices[index] - prices[i];
            }
            stack[++sp] = i;
        }
        while(sp >= 0) {
            int c = stack[sp--];
            r[c] = prices[c];
        }
        return r;
    }
}