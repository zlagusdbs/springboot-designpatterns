package com.kim.service.producersonsumer;

import com.kim.framework.producerconsumer.producer.Producer;

import java.util.Iterator;
import java.util.List;

public class KimProducer extends Producer {
	@Override
	public void run() {
		super.blockingQueue.add( "Kim1" );
		super.blockingQueue.add( "Kim2" );
		super.blockingQueue.add( "Kim3" );

		super.closeProducer();

		return;
	}
}
