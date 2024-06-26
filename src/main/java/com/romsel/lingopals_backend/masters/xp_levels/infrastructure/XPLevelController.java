package com.romsel.lingopals_backend.masters.xp_levels.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class XPLevelController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private XPLevelService xpLevelService;

    @GetMapping("/xp-levels")
    public List<XPLevelDto> getAllLevels() {
        return xpLevelService.findAll()
                .stream()
                .map(xpLevel -> modelMapper.map(xpLevel, XPLevelDto.class))
                .toList();
    }

    @GetMapping("/xp-levels/{level}")
    public XPLevelDto getByLevel(@PathVariable Integer level) {
        return modelMapper.map(this.xpLevelService.findByLevel(level), XPLevelDto.class);
    }

}
