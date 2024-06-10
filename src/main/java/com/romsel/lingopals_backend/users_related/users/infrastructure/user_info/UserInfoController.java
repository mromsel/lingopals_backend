package com.romsel.lingopals_backend.users_related.users.infrastructure.user_info;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.auth.application.AuthResponse;
import com.romsel.lingopals_backend.users_related.users.application.user_info.UserInfoGetter;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserInfoController {

    private final ModelMapper modelMapper;

    private final UserInfoGetter userInfoGetter;

    @PostMapping("/me")
    public UserInfoDto getMe(@RequestBody AuthResponse token) {
        return modelMapper.map(userInfoGetter.getMe(token.getToken()), UserInfoDto.class);
    }

}
