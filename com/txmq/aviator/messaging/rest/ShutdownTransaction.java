package com.txmq.aviator.messaging.rest;

import com.txmq.aviator.core.Aviator;
import com.txmq.aviator.core.swirlds.AviatorSwirldsState;
import com.txmq.aviator.messaging.AviatorCoreTransactionTypes;
import com.txmq.aviator.messaging.AviatorMessage;
import com.txmq.aviator.pipeline.PlatformEvents;
import com.txmq.aviator.pipeline.metadata.AviatorHandler;

/**
 * Allows for the system to be shutdown via REST API call
 * @author craigdrabik
 *
 */
public class ShutdownTransaction {

	@AviatorHandler(	namespace="AviatorCoreTransactionTypes",
					transactionType=AviatorCoreTransactionTypes.SHUTDOWN, 
					events= {PlatformEvents.executeConsensus})
	public AviatorMessage<?> shutdown(AviatorMessage<?> message, AviatorSwirldsState state) {
		
		Aviator.shutdown();	
		System.out.println("It is now safe to shut down.");
		
		return message;
	}
}
