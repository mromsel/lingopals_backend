package com.romsel.lingopals_backend.admin_panel.infrastructure.masters;

import java.util.List;

import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.grammatical_categories.infrastructure.GrammaticalCategoryDto;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.masters.languages.infrastructure.LanguageDto;
import com.romsel.lingopals_backend.masters.profiles.infrastructure.ProfileDto;
import com.romsel.lingopals_backend.masters.writing_systems.infrastructure.WritingSystemDto;
import com.romsel.lingopals_backend.masters.xp_levels.infrastructure.XPLevelDto;
import com.romsel.lingopals_backend.words_related.semantic_categories.infrastructure.SemanticCategoryDto;

import lombok.Data;

/** @see com.romsel.lingopals_backend.admin_panel.domain.masters.Masters */
@Data
public class MastersDto {

    private List<ActivityTypeDto> activityTypes;
    private List<GrammaticalCategoryDto> grammaticalCategories;
    private List<LanguageLevelDto> languageLevels;
    private List<LanguageDto> languages;
    private List<ProfileDto> profiles;
    private List<SemanticCategoryDto> semanticCategories;
    private List<WritingSystemDto> writingSystems;
    private List<XPLevelDto> xpLevels;

}
