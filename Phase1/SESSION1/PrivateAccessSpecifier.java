package com.progrms.phase1;

public class PrivateAccessSpecifier {
private int a=23;
public static void main(String[] args) {
	PrivateAccessSpecifier obj= new PrivateAccessSpecifier();
    System.out.println("value of a"+obj.a);
}		
}
