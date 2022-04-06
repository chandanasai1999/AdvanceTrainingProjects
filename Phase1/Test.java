package com.mphasis.serialization;

public class Test {
	public static void main(String[] args) {
		Sender sender=new Sender();
	
		//object want to share between multiple thread
		
		User user1=new User("Chandana",sender);
		User user2=new User("radhika",sender);
		
		user1.start();
		user2.start();
				
				
		}

}
