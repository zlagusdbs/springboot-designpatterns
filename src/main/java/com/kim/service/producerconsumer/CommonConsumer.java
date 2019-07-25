package com.kim.service.producersonsumer;

import com.kim.framework.producerconsumer.consumer.Consumer;

public class CommonConsumer<T> extends Consumer<T> {
	public Boolean call() {
		boolean result = false;
		try {
			System.out.println( this.blockingQueue.take() );
		} catch (Exception e) {
		}

		return (Boolean) (result = true);
	}
}
