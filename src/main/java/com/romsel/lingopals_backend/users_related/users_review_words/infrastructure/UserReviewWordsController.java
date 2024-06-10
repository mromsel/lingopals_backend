package com.romsel.lingopals_backend.users_related.users_review_words.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.common.Constants;
import com.romsel.lingopals_backend.common.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeDto;
import com.romsel.lingopals_backend.masters.activity_types.infrastructure.ActivityTypeService;
import com.romsel.lingopals_backend.masters.languages.domain.LanguageException;
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
        private ModelMapper modelMapper;

        @Autowired
        private UserReviewWordsService userReviewWordsService;

        @Autowired
        private ActivityTypeService activityTypeService;

        @Autowired
        private WordServiceFactory wordServiceFactory;

        @SuppressWarnings("unchecked")
        @GetMapping("/review-words/{idUserLanguages}/{isoLangOrigin}/{isoLangTarget}")
        public ResponseEntity<?> getTop5ReviewWords(@PathVariable Long idUserLanguages,
                        @PathVariable String isoLangOrigin,
                        @PathVariable String isoLangTarget) {
                UserReviewWordsDto userReviewWordsDto = new UserReviewWordsDto();

                // TODO: TRY-CATCH DATA ACCESS
                List<UserReviewWords> listUserReviewWords = userReviewWordsService.findTop5ByUser(idUserLanguages);

                WordService<Word, Long> wordServiceOrigin;
                WordService<Word, Long> wordServiceTarget;
                try {
                        wordServiceOrigin = wordServiceFactory
                                        .getWordServiceByIsoCode(isoLangOrigin);
                        wordServiceTarget = wordServiceFactory
                                        .getWordServiceByIsoCode(isoLangTarget);
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
                                .map(word -> modelMapper.map(word, WordDto.class)).toList();

                List<WordDto> wordsDestiny = wordServiceTarget.findByWordReferenceIn(idsWordReferences)
                                .stream()
                                .map(word -> modelMapper.map(word, WordDto.class)).toList();

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
                userReviewWordsDto.setWordsList(list);
                userReviewWordsDto.setActivityType(modelMapper.map(
                                activityTypeService.findByType(Constants.ACTIVITY_TYPE_REVIEW), ActivityTypeDto.class));

                return new ResponseEntity<>(userReviewWordsDto, HttpStatus.OK);
        }

}
