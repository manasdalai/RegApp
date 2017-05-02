package com.sb.app;

public class SecondClass {
	
	public static void main(String[] args) {
		Thread th2 = new Thread(() -> {
			while (true) {
				RegApp.req2();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
				}
			}
		});
		
		th2.start();
		
	}

}
