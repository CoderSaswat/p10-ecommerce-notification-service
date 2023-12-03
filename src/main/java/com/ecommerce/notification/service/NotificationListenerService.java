//package com.ecommerce.notification.service;
//
//import com.ecommerce.notification.dto.NotificationDto;
//import com.ecommerce.notification.repository.NotificationRepository;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import software.amazon.awssdk.services.sqs.SqsClient;
//import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
//import software.amazon.awssdk.services.sqs.model.Message;
//import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NotificationListenerService {
//    private final SqsClient sqsClient;
//    private final NotificationRepository notificationRepository;
//    private final ObjectMapper objectMapper;
//
////    @PostConstruct
////    public void init() throws JsonProcessingException {
////        startListening();
////    }
//
//    @Async
//    public void startListening() throws JsonProcessingException {
//        String queueName = "q_notification";
//        GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder()
//                .queueName(queueName)
//                .build();
//        String queueUrl = sqsClient.getQueueUrl(getQueueUrlRequest).queueUrl();
//
//        while (true) {
//            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
//                    .queueUrl(queueUrl)
//                    .maxNumberOfMessages(1)
//                    .waitTimeSeconds(20)  // Long polling to reduce empty responses
//                    .build();
//
//            List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
//
//            for (Message message : messages) {
//                String messageBody = message.body();
//                System.out.println("Received message: " + messageBody);
//                NotificationDto notificationDto = objectMapper.readValue(messageBody, NotificationDto.class);
//
//                // Perform further actions based on the received message
//                // You can deserialize the messageBody if it contains serialized data (e.g., JSON)
//
//                // Save the notification to the repository
//                saveNotification(notificationDto);
//
//                // Delete the message from the queue
//                sqsClient.deleteMessage(builder -> builder.queueUrl(queueUrl).receiptHandle(message.receiptHandle()));
//            }
//        }
//    }
//
//
//
//    private void saveNotification(NotificationDto notificationDto) {
//        // Convert NotificationDto to your Notification entity and save it to the repository
//        // (Assuming NotificationRepository has a save method)
//        // Notification notification = convertToNotification(notificationDto);
//        // notificationRepository.save(notification);
//        // Implement this method based on your entity structure and mapping logic
//    }
//
//}
