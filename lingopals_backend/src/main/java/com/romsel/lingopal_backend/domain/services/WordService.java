package com.romsel.lingopal_backend.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopal_backend.domain.repositories.WordRepository;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

}
