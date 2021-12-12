package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Network {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; 
		Solution s = new Solution();
		System.out.println(s.solution(n, computers));
	}
}

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        List<Node> nList = new ArrayList<Node>();
        for(int i=0; i<computers.length; i++) {
        	nList.add(new Node(i, computers[i]));
        }
        
        for(Node node : nList) {
        	answer += search(0, node, nList);
        }
        
        return answer;
    }
    
    public int search(int idx, Node n, List<Node> list) {
    	if(n.isVisit() == false) {
	    	n.setVisit(true); //방문 표시
	    	for(int i=0; i<n.getNet().length; i++) {
	    		if(i != n.getIdx() && 1 == n.getNet()[i]) {
	    			search(i, list.get(i), list);
	    		}
	    	}
	    	return 1;
    	}
    	return 0;
    }
}


class Node {
	int idx;
	boolean visit;
	int[] net;

	public Node(int idx, int[] net) {
		this.idx = idx;
		this.visit = false;
		this.net = net;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public boolean isVisit() {
		return visit;
	}
	public void setVisit(boolean visit) {
		this.visit = visit;
	}
	public int[] getNet() {
		return net;
	}
	public void setNet(int[] net) {
		this.net = net;
	}
	

}