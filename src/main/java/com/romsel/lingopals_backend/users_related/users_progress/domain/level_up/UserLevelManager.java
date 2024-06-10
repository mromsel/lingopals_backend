package com.romsel.lingopals_backend.users_related.users_progress.domain.level_up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevel;
import com.romsel.lingopals_backend.masters.xp_levels.infrastructure.XPLevelService;
import com.romsel.lingopals_backend.users_related.users_progress.domain.UserProgressData;
import com.romsel.lingopals_backend.users_related.users_progress.infrastructure.UserProgressDataService;
import com.romsel.lingopals_backend.users_related.users_progress.infrastructure.level_up.UserLevelUpdateDto;

@Service
public class UserLevelManager {

    @Autowired
    private UserProgressDataService userProgressDataService;

    @Autowired
    private XPLevelService xpLevelService;

    public UserLevelUpdateDto addXP(Long idUser, Integer xpGained) {
        UserProgressData userProgress = userProgressDataService.getUserProgressByUserID(idUser);
        XPLevel initialLevel = xpLevelService.findByLevel(userProgress.getXpLevel().getLevelNumber());

        Long initialXpPoints = userProgress.getXpPoints();

        Long currentXpPoints = initialXpPoints + xpGained;

        userProgress.setXpPoints(currentXpPoints);

        Boolean isLevelUp = false;
        XPLevel newLevel = null;

        if (currentXpPoints > userProgress.getXpLevel().getXpRangeEnd()) {
            isLevelUp = true;
            newLevel = xpLevelService.findByLevel(userProgress.getXpLevel().getLevelNumber() + 1);
            userProgress.setXpLevel(newLevel);
        }

        // TODO: check for medal

        userProgressDataService.save(userProgress);

        UserLevelUpdateDto userLevelUpdateDto = new UserLevelUpdateDto(initialXpPoints,
                initialLevel, xpGained, currentXpPoints, isLevelUp, newLevel);
        return userLevelUpdateDto;
    }
}
