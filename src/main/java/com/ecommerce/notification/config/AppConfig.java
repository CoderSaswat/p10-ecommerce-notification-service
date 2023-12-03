package com.ecommerce.notification.config;

import com.ecommerce.notification.mapper.PatchMapper;
import com.ecommerce.notification.repository.NotificationRepository;
//import com.ecommerce.notification.service.NotificationListenerService;
import com.ecommerce.notification.service.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AppConfig {

  @Value("${email}")
  private String email;

  @Value("${password}")
  private String password;

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }


  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public PatchMapper patchMapper() {
    PatchMapper patchMapper = new PatchMapper();
    patchMapper.getConfiguration().setMatchingStrategy( MatchingStrategies.STRICT )
            .setPropertyCondition( Conditions.isNotNull() );
    return patchMapper;
  }

//  @Bean
//  public NotificationListener notificationListenerService(SqsClient sqsClient,
//                                                          NotificationService notificationService,
//                                                          ObjectMapper objectMapper) {
//    return new NotificationListener(sqsClient, notificationService, objectMapper);
//  }

//  @Bean
//  public SqsClient sqsClient() {
//    AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(email, password);
//    return SqsClient.builder()
//            .region(Region.US_EAST_1)
//            .credentialsProvider(() -> awsCredentials)
//            .build();
//  }

//  @Bean
//  public NotificationListenerService notificationListenerService(SqsClient sqsClient,
//                                                                 NotificationRepository notificationRepository,
//                                                                 ObjectMapper objectMapper) throws JsonProcessingException {
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

}
