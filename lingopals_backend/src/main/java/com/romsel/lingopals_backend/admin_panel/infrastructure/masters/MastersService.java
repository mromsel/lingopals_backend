package com.romsel.lingopals_backend.admin_panel.infrastructure.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.admin_panel.domain.masters.Masters;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeService;
import com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure.GrammaticalCategoryService;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelService;
import com.romsel.lingopals_backend.masters.languages.infrastructure.LanguageService;
import com.romsel.lingopals_backend.masters.profiles.infrastructure.ProfileService;
import com.romsel.lingopals_backend.masters.writing_systems.infrastructure.WritingSystemService;
import com.romsel.lingopals_backend.masters.xp_levels.infrastructure.XPLevelService;

@Service
public class MastersService {

    @Autowired
    private ActivityTypeService activityTypeService;

    @Autowired
    private GrammaticalCategoryService grammaticalCategoryService;

    @Autowired
    private LanguageLevelService languageLevelService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private WritingSystemService writingSystemService;

    @Autowired
    private XPLevelService xpLevelService;

    public Masters getAllMasters() {
        Masters masters = new Masters();

        masters.setActivityTypes(activityTypeService.findAll());
        masters.setGrammaticalCategories(grammaticalCategoryService.findAll());
        masters.setLanguageLevels(languageLevelService.getAllLanguageLevels());
        masters.setLanguages(languageService.getAllLanguages());
        masters.setProfiles(profileService.findAll());
        masters.setWritingSystems(writingSystemService.getAllWritingSystems());
        masters.setXpLevels(xpLevelService.findAll());

        return masters;
    }

}
