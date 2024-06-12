package com.romsel.lingopals_backend.users_related.users_review_words.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.common.Constants;
import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeService;
import com.romsel.lingopals_backend.masters.language_levels.infrastructure.LanguageLevelDto;
import com.romsel.lingopals_backend.masters.languages.domain.LanguageException;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesService;
import com.romsel.lingopals_backend.users_related.users_review_words.domain.UserReviewWords;
import com.romsel.lingopals_backend.words_related.words.application.WordService;
import com.romsel.lingopals_backend.words_related.words.application.WordServiceFactory;
import com.romsel.lingopals_backend.words_related.words.domain.Word;
import com.romsel.lingopals_backend.words_related.words.infrastructure.WordDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class UserReviewWordsController {

        @Autowired
        private UserReviewWordsService userReviewWordsService;

        @Autowired
        private ActivityTypeService activityTypeService;

        @Autowired
        private UserLanguagesService userLanguagesService;

        @Autowired
        private WordServiceFactory wordServiceFactory;

        @SuppressWarnings("unchecked")
        @GetMapping("/review-words/{idUserLanguages}")
        public ResponseEntity<UserReviewWordsDto> getTop5ReviewWords(@PathVariable Long idUserLanguages) {
                UserReviewWordsDto userReviewWordsDto = new UserReviewWordsDto();

                List<UserReviewWords> listUserReviewWords = userReviewWordsService.findTop5ByUser(idUserLanguages);

                UserLanguages userLanguages = userLanguagesService.getUserLanguagesById(idUserLanguages);

                WordService<Word, Long> wordServiceOrigin;
                WordService<Word, Long> wordServiceTarget;
                try {
                        wordServiceOrigin = wordServiceFactory
                                        .getWordServiceByIsoCode(userLanguages.getLanguageOrigin().getIsoCode());
                        wordServiceTarget = wordServiceFactory
                                        .getWordServiceByIsoCode(userLanguages.getLanguageTarget().getIsoCode());
                } catch (IllegalArgumentException e) {
                        throw new LanguageException(HttpStatus.NOT_FOUND,
                                        List.of(ExceptionMessages.LANGUAGE_NOT_FOUND));
                }

                List<Long> idsWordReferences = listUserReviewWords.stream()
                                .map(UserReviewWords::getIdWordReference)
                                .limit(5)
                                .toList();

                List<WordDto> wordsOrigin = wordServiceOrigin.findByWordReferenceIn(idsWordReferences)
                                .stream()
                                .map(WordDto::convertToDto).toList();

                List<WordDto> wordsDestiny = wordServiceTarget.findByWordReferenceIn(idsWordReferences)
                                .stream()
                                .map(WordDto::convertToDto).toList();

                List<WordsInReviewDto> list = idsWordReferences.stream()
                                .map(idWordReference -> {

                                        WordsInReviewDto newWordsInReviewDto = new WordsInReviewDto();
                                        newWordsInReviewDto.setWordOrigin(
                                                        wordsOrigin.stream()
                                                                        .filter(word -> word.getIdWordRef()
                                                                                        .equals(idWordReference))
                                                                        .findFirst()
                                                                        .orElse(null));
                                        newWordsInReviewDto.setWordTarget(
                                                        wordsDestiny.stream()
                                                                        .filter(word -> word.getIdWordRef()
                                                                                        .equals(idWordReference))
                                                                        .findFirst()
                                                                        .orElse(null));

                                        return newWordsInReviewDto;
                                })
                                .toList();

                userReviewWordsDto.setIdUserLanguages(idUserLanguages);
                userReviewWordsDto.setLanguageLevel(LanguageLevelDto.convertToDto(userLanguages.getLanguageLevel()));
                userReviewWordsDto.setWordsList(list);
                userReviewWordsDto.setActivityType(ActivityTypeDto
                                .convertToDto(activityTypeService.findByType(Constants.ACTIVITY_TYPE_REVIEW)));

                return new ResponseEntity<>(userReviewWordsDto, HttpStatus.OK);
        }

}
