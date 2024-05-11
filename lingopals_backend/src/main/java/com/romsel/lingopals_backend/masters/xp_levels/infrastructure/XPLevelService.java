package com.romsel.lingopals_backend.masters.xp_levels.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevel;
import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevelException;
import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevelRepository;

@Service
public class XPLevelService {

    @Autowired
    private XPLevelRepository xpLevelRepository;

    public XPLevel findByLevel(Integer level) {
        return xpLevelRepository.findById(level)
                .orElseThrow(() -> new XPLevelException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.XP_LEVEL_NOT_FOUND)));
    }

    public XPLevel findByXpPoints(Integer xpPoints) {
        return xpLevelRepository.findByXpPoints(xpPoints);
    }

    public XPLevel save(XPLevel xpLevel) {
        return this.xpLevelRepository.save(xpLevel);
    }

}
