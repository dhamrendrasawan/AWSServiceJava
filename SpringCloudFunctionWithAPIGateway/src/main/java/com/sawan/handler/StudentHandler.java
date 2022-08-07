package com.sawan.handler;

import java.util.List;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.sawan.entity.Student;


public class StudentHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent,List<Student>> {
}