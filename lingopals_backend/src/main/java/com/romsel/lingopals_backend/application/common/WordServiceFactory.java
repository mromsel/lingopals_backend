package com.romsel.lingopals_backend.application.common;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.romsel.lingopals_backend.domain.services.words_related.words.WordARService;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordENService;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordESService;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordFRService;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordKOService;
import com.romsel.lingopals_backend.domain.services.words_related.words.WordService;

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
