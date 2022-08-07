package com.sawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class SNSController {

	@Autowired
	AmazonSNSClient amazonSNSClient;
	
	private String topicArn="arn:aws:sns:us-east-1:800374312009:my-sns-topic";
	
	
	@GetMapping("/subscribe/{email}")
	public String subscribeToSNSTopic(@PathVariable("email") String email)
	{
		SubscribeRequest subscribeRequest=new SubscribeRequest(topicArn,"email",email);	
		amazonSNSClient.subscribe(subscribeRequest);
		return "check your mail";
	}
	
	@GetMapping("/publish/{msg}")
	public String publishToTopic(@PathVariable("msg") String msg)
	{
		PublishRequest publishRequest=new PublishRequest(topicArn,msg,"SNS spring boot") ;
		amazonSNSClient.publish(publishRequest);
		return "Message Published";
	}
}
