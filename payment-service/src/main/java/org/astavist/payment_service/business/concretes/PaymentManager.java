package org.astavist.payment_service.business.concretes;

import lombok.AllArgsConstructor;
import org.astavist.payment_service.business.abstracts.PaymentService;
import org.astavist.payment_service.business.dto.requests.CreatePaymentRequest;
import org.astavist.payment_service.business.dto.requests.UpdatePaymentRequest;
import org.astavist.payment_service.business.dto.responses.CreatePaymentResponse;
import org.astavist.payment_service.business.dto.responses.GetAllPaymentsResponse;
import org.astavist.payment_service.business.dto.responses.GetPaymentResponse;
import org.astavist.payment_service.business.dto.responses.UpdatePaymentResponse;
import org.astavist.payment_service.entity.Payment;
import org.astavist.payment_service.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentRepository repository;
    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments = repository.findAll();

        List<GetAllPaymentsResponse> response = new ArrayList<>();
        for (Payment payment : payments) {
            GetAllPaymentsResponse response1 = new GetAllPaymentsResponse();
            response1.setCost(payment.getCost());
            response1.setId(payment.getId());
            response1.setMonth(payment.getMonth());
            response.add(response1);
        }
        return response;
    }

    @Override
    public GetPaymentResponse getById(UUID id) {
        var payment = repository.findById(id).orElseThrow();
        GetPaymentResponse response = new GetPaymentResponse();
        response.setId(payment.getId());
        response.setCost(payment.getCost());
        response.setMonth(payment.getMonth());
        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        var payment = new Payment();
        payment.setCost(request.getCost());
        payment.setMonth(request.getMonth());
        payment.setId(UUID.randomUUID());
        repository.save(payment);

        CreatePaymentResponse response = new CreatePaymentResponse();
        response.setId(payment.getId());
        response.setCost(payment.getCost());
        response.setMonth(payment.getMonth());

        return response;
    }

    @Override
    public UpdatePaymentResponse update(UUID id, UpdatePaymentRequest request) {
        var payment2 = new Payment();
        payment2.setMonth(request.getMonth());
        payment2.setCost(request.getCost());
        payment2.setId(id);
        repository.save(payment2);

        UpdatePaymentResponse response = new UpdatePaymentResponse();
        response.setId(payment2.getId());
        response.setCost(payment2.getCost());
        response.setMonth(payment2.getMonth());

        return response;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
