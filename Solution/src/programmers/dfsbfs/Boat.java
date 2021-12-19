package programmers.dfsbfs;

import java.util.Arrays;

public class Boat {
	public static void main(String[] args) {
		
		int[] people = {50, 70, 80};
		int limit = 100;
		Solution s = new Solution();
		System.out.println(s.solution(people, limit));
	}
}

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int max = people.length-1;
        for(int i=0; i<=max; ) {
    		if(people[i] + people[max] <= limit) {
    			i++;
    		}
    		max-=1;
    		answer++;
        }
        //answer += list.size();
        
        return answer;
    }
}
