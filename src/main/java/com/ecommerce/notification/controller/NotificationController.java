package com.ecommerce.notification.controller;

import com.ecommerce.notification.dto.NotificationDto;
import com.ecommerce.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/{notificationId}")
    public NotificationDto getNotification(@PathVariable UUID notificationId) {
        return notificationService.getNotification(notificationId);
    }

    @GetMapping("/user/{userId}")
    public List<NotificationDto> getNotificationsByUser(@PathVariable UUID userId) {
        return notificationService.getNotificationsByUser(userId);
    }

    @PostMapping
    public NotificationDto createNotification(@RequestBody NotificationDto notificationDto) {
        return notificationService.createNotification(notificationDto);
    }
}
