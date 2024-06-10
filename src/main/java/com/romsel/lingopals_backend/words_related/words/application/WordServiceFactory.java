package com.romsel.lingopals_backend.words_related.words.application;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services.WordARService;
import com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services.WordENService;
import com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services.WordESService;
import com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services.WordFRService;
import com.romsel.lingopals_backend.words_related.words.infrastructure.words_languages.services.WordKOService;

@Component
public class WordServiceFactory {

    private ApplicationContext context;

    public WordServiceFactory(ApplicationContext context) {
        this.context = context;
    }

    @SuppressWarnings("rawtypes")
    public WordService getWordServiceByIsoCode(String isoCode) {

        Class<? extends WordService> serviceClass = switch (isoCode) {
            case "en" -> WordENService.class;
            case "es" -> WordESService.class;
            case "fr" -> WordFRService.class;
            case "ko" -> WordKOService.class;
            case "ar" -> WordARService.class;
            default -> null;
        };

        if (serviceClass != null) {
            return context.getBean(serviceClass);
        } else {
            throw new IllegalArgumentException("Unsupported ISO code: " + isoCode);
        }
    }
}
