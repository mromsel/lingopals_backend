package com.romsel.lingopals_backend.domain.services.users_related;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.romsel.lingopals_backend.domain.entities.users_related.ActivityResult;
import com.romsel.lingopals_backend.domain.entities.users_related.UserActivity;
import com.romsel.lingopals_backend.domain.entities.users_related.UserReviewWords;
import com.romsel.lingopals_backend.domain.repositories.users_related.UserReviewWordsRepository;

@Service
public class UserReviewWordsService {

    private UserService usersService;

    private UserReviewWordsRepository userReviewWordsRepository;

    public UserReviewWordsService(UserService usersService, UserReviewWordsRepository userReviewWordsRepository) {
        this.usersService = usersService;
        this.userReviewWordsRepository = userReviewWordsRepository;
    }

    public List<UserReviewWords> findAllByUser(Long idUser) {
        this.usersService.getUserByID(idUser); // THROWS EXCEPTION IF USER IS NOT FOUND
        return this.userReviewWordsRepository.findByIdUser(idUser);
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

            Long idUser = userActivity.getUser().getIdUser();
            List<UserReviewWords> storedReviewedWords = userReviewWordsRepository.findByIdUserAndIdWordReferenceIn(
                    idUser,
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
                        idUser,
                        activityResult.getIdWordRef(),
                        difficulty,
                        ZonedDateTime.now());

                toSave.add(reviewWords);
            }

            this.userReviewWordsRepository.saveAll(toSave);
        }
    }

    public List<UserReviewWords> findTop5ByUser(Long idUser) {
        this.usersService.getUserByID(idUser); // THROWS EXCEPTION IF USER IS NOT FOUND
        return this.userReviewWordsRepository.findByIdUserOrderByDifficultyAscDateDesc(idUser);
    }

}
