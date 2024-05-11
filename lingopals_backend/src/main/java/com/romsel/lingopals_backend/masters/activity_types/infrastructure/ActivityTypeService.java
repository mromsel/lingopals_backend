package com.romsel.lingopals_backend.masters.activity_types.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityType;
import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityTypeException;
import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityTypeRepository;

@Service
public class ActivityTypeService {

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    public ActivityType findById(Integer id) {
        return activityTypeRepository.findById(id)
                .orElseThrow(() -> new ActivityTypeException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.ACTIVITY_TYPE_NOT_FOUND)));
    }

    public ActivityType findByType(String type) {
        return activityTypeRepository.findByType(type)
                .orElseThrow(() -> new ActivityTypeException(HttpStatus.NOT_FOUND,
                        List.of(ExceptionMessages.ACTIVITY_TYPE_NOT_FOUND)));
    }
}
