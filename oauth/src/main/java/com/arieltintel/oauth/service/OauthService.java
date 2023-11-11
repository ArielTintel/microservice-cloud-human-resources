package com.arieltintel.oauth.service;

import com.arieltintel.oauth.clients.UserFeignClient;
import com.arieltintel.oauth.entities.User;
import com.arieltintel.oauth.exception.UserNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OauthService implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return userFeignClient.findByEmail(email);
        } catch (FeignException.NotFound | UsernameNotFoundException e) {
            throw new UserNotFoundException();
        }
    }

}
