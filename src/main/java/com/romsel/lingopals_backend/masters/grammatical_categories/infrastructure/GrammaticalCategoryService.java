package com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.masters.grammatical_categories.domain.GrammaticalCategory;
import com.romsel.lingopals_backend.masters.grammatical_categories.domain.GrammaticalCategoryRepository;

@Service
public class GrammaticalCategoryService {

    @Autowired
    private GrammaticalCategoryRepository grammaticalCategoryRepository;

    public List<GrammaticalCategory> findAll() {
        return (List<GrammaticalCategory>) grammaticalCategoryRepository.findAll();
    }
}
