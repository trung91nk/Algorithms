import java.util.Arrays;
public class countingElements{
	public static void main(String [] args){
		//int [] arr = {1,1,2,2};
		//int [] arr = {1,3,2,3,5,0};
		//int [] arr = {1,2,3};
		int [] arr = {0,1,4,6,7,9};
		//int [] arr = {8,7,12,13,0,6,8,10,0,0,0,6,0,14};
		System.out.println(count(arr));
	}
	//normalAlgo
	public static int count(int[] arr){
		int counted = 0;
		Arrays.sort(arr);
		int pointer1 = 0;
		int pointer2 = 1;
		while(pointer1<arr.length && pointer2<arr.length){
			if(arr[pointer1]==arr[pointer2]){
				pointer2++;
			}else if(arr[pointer1]+1==arr[pointer2]){
				counted++;
				pointer1++;
			}else{
				pointer1=pointer2;
				pointer2++;
			}
		}
		return counted;
	}
	//HashSet
	public static int count1(int[] arr){
		Arrays.sort(arr);
		HashSet<Integer> h = new HashSet<Integer>();
		int counted =0;
		for(int i=arr.length-1;i>=0;i--){
			if(!h.contains(arr[i])){
				h.add(arr[i]);
			}
			if(h.contains(arr[i]+1)){
				counted++;
			}
		}
		return counted;
	}
}
