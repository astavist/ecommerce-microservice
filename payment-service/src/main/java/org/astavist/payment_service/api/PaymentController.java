package org.astavist.payment_service.api;

import lombok.AllArgsConstructor;
import org.astavist.payment_service.business.abstracts.PaymentService;
import org.astavist.payment_service.business.dto.requests.CreatePaymentRequest;
import org.astavist.payment_service.business.dto.requests.UpdatePaymentRequest;
import org.astavist.payment_service.business.dto.responses.CreatePaymentResponse;
import org.astavist.payment_service.business.dto.responses.GetAllPaymentsResponse;
import org.astavist.payment_service.business.dto.responses.GetPaymentResponse;
import org.astavist.payment_service.business.dto.responses.UpdatePaymentResponse;
import org.astavist.payment_service.business.producer.RabbitMQProducer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @GetMapping
    public List<GetAllPaymentsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePaymentResponse add(@RequestBody CreatePaymentRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable UUID id, @RequestBody UpdatePaymentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
