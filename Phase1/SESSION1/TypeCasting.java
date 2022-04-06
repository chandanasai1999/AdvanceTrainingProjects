package com.progrms.phase1;

public class TypeCasting {
	public static void main(String[] args) {
		//Implicit conversion
		System.out.println("implicit type Casting");
		char a='A';
		System.out.println("value of a"+a);
		int b=a;
		System.out.println("value of Int"+b);
		float c=b;
		System.out.println("value of Float"+c);
		double d=b;
		System.out.println("value of Double"+d);
		long e=b;
		System.out.println("value of long"+e);
		System.out.println("Explicit Type conversion");
		double x=89.90;
		int y= (int)x;
		System.out.println("value of x"+x);
		System.out.println("value of y"+y);
		
	}

}
