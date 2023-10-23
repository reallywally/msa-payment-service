package com.wally.ps.api.service;

import com.wally.ps.api.entity.Payment;
import com.wally.ps.api.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    // 무작위로 성공했는지 테스트용
    public String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "false";
    }
}
