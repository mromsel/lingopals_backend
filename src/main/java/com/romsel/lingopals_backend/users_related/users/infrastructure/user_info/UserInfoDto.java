package com.romsel.lingopals_backend.users_related.users.infrastructure.user_info;

import java.util.List;

import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesDto;
import com.romsel.lingopals_backend.users_related.users_progress.infrastructure.UserProgressDataDto;

import lombok.Data;

@Data
public class UserInfoDto {

    UserProgressDataDto userProgressData;
    List<UserLanguagesDto> userLanguages;

}
