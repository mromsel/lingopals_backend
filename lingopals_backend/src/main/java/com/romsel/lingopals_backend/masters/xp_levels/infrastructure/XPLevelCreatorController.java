package com.romsel.lingopals_backend.masters.xp_levels.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.masters.xp_levels.application.XPLevelCreator;
import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevelException;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class XPLevelCreatorController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private XPLevelCreator xpLevelCreator;

    @GetMapping("/xp-levels/create-all")
    public ResponseEntity<List<XPLevelDto>> createLevels() {
        try {
            List<XPLevelDto> list = xpLevelCreator.fillXPLevels()
                    .stream()
                    .map(xpLevel -> modelMapper.map(xpLevel, XPLevelDto.class))
                    .toList();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            throw new XPLevelException(HttpStatus.INTERNAL_SERVER_ERROR, List.of(e.getMessage()));
        }
    }

}
