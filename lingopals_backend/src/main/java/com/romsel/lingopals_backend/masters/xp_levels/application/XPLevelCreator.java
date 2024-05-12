package com.romsel.lingopals_backend.masters.xp_levels.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevel;
import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevelRepository;

@Service
public class XPLevelCreator {

    public static final Integer MAX_LEVEL = 100;

    @Autowired
    private XPLevelRepository xpLevelRepository;

    public List<XPLevel> fillXPLevels() {

        int startXP = 0;
        int endXP = 100; // Cambia este valor según tu necesidad

        for (int level = 1; level <= MAX_LEVEL; level++) {
            XPLevel xpLevel = new XPLevel();
            xpLevel.setLevelNumber(level);
            xpLevel.setXpRangeStart(startXP);
            xpLevel.setXpRangeEnd(endXP);
            xpLevel.setHasMedal(level % 10 == 0);

            xpLevelRepository.save(xpLevel);

            // Adjust xp aument depending on level
            if (level < 20) {
                startXP = endXP + 1;
                endXP = startXP + 100;
            } else {
                startXP = endXP + 1;
                // Exponential growth after level 20
                endXP = (int) (startXP + 100 * Math.pow(1.2, level - 20.0));
            }
        }

        return (List<XPLevel>) this.xpLevelRepository.findAll();
    }
}
