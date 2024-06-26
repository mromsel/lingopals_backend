package com.romsel.lingopals_backend.users_related.users_review_words.infrastructure;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.users_related.users_activity.domain.ActivityResult;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivity;
import com.romsel.lingopals_backend.users_related.users_languages.infrastructure.UserLanguagesService;
import com.romsel.lingopals_backend.users_related.users_review_words.domain.UserReviewWords;
import com.romsel.lingopals_backend.users_related.users_review_words.domain.UserReviewWordsRepository;

@Service
public class UserReviewWordsService {

    private UserReviewWordsRepository userReviewWordsRepository;

    private UserLanguagesService userLanguagesService;

    public UserReviewWordsService(UserReviewWordsRepository userReviewWordsRepository,
            UserLanguagesService userLanguagesService) {
        this.userReviewWordsRepository = userReviewWordsRepository;
        this.userLanguagesService = userLanguagesService;
    }

    public List<UserReviewWords> findAllByUserLanguages(Long idUserLanguages) {
        this.userLanguagesService.getUserLanguagesById(idUserLanguages);
        return this.userReviewWordsRepository.findByIdUserLanguages(idUserLanguages);
    }

    public List<UserReviewWords> findByIdUserLanguagesAndIdWordReferenceIn(Long idUserLanguages,
            List<Long> listIdWordReferences) {
        return this.userReviewWordsRepository.findByIdUserLanguagesAndIdWordReferenceIn(idUserLanguages,
                listIdWordReferences);
    }

    public UserReviewWords save(UserReviewWords userReviewWords) {
        return this.userReviewWordsRepository.save(userReviewWords);
    }

    public void saveAll(List<UserReviewWords> listUserReviewWords) {
        this.userReviewWordsRepository.saveAll(listUserReviewWords);
    }

    public void saveActivityResults(UserActivity userActivity) {
        if (userActivity.getResults() != null && !userActivity.getResults().isEmpty()) {
            List<ActivityResult> results = userActivity.getResults();

            Long idUserLanguages = userActivity.getUserLanguages().getIdUserLanguages();
            List<UserReviewWords> storedReviewedWords = userReviewWordsRepository
                    .findByIdUserLanguagesAndIdWordReferenceIn(
                            idUserLanguages,
                            results.stream().map(ActivityResult::getIdWordRef).toList());

            List<UserReviewWords> toSave = new ArrayList<>();

            for (ActivityResult activityResult : results) {
                Optional<UserReviewWords> existingReview = storedReviewedWords.stream()
                        .filter(review -> review.getIdWordReference().equals(activityResult.getIdWordRef()))
                        .findFirst();

                int difficulty = existingReview.map(UserReviewWords::getDifficulty).orElse(0);
                boolean correct = activityResult.getResult();

                if (correct && difficulty > 0) {
                    difficulty--; // Si acierta y la dificultad es mayor que 0, se reduce la dificultad en 1
                } else if (!correct) {
                    difficulty++; // Si falla, se aumenta la dificultad en 1
                }

                UserReviewWords reviewWords = new UserReviewWords(
                        activityResult.getIdWordRef(),
                        userActivity.getUserLanguages().getIdUserLanguages(),
                        difficulty,
                        ZonedDateTime.now());

                toSave.add(reviewWords);
            }

            this.userReviewWordsRepository.saveAll(toSave);
        }
    }

    public List<UserReviewWords> findTop5ByUser(Long idUserLanguages) {
        this.userLanguagesService.getUserLanguagesById(idUserLanguages);
        return this.userReviewWordsRepository.findByIdUserLanguagesOrderByDifficultyAscDateDesc(idUserLanguages);
    }

}
