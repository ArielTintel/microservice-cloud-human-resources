package com.arieltintel.oauth.service;

import com.arieltintel.oauth.clients.UserFeignClient;
import com.arieltintel.oauth.dto.UserDto;
import com.arieltintel.oauth.exception.UserNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public UserDto findByEmail(String email) {
        try {
            return userFeignClient.findByEmail(email);
        } catch (FeignException.NotFound e) {
            throw new UserNotFoundException();
        }
    }

}
