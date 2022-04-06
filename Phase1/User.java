package com.mphasis.serialization;

public class User extends Thread {
	private String name;
	private String msg;
	private Sender sender;
	
	public User(String msg, Sender sender)
	
	
	{
		this.name=name;
		this.msg=msg;
		this.sender=sender;
		
	}
	public void run()
	{
		//at a time only one thread can access this sender object
		synchronized (sender) {
			
		}
		sender.send(name,msg);
	}
}
