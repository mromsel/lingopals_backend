package com.romsel.lingopal_backend.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopal_backend.domain.repositories.WordAdditionalInfoRepository;

@Service
public class WordAdditionalInfoService {

    @Autowired
    private WordAdditionalInfoRepository wordAdditionalInfoRepository;

}
