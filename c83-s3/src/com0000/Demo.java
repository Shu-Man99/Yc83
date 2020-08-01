package com0000;

public class Demo {

	public static void main(String[] args) {
		System.out.println("123");
		// TODO Auto-generated method stub
		Thread t1 = new Thread("线程1") {
			public void run() {
				for(int i=0;i<1000;i++) {
					System.out.println(Thread.currentThread().getName()+"."+i);
				}
			}
		};
		Thread t2 = new Thread("----------线程2") {
			public void run() {
				for(int i=0;i<1000;i++) {
					System.out.println(Thread.currentThread().getName()+"."+i);
					try {
						if(i==500)
						t1.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		t2.start();
	}
	
}
