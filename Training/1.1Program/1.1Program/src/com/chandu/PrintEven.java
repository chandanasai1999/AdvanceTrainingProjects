package com.chandu;


import java.util.Scanner;

public class PrintEven {
	 
	    public static void main(String []args) {
	    	
	    	Scanner scanner=new Scanner(System.in);
	        System.out.println("Enter the highest number");
	    	int n=scanner.nextInt();
	         
	        
	         
	        for(int i=1;i<n;i++) {
	        	if(i%2==0) {
	        		System.out.println("The number is ="+i);
	        	}
	        }
	    }
}