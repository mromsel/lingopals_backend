package com.romsel.lingopals_backend.users_related.users.domain.user_info;

import java.util.List;

import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_progress.domain.UserProgressData;

import lombok.Data;

@Data
public class UserInfo {
    UserProgressData userProgressData;
    List<UserLanguages> userLanguages;
}
