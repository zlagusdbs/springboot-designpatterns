package com.kim.framework.producerconsumer.producer;

import com.kim.framework.producerconsumer.ProducerConsumerVariable;

import java.util.concurrent.BlockingQueue;

public abstract class Producer<T> extends ProducerConsumerVariable implements Runnable {
	public BlockingQueue<T> blockingQueue;

	public void setBlockingQueue(BlockingQueue<T> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void closeProducer(){
		boolean result = super.increaseProducerEndCount();
		if( result )
//			Using a POISON_PILL
			this.blockingQueue.add( (T)new Object() );
	}
}
