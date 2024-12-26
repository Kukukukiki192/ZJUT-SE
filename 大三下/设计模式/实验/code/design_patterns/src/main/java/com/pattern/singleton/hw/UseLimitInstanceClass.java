package com.pattern.singleton.hw;

public class UseLimitInstanceClass {
	public static void main(String args[]) {
		final int N=10;
		AccessLimitInstanceClassThread t[]=new AccessLimitInstanceClassThread[N];
		for(int i=0;i<N;i++){
			t[i]=new AccessLimitInstanceClassThread("thread"+i);
			t[i].start();
		}
	}
}