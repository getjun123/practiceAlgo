package ch3.p92;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] arr;
		
		Solution s = new Solution();
		s.Solution();
	}
	
	public void Solution() {
		int[] arr = {2,4,5,4,6};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int max = arr[arr.length-1];
		int max_1 = arr[arr.length-2];
		
		int M = 8;
		int K = 3;
		int total = 0;
		int relayCnt = 0;
		for(int i=0; i<M; i++) {
			relayCnt++;
			if(relayCnt == K) {
				total += max_1;
				relayCnt = 0;
			}else {
				total += max;
			}
		}
		System.out.println("total: " + total );
	}
}
