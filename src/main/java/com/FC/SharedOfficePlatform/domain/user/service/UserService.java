package com.FC.SharedOfficePlatform.domain.user.service;

import com.FC.SharedOfficePlatform.domain.user.dto.request.SignUpRequest;
import com.FC.SharedOfficePlatform.domain.user.dto.response.SignUpResponse;
import com.FC.SharedOfficePlatform.domain.user.entity.User;
import com.FC.SharedOfficePlatform.domain.user.exception.UserAlreadyRegisteredException;
import com.FC.SharedOfficePlatform.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.email())) {
            throw new UserAlreadyRegisteredException();
        }
        User user = signUpRequest.toEntity(signUpRequest.password());
        return SignUpResponse.from(user);
    }
}
