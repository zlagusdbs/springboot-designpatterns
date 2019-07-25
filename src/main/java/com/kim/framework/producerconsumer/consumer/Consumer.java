package com.kim.framework.producerconsumer.consumer;

import com.kim.framework.producerconsumer.ProducerConsumerVariable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public abstract class Consumer<T> extends ProducerConsumerVariable implements Callable {
	public BlockingQueue<T> blockingQueue;

	public void setBlockingQueue(BlockingQueue<T> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void closeConsumer() {
		boolean result = super.increaseConsumerEndCount();
		if (result)
			this.blockingQueue.notify();
	}
}
