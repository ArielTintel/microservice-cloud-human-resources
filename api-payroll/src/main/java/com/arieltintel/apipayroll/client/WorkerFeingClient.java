package com.arieltintel.apipayroll.client;

import com.arieltintel.apipayroll.dto.WorkerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-worker", path = "/v1/workers")
public interface WorkerFeingClient {

    @GetMapping("/{id}")
    WorkerDto findById(@PathVariable Long id);

}
