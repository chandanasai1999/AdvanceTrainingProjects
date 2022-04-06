package com.progrms.phase1;

public class  AccessSpecifier {
 protected void display()
 {
	
	 System.out.println("you are accessing protected method of this class");
	 
 
 }
 public AccessSpecifier() {
	// TODO Auto-generated constructor stub
}
 private void test()
 {
	 System.out.println("My Private Method");
 }
 public void hello()
 {
	 System.out.println("Public Method");
	 
 }
 void world()
 {
	 System.out.println("Default Method");
 } 
	 //Access all methods in same class
	 
	 public static void main(String[] args) {
AccessSpecifier obj= new AccessSpecifier();
obj.display(); //able to call private method
obj.test(); //able to call private method
obj.hello();//able to call public method
obj.world();//able to call default method

	
 }
}
