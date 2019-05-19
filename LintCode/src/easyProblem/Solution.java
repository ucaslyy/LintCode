package easyProblem;

import java.util.ArrayList;
import java.util.List;



public class Solution {
    /**
     * @param emails: Original email
     * @return: Return the count of groups which has more than one email address in it.
     */
    public int countGroups(List<String> emails) {
		return 0;
        // Write your code here
    }
    
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers2(int n) {
    	List<Integer> list = new ArrayList<Integer>();
    	List<Integer> numList = new ArrayList<Integer>();
    	
    	if (n == 1) {
			for (int i = 1; i < 10; i++) {
				if (this.isNarcissisticNumber(i, n) == true) {
	    			list.add(i);
	    		}
			}
			return list;
    	}
    	
    	for (int i = 0; i < n-1; i++) {
    		numList.add(0);
    	}
    	numList.add(1);
    	
    	while (numList.get(numList.size()-1) < 10) {
			
    		for (int i = 0; i < 10; i++) {
    			numList.set(0, i);
    			
    			int temp = 0;
    			for (int j = 0; j < numList.size(); j++) {
    				temp += this.getPowersN(numList.get(j), n);
    			}
    			int num = 0;
    			for (int j = numList.size()-1; j >= 0; j--) {
    				num = num*10 + numList.get(j);
    			}
    			
    			if (temp == num) {
					list.add(num);
				}
    			
    		}
    		
    		boolean flag = true;
    		for (int i = 1; flag && i < numList.size(); i++) {
    			
    			if (numList.get(i)+1 == 10 && i == numList.size()-1) {
    				numList.set(i, 10);
    				break;
    			}
    			
    			if (numList.get(i)+1 == 10) {
    				numList.set(i, 0);
    				flag = true;
    			}else {
    				numList.set(i, numList.get(i)+1);
    				flag = false;
    			}
    			
    		}
    		
		}
    	
    	
    	return list;
	}
    
    public List<Integer> getNarcissisticNumbers(int n) {
    	
    	List<Integer> list = new ArrayList<Integer>();
    	if (n == 0) {
    		//
		}else if (n == 1) {
			for (int i = 1; i < 10; i++) {
				if (this.isNarcissisticNumber(i, n) == true) {
	    			list.add(i);
	    		}
			}
		}else {
			int num = 1;
			for (int i=0; i < n; i++) {
	    		num = num*10;
	    	}
	    	
	    	for (int i = num/10; i < num; i++) {
	    		if (this.isNarcissisticNumber(i, n) == true) {
	    			list.add(i);
	    		}
	    	}
		}
    	
		return list;
    }
    
    public boolean isNarcissisticNumber(int num, int n) {
		
    	int temp = 0;
    	int numtemp = num;
    	for (int i = 0; i < n; i++) {
    		temp += this.getPowersN(numtemp%10, n);
    		numtemp = numtemp/10;
    	}
    	
    	if (num == temp) {
    		return true;
    	}
    	
    	return false;
	}
    
    public Integer getPowersN(int temp, int n) {
    	
    	int res = 1;
    	for (int i = 0; i < n; i++) {
    		res = res*temp;
    	}
		return res;
	}
    
    public void display(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
		for (int i = 1; i < 9; i++){
			System.out.println("n = "+i);
			solution.display(solution.getNarcissisticNumbers(i));
			solution.display(solution.getNarcissisticNumbers2(i));
		}
		
//		ArrayList<String> arrayList = new ArrayList<String>();
//		solution.countGroups(emails)
	}
}
