package programmers.dfsbfs;

public class Solution1 {
	public static void main(String[] args) {
		int[] operations = {1, 1, 1, 1, 1}; 
		int target = 3;
		Solution s = new Solution();
		System.out.println(s.solution(operations, target));
	}
}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer += dfs(numbers, 0, 0, target, true, 0);
        answer += dfs(numbers, 0, 0, target, false, 0);
        return answer;
    }
    
    public int dfs(int[]numbers, int start, int val, int target, boolean cont, int answer) {
    	if(cont == true) {
    		val += numbers[start];
    	}else {
    		val -= numbers[start];
    	}
    	if(start == numbers.length -1 && val == target) {
    		return ++answer;
    	}
    	start++;
    	if(start <= numbers.length-1) {
    		answer = dfs(numbers, start, val, target, true, answer);
    		answer = dfs(numbers, start, val, target, false, answer);
    	}
    	return answer;
    }
}
