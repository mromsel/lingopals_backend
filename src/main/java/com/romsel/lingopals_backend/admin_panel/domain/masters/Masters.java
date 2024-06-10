package com.romsel.lingopals_backend.admin_panel.domain.masters;

import java.util.List;

import com.romsel.lingopals_backend.masters.activity_types.domain.ActivityType;
import com.romsel.lingopals_backend.masters.grammatical_categories.domain.GrammaticalCategory;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevel;
import com.romsel.lingopals_backend.masters.languages.domain.Language;
import com.romsel.lingopals_backend.masters.profiles.domain.Profile;
import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystem;
import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevel;
import com.romsel.lingopals_backend.words_related.semantic_categories.domain.SemanticCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Masters {
    private List<ActivityType> activityTypes;
    private List<GrammaticalCategory> grammaticalCategories;
    private List<LanguageLevel> languageLevels;
    private List<Language> languages;
    private List<Profile> profiles;
    private List<SemanticCategory> semanticCategories;
    private List<WritingSystem> writingSystems;
    private List<XPLevel> xpLevels;
}
