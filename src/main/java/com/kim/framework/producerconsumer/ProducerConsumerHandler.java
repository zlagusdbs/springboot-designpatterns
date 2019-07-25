package com.kim.framework.producerconsumer;

import com.kim.framework.producerconsumer.consumer.Consumer;
import com.kim.framework.producerconsumer.producer.Producer;

public interface ProducerConsumerHandler<P extends Producer, C extends Consumer> {
	ProducerConsumer addProducer(P producer);
	ProducerConsumer endProducer(P producer);

	ProducerConsumer addConsumer(C consumer);
	ProducerConsumer endConsumer(C consumer);
}
