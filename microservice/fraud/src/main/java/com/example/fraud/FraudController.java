package com.example.fraud;

import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.notification.NotificationClient;
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
