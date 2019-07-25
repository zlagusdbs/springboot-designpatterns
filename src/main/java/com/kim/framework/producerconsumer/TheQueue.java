package com.kim.framework.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TheQueue<T> {
	private BlockingQueue<T> blockingQueue = new LinkedBlockingQueue<>();

	public BlockingQueue<T> getBlockingQueue(){
		return this.blockingQueue;
	}
}
