package com.ecommerce.notification.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document("notification")
public class Notification {
    @Id
    private UUID id;
    private UUID userId;
    private String message;
}
