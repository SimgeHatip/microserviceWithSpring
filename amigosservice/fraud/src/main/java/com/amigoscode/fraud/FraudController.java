package com.amigoscode.fraud;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor

public class FraudController {
    private final FraudCheckService fraudCheckService;
    private final NotificationClient notificationClient;

    @GetMapping(path ="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
