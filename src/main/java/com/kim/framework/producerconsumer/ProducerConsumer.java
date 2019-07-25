package com.kim.framework.producerconsumer;

import com.kim.framework.producerconsumer.consumer.Consumer;
import com.kim.framework.producerconsumer.producer.Producer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public abstract class ProducerConsumer<P extends Producer, C extends Consumer> extends ProducerConsumerVariable implements ProducerConsumerHandler<P, C>{
	private TheQueue theQueue = new TheQueue();

	List<P> producers = new ArrayList();
	List<C> consumers = new ArrayList();

	public BlockingQueue getBlockingQueueInTheQueue(){
		return this.theQueue.getBlockingQueue();
	}

	public ProducerConsumer addProducer(P producer) {
		producer.setBlockingQueue( this.theQueue.getBlockingQueue() );
		boolean result = this.producers.add(producer);
		if (result) {
			super.increaseProducerCount();
		}

		return this;
	}

	public ProducerConsumer endProducer(P producer) {
		boolean result = this.producers.remove(producer);
		if (result) {
			super.increaseProducerEndCount();
			if (producerCount == producerEndCount) {
				Iterator iteratorConsumers = consumers.iterator();
				while (iteratorConsumers.hasNext()) {
					iteratorConsumers.next().notify();
				}
			}
		}

		return this;
	}

	public ProducerConsumer addConsumer(C consumer) {
		consumer.setBlockingQueue( this.theQueue.getBlockingQueue() );
		boolean result = this.consumers.add(consumer);
		if (result) {
			super.increaseConsumerCount();
		}

		return this;
	}

	public ProducerConsumer endConsumer(C consumer) {
		boolean result = this.consumers.remove(consumer);
		if (result) {
			super.increaseConsumerEndCount();
		}

		return this;
	}
}
