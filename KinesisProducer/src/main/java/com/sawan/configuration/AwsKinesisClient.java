package com.sawan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;

//@Configuration
public class AwsKinesisClient {

	private static final String AWS_ACCESS_KEY="aws.accessKeyId";
	private static final String AWS_SECRET_KEY="aws.secretKey";
	
	static
	{
		System.setProperty(AWS_ACCESS_KEY,"AKIA3UWQGZRERJQP5LCN");
		System.setProperty(AWS_SECRET_KEY,"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");
	}

	//@Bean
	public static AmazonKinesis getKinesisClient()
	{
		return AmazonKinesisClientBuilder.standard()
				.withRegion(Regions.US_EAST_1)
				.build();
	}
}
