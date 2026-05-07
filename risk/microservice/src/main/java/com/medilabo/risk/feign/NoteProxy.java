package com.medilabo.risk.feign;

import com.medilabo.note.api.NoteApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "note-microservice", configuration = FeignSecurityConfig.class)
public interface NoteProxy extends NoteApi {
}
