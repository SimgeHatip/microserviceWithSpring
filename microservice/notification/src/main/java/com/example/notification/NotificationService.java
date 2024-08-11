package com.example.notification;

import com.example.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void sendRegisterNotification(NotificationRequest notificationRequest) {

        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("SimgeMicroservice")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}
