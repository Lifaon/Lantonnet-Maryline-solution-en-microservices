package com.medilabo.client_ui.feign;

import com.medilabo.note.api.NoteApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "note-microservice")
public interface NoteProxy extends NoteApi {
}
