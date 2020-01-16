package com.example.desafioSpring.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.example.desafioSpring.domain.validators.clientvalidator.Phone;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientCreateRequest {

    @NotEmpty(message = "name is required")
    private String name;

    @Phone(message = "phone is invalid")
    @NotEmpty(message = "phone is required")
    private String phone;
}