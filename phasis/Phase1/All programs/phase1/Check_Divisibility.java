package com.progrms.phase1;

import java.util.Scanner;

public class Check_Divisibility {
	public static void main(String[] args) {
		{
			int n; 
			Scanner s = new Scanner (System.in);
			System.out.println("Enter any number:");
			n= s.nextInt();
			if(n%5 == 0)
			{
				System.out.println(n+"is divisible by 5:");
				
			}
			else
			{
				System.out.println(n+"is notdivisible by 5:");
			}
			
		}
	}

}
