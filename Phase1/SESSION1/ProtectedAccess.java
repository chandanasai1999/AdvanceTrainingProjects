package com.progrms.phase1;
import com.progrms.phase1.AccessSpecifier;
public class ProtectedAccess extends AccessSpecifier{
	public static void main(String[] args) {
		AccessSpecifier p=new AccessSpecifier();
		p.display();
		//p.test();
		//child can access protected property but not private
		}

}
