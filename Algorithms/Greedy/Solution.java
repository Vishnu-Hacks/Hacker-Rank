/*
 Outline 
 -------
 For an upcoming programming contest, Roy is forming some teams from the  students of his university. A team can have any number of contestants.
Roy knows the skill level of each contestant. To make the teams work as a unit, he should ensure that there is no skill gap between the contestants of the same team. 
In other words, if the skill level of a contestant is , then he has either the lowest skill level in his team or there exists another contestant with skill level of  
in the same team. Also, no two contestants of the same team should have same skill level. Note that a contestant can write buggy code and thus can have a negative skill level.
The more contestants on the team, the more problems they can attempt at a time. So, Roy wants to form teams such that the smallest team is as large as possible.

Input Format
-----------
The first line of input contains , the number of test cases.Each case contains an integer , the number of contestants, followed by  space separated integers.
 The  integer denotes the skill level of  contestant. The absolute values of skill levels will not exceed .The total number of contestants in all cases will not exceed .

Output Format
-------------
For each test case, print the size of smallest team in a separate line.
 * */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       
    	Scanner in=new Scanner(System.in);
  
    	long testCases=in.nextLong();
    	long[][]arr=new long[(int) testCases][];
    	for(int i=0;i<testCases;++i)
    	{
    		long j=in.nextLong();
    		arr[i]=new long[(int) j];
    		
    		for(int k=0;k<j;++k)
    		{
    			arr[i][k]=in.nextLong();
    		}
    		
    		arr[i]=sortDesc(arr[i],0,arr[i].length-1);
    		
    		
    	}
    	
    	
    	for(int i=0;i<testCases;++i){
    		int min=1,groupA=1,prev=-1;
    		
    		if(arr[i].length>0){
    		for(int j=0;j<arr[i].length-1;++j){
    
    			groupA=1;
    				while(arr[i][j]-arr[i][j+1]==1)
    				{
    					++groupA;
    					++j;
    					if(j==arr[i].length-1)
    						break;
    				}
    				if(prev==-1)
    					{
    					prev=groupA;
    					min=prev;
    					}
    				else
    				{
    					if(prev<groupA)
    						min=prev;
    					else{
    						min=groupA;
    						prev=groupA;
    					}
    					
    				/*	if(i+1==7)
    			System.out.println(min+"(min) "+prev+"(prev) "+groupA+" (now)");*/
    				}
     
    				
    		}
    		
    		System.out.println(min);
    		}
    		else 
        		System.out.println(0);
    	}
    	
    	
    }
    
    public static long[] sortDesc(long[]arr,int from,int to)
	{
    	if(to<=from)
    		return arr;
    	int mid=(from+to)/2;
    	
    	sortDesc(arr,from,mid);
    	sortDesc(arr,mid+1,to);
    	
    	merge(arr,from,to);
    	
    	return arr;
    	
	}
    
    private static long[] merge(long[]a,int from,int to)
    {
    	int mid=(from+to)/2;
    	int numLeft=(mid-from)+1;//including mid-element
    	
    	long[]left=new long[numLeft];
    	long[]right=new long[(to-mid)]; //excluding mid
        
    	int i=0;
    	int k=from;
    	while(i<left.length){
    		left[i]=a[k];++i;++k;
    	}
    	int j=0;
    	while(j<right.length){
    		right[j]=a[k];++j;++k;
    	}
    	
    	 j=0;i=0;k=from;
    	
    	while(i<left.length && j<right.length)
    	{
    		if(left[i]>right[j]){
    			a[k]=left[i];++i;++k;
    		}
    		else{
    			a[k]=right[j];++j;++k;
    		}
    	}
    	
    	while(i<left.length)
    	{
    		a[k]=left[i];++i;++k;
    	}
    	
    	while(j<right.length)
    	{
    		a[k]=right[j];++j;++k;
    	}
		    	
    	return a;
    	
    	
    }

}
