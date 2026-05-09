package com.medilabo.client_ui.feign;

import com.medilabo.note.api.NoteApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "note-client", url = "${app.gateway-url}/note-microservice", configuration = FeignSecurityConfig.class)
public interface NoteProxy extends NoteApi {
}
