package com.amigoscode.notification;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    @Id
    @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
    @GeneratedValue(generator = "notification_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer notificationId;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
