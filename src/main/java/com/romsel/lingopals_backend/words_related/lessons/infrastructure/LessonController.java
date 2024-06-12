package com.romsel.lingopals_backend.words_related.lessons.infrastructure;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class LessonController {

        private ModelMapper modelMapper;

        private LessonService lessonService;

        public LessonController(ModelMapper modelMapper, LessonService lessonService) {
                this.modelMapper = modelMapper;
                this.lessonService = lessonService;
        }

        @GetMapping("/lessons")
        public List<LessonDto> getAllLessons() {
                return lessonService.getAllLessons()
                                .stream()
                                .map(lesson -> modelMapper.map(lesson, LessonDto.class))
                                .toList();
        }
}
