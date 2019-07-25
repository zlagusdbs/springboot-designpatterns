package com.kim.framework.producerconsumer;

import com.kim.framework.producerconsumer.consumer.Consumer;
import com.kim.framework.producerconsumer.producer.Producer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProducerConsumerExecutor<P extends Producer, C extends Consumer> extends ProducerConsumer {
	private int threadPoolCount = 1;

	public void setThreadPoolCount(int threadPoolCount) {
		this.threadPoolCount = threadPoolCount;
	}


	public boolean submit() throws InterruptedException {
		boolean result = false;
		ArrayList<Future<Boolean>> arrFutures = new ArrayList<Future<Boolean>>();

		ExecutorService executorService = Executors.newFixedThreadPool(this.threadPoolCount);

		Iterator iteratorProducer = super.producers.iterator();
		while (iteratorProducer.hasNext()) {
			executorService.submit((Producer) iteratorProducer.next());
		}

		Iterator iteratorConsumer = super.consumers.iterator();
		while (iteratorConsumer.hasNext()) {
			arrFutures.add(executorService.submit((Consumer) iteratorConsumer.next()));
		}

		executorService.shutdown();

		return (result = executorService.isShutdown());
	}
}