package com.ecommerce.notification.service.impl;

import com.ecommerce.notification.dto.NotificationDto;
import com.ecommerce.notification.model.Notification;
import com.ecommerce.notification.repository.NotificationRepository;
import com.ecommerce.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final ModelMapper modelMapper;

    @Override
    public NotificationDto getNotification(UUID notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        return modelMapper.map(notification, NotificationDto.class);
    }

    @Override
    public List<NotificationDto> getNotificationsByUser(UUID userId) {
        List<Notification> userNotifications = notificationRepository.findByUserId(userId);
        return userNotifications.stream()
                .map(notification -> modelMapper.map(notification, NotificationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        Notification notification = modelMapper.map(notificationDto, Notification.class);
        notification.setId(UUID.randomUUID());
        Notification savedNotification = notificationRepository.save(notification);
        return modelMapper.map(savedNotification, NotificationDto.class);
    }

    @Override
    public void startListening() {
        System.out.println("from service");
    }
}
