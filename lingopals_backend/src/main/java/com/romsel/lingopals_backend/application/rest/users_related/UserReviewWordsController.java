package com.romsel.lingopals_backend.application.rest.users_related;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romsel.lingopals_backend.application.common.WordServiceFactory;
import com.romsel.lingopals_backend.application.exceptions.ExceptionMessages;
import com.romsel.lingopals_backend.application.exceptions.words_related.LanguageException;
import com.romsel.lingopals_backend.application.response.words_related.UserReviewWordsDto;
import com.romsel.lingopals_backend.application.response.words_related.WordDto;
import com.romsel.lingopals_backend.application.response.words_related.WordsInReviewDto;
import com.romsel.lingopals_backend.domain.entities.users_related.UserReviewWords;
import com.romsel.lingopals_backend.domain.entities.words_related.words.Word;
import com.romsel.lingopals_backend.domain.services.users_related.UserReviewWordsService;
import com.romsel.lingopals_backend.domain.services.users_related.UserService;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordService;

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
    private UserService userService;

    @Autowired
    private WordServiceFactory wordServiceFactory;

    @SuppressWarnings("unchecked")
    @GetMapping("/review-words/{idUser}/{isoLangOrigin}/{isoLangTarget}")
    public ResponseEntity<?> getTop5ReviewWords(@PathVariable Long idUser, @PathVariable String isoLangOrigin,
            @PathVariable String isoLangTarget) {
        UserReviewWordsDto userReviewWordsDto = new UserReviewWordsDto();

        // TODO: TRY-CATCH DATA ACCESS
        List<UserReviewWords> listUserReviewWords = userReviewWordsService.findTop5ByUser(idUser);

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
        // userReviewWordsDto.setLanguageLevel();
        userReviewWordsDto.setWordsList(list);

        return new ResponseEntity<>(userReviewWordsDto, HttpStatus.OK);
    }

}
