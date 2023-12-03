package com.ecommerce.notification.service;


import com.ecommerce.notification.dto.NotificationDto;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    NotificationDto getNotification(UUID notificationId);
    List<NotificationDto> getNotificationsByUser(UUID userId);
    NotificationDto createNotification(NotificationDto notificationDto);

    void startListening();
}
