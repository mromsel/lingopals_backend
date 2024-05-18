package com.romsel.lingopals_backend.masters.activity_types.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActivityTypeController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ActivityTypeService activityTypeService;

    @GetMapping("/activity-types")
    public List<ActivityTypeDto> getAllActivityTypes() {
        return activityTypeService.findAll()
                .stream()
                .map(activityType -> modelMapper.map(activityType, ActivityTypeDto.class))
                .toList();
    }
}
