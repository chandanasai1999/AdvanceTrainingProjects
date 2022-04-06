package com.progrms.phase1;

public class CheckAccessIntAnotherPackage {
public static void main(String[] args) {
	AccessSpecifier obj= new AccessSpecifier();
	obj.display(); //able to call private method
	//obj.test(); //notable to call private method
	obj.hello();//able to call public method
	obj.world();//able to call default method


}
}
