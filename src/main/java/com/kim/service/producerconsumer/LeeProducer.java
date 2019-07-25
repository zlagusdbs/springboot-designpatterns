package com.kim.service.producersonsumer;

import com.kim.framework.producerconsumer.producer.Producer;

public class LeeProducer extends Producer {
	@Override
	public void run() {
		super.blockingQueue.add( "Lee1" );
		super.blockingQueue.add( "Lee2" );
		super.blockingQueue.add( "Lee3" );

		super.closeProducer();

		return;
	}
}