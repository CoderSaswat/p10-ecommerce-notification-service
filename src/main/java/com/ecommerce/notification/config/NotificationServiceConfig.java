//package com.ecommerce.notification.config;
//
//import com.ecommerce.notification.mapper.PatchMapper;
//import com.ecommerce.notification.repository.NotificationRepository;
//import com.ecommerce.notification.service.NotificationListenerService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.modelmapper.Conditions;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.sqs.SqsClient;
//
//@Configuration
//public class NotificationServiceConfig {
//
//  @Value("${email}")
//  private String email;
//
//  @Value("${password}")
//  private String password;
//
//
//  @Bean
//  public NotificationListenerService notificationListenerService(SqsClient sqsClient,
//                                                                 NotificationRepository notificationRepository,
//                                                                 ObjectMapper objectMapper) {
//    return new NotificationListenerService(sqsClient, notificationRepository, objectMapper);
//  }
//
//  @Bean
//  public SqsClient sqsClient() {
//    AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(email, password);
//    return SqsClient.builder()
//            .region(Region.US_EAST_1)
//            .credentialsProvider(() -> awsCredentials)
//            .build();
//  }
//
//
//}
