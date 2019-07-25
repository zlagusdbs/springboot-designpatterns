package com.kim.framework.producerconsumer;

public abstract class ProducerConsumerVariable {
	protected static Integer producerCount = 0;
	protected static Integer consumerCount = 0;

	protected static Integer producerEndCount = 0;
	protected static Integer consumerEndCount = 0;

	protected static void increaseProducerCount(){
		synchronized (producerCount) {
			ProducerConsumerVariable.producerCount++;
		}
	}

	protected static boolean increaseProducerEndCount(){
		synchronized (producerEndCount) {
			ProducerConsumerVariable.producerEndCount++;
		}

		return producerCount==producerEndCount;
	}

	protected static void increaseConsumerCount(){
		synchronized (consumerCount) {
			ProducerConsumerVariable.consumerCount++;
		}
	}

	protected static boolean increaseConsumerEndCount(){
		synchronized (consumerEndCount) {
			ProducerConsumerVariable.consumerEndCount++;
		}

		return consumerCount==consumerEndCount;
	}
}
