package com.medilabo.client_ui.feign;

import com.medilabo.patient.api.PatientApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "patient-microservice")
public interface PatientProxy extends PatientApi {
}
