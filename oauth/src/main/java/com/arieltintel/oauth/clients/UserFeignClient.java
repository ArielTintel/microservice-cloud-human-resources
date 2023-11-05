package com.arieltintel.oauth.clients;

import com.arieltintel.oauth.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-user", path = "v1/users")
public interface UserFeignClient {

    @GetMapping("/{email}/email")
    UserDto findByEmail(@PathVariable String email);

    @GetMapping("/{id}/id")
    UserDto findById(@PathVariable Long id);

}
