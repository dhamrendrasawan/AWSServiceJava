package com.sawan;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.model.PutRecordsRequest;
import com.amazonaws.services.kinesis.model.PutRecordsRequestEntry;
import com.amazonaws.services.kinesis.model.PutRecordsResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sawan.configuration.AwsKinesisClient;
import com.sawan.model.Order;

//@SpringBootApplication
public class KinesisProducerApplication {

	Random random=new Random();
	List<String> productList=new ArrayList<>();
		
	//@Autowired
	//AmazonKinesis amazonKinesis;
	
	public static void main(String[] args) throws InterruptedException {
	//	SpringApplication.run(KinesisProducerApplication.class, args);
		KinesisProducerApplication kinesisapp=new KinesisProducerApplication();
				
		kinesisapp.populateProductList();
		//get client
		 //1. get client
        AmazonKinesis kinesisClient = AwsKinesisClient.getKinesisClient();
        
     
        while(true){
        	kinesisapp.sendData(kinesisClient);
            Thread.sleep(20000);
        }
	}
	
	  private void sendData(AmazonKinesis kinesisClient){
	        //2. PutRecordRequest
	        PutRecordsRequest recordsRequest = new PutRecordsRequest();
	        recordsRequest.setStreamName("Order-stream");
	        recordsRequest.setRecords(getRecordsRequestList());

	        //3. putRecord or putRecords - 500 records with single API call
	        PutRecordsResult results = kinesisClient.putRecords(recordsRequest);
	        if(results.getFailedRecordCount() > 0){
	            System.out.println("Error occurred for records " + results.getFailedRecordCount());
	        } else {
	            System.out.println("Data sent successfully...");
	        }

	    }
	  
	private List<PutRecordsRequestEntry> getRecordsRequestList()
	{
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		List<PutRecordsRequestEntry> putRecordsRequestEntry=new ArrayList<>();
		int i=1;
		for(Order order:getOrderList())
		{
			System.out.println("count= "+i++);
			System.out.println("order data="+"orderid="+order.getOrderId()+"product="+order.getProduct()+"quantity="+order.getQuantity());
			PutRecordsRequestEntry requestEntry=new PutRecordsRequestEntry();
			requestEntry.setData(ByteBuffer.wrap(gson.toJson(order).getBytes()));
			requestEntry.setPartitionKey(UUID.randomUUID().toString());
			putRecordsRequestEntry.add(requestEntry);
			
		}
		return putRecordsRequestEntry;
	}
	
	public List<Order> getOrderList()
	{
		List<Order> orders=new ArrayList<>();
		for(int i=0;i<2;i++)
		{
			Order order=new Order();
			order.setOrderId(random.nextInt());
			order.setProduct(productList.get(random.nextInt(productList.size())));
			order.setQuantity(random.nextInt(28));
			orders.add(order);
		}
		return orders;
	}

	public void populateProductList()
	{
		productList.add("Shirt");
		productList.add("T-Shirt");
		productList.add("Frock");
		productList.add("Pant");
		productList.add("Jeans");
		productList.add("Shoes");
		productList.add("Shock");
	}
}
