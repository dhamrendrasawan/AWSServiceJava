package com.sawan;

import java.nio.charset.StandardCharsets;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

public class Order_Lambda {

	public String handleRequest(KinesisEvent event,Context context)
	{
		for(KinesisEvent.KinesisEventRecord record:event.getRecords())
		{
			
			String data = StandardCharsets.UTF_8.decode(record.getKinesis().getData()).toString();
			  System.out.println("data= "+data);
		}
	   return "SUCCESS";
    }
}
