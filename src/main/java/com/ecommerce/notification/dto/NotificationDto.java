package com.ecommerce.notification.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class NotificationDto {
    private UUID id;
    private UUID userId;
    private String message;
}
