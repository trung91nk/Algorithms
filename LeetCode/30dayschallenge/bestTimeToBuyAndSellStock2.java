public class bestTimeToBuyAndSellStock2{
	public static void main (String[] args){
	}
	public static int maxProfit(int[] prices){	
        	int profit = 0;
		int ptr = 0;
		while(ptr<prices.length-1){
			if(prices[ptr]<prices[ptr+1]){
				if(ptr==prices.length-1){
					profit= 0;
				}else if(ptr==prices.length-2){
					profit+= prices[ptr+1]-prices[ptr];
					ptr++;
				}else{
					int iMax= ptr+1;
					while(iMax<prices.length-1 && prices[iMax]<prices[iMax+1] ){
						iMax++;
					}
					profit+=prices[iMax]-prices[ptr];
					ptr = iMax+1;
				}
			}else{
				ptr++;
			}
		}
		return profit;
	}
}
