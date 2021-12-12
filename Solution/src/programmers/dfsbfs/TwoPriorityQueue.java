package programmers.dfsbfs;

import java.util.Collections;
import java.util.PriorityQueue;

public class TwoPriorityQueue {
	public static void main(String[] args) {
		String[] operations = {"I 16","D 1"}; 
		
		Solution s = new Solution();
		s.solution(operations);
	}
}

class Solution {
	 
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> rpq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(String s : operations) {
        	String[] sArr = s.split(" ");
        	int val = Integer.parseInt(sArr[1]);
        	if(sArr[0].equals("I")) {
        		pq.add(val);
        		rpq.add(val);
        	} else if(sArr[0].equals("D")) {
        		if(val > 0) {
        			pq.remove(rpq.peek());
        			rpq.poll();
        		}else if(val < 0) {
        			rpq.remove(pq.peek());
        			pq.poll();
        		}
        	}
        }
        if(pq.isEmpty()) {
        	answer[0] = 0;
        	answer[1] = 0;
        }else {
        	answer[0] = rpq.peek();
        	answer[1] = pq.peek();
        }
        //System.out.printf("%d , %d", answer[0], answer[1]);
        
        return answer;
    }
}

