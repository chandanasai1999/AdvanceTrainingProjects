package com.progrms.phase1;

import java.util.Scanner;

public class SimpleInterest {
	public static void main(String[] args) {
		{
			float p,r,t,sinterest;
			Scanner  Scan= new Scanner(System.in);
			System.out.println("Enter the principal:");
			p= Scan.nextFloat();
			System.out.println("Enter the rate of interest:");
			r= Scan.nextFloat();
			System.out.println("Enter the time period:");
			t= Scan.nextFloat();
			Scan.close();
			sinterest = (p*r*t)/100;
			Scan.close();
			sinterest = (p*r*t)/100;
			System.out.println("Simple interest is:" +sinterest);
			
			
				
		}
	}

}
