package com.romsel.lingopals_backend.admin_panel.infrastructure.masters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class MastersController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MastersService mastersService;

    @GetMapping("/masters")
    public MastersDto getAllMasters() {
        return modelMapper.map(mastersService.getAllMasters(), MastersDto.class);
    }

}
