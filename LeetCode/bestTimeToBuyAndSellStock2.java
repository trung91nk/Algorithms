public class bestTimeToBuyAndSellStock2{
	public static void main (String[] args){
	}
	public static int maxProfit(int[] prices){
        int profit =0;
        int l = prices.length;
        if(l>=1){
			int iMin = nSmall(prices);
			int iMax = nBig(prices);
			if(iMin==0 && iMax==l-1){     
				profit +=prices[iMax]-prices[iMin];
			}else if(iMin==l-1 && iMax==0){
				profit = 0;
			}else{
				profit+=prices[iMax]-prices[iMin];
				while(iMin<l-1 && iMax<l-1){
					if(iMax<=l-2){
						iMin=iMax+1;
						if(iMin<=l-2){
							while(prices[iMin]>=prices[iMin+1]){
								iMin++;
								if(iMin==l-1){
									break;
								}
							}
						}
					}
					if(iMin<=l-2){
						iMax=iMin+1;
						if(iMax<=l-2){
							while(prices[iMax]<=prices[iMax+1] && iMax<=l-2){
								iMax++;
								if(iMax==l-1){
									break;
								}
							}
						}
						profit+=prices[iMax]-prices[iMin];
					}
				}
			}
		}else{
			profit =0;
		}
        return profit;
    }
    public static int nSmall(int [] n){
		int i = 0;
		while(i<n.length-1){
			if(n[i]>n[i+1]){
				i++;
			}else{
				break;
			}
		}
		return i;
	}
	public static int nBig (int [] n){
		int i = nSmall(n);
		if(i>=n.length-1){
			return 0;
		}else{
			i+=+1;
			while(i<n.length-1){
				if(n[i]<n[i+1]){
					i++;
				}else{
					break;
				}
			}
			return i;
		}
	}
	

}
