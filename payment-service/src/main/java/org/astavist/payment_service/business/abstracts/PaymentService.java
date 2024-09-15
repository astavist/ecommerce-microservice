package org.astavist.payment_service.business.abstracts;

import org.astavist.payment_service.business.dto.requests.CreatePaymentRequest;
import org.astavist.payment_service.business.dto.requests.UpdatePaymentRequest;
import org.astavist.payment_service.business.dto.responses.CreatePaymentResponse;
import org.astavist.payment_service.business.dto.responses.GetAllPaymentsResponse;
import org.astavist.payment_service.business.dto.responses.GetPaymentResponse;
import org.astavist.payment_service.business.dto.responses.UpdatePaymentResponse;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();

    GetPaymentResponse getById(UUID id);

    CreatePaymentResponse add(CreatePaymentRequest request);

    UpdatePaymentResponse update(UUID id, UpdatePaymentRequest request);

    void delete(UUID id);
}
