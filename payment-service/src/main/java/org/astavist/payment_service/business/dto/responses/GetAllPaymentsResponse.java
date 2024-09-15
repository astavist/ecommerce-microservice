package org.astavist.payment_service.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPaymentsResponse {
    private UUID id;
    private UUID employeem;
    private String month;
    private int cost;
}
