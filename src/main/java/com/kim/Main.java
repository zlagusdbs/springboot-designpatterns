package com.kim;

import com.kim.framework.producerconsumer.ProducerConsumerExecutor;
import com.kim.service.producersonsumer.CommonConsumer;
import com.kim.service.producersonsumer.KimProducer;
import com.kim.service.producersonsumer.LeeProducer;

import java.util.concurrent.ExecutionException;

public class Main {
	public Main(){
		this.producerConsumerExecutor = new ProducerConsumerExecutor();
		this.kimProducer = new KimProducer();
		this.leeProducer = new LeeProducer();
		this.commonConsumer = new CommonConsumer();
	}

	ProducerConsumerExecutor producerConsumerExecutor;
	KimProducer kimProducer;
	LeeProducer leeProducer;
	CommonConsumer commonConsumer;

	public static void main(String[] args) {
		Main main = new Main();
		try {
			main.execute();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public boolean execute( ) throws ExecutionException, InterruptedException {
		producerConsumerExecutor.setThreadPoolCount(3);
		producerConsumerExecutor.addProducer(kimProducer);
		producerConsumerExecutor.addProducer(leeProducer);
		producerConsumerExecutor.addConsumer(commonConsumer);

		return producerConsumerExecutor.submit();
	}
}
