package com.sawan.configuration;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AmazonSNSConfiguration {

	public AmazonSNSClient amazonSNSClient()
	{
		return (AmazonSNSClient) AmazonSNSClientBuilder
				 .standard()
			     .withRegion(Regions.US_EAST_1)
				 .withCredentials(						 
				       new AWSStaticCredentialsProvider(
				       new BasicAWSCredentials("AKIA3UWQGZREUQPL2PVU","E2uwLbUTF6de/7EkSOXwl0n0T9BPLQ0a+uJHcc9x")							  
				                   )
	                       ).build();
	     }
	}
