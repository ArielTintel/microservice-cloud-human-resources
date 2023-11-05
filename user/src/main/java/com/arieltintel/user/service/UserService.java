package com.arieltintel.user.service;

import com.arieltintel.user.entities.User;
import com.arieltintel.user.exception.UserNotFoundException;
import com.arieltintel.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
       return userRepository.findById(id).orElseThrow(() ->
               new UserNotFoundException("Usuário não encontrado")
       );
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UserNotFoundException("Usuário não encontrado")
        );
    }

}
