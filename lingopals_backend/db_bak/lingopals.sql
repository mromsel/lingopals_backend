-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: lingopals_db
-- Tiempo de generación: 29-05-2024 a las 14:46:05
-- Versión del servidor: 8.4.0
-- Versión de PHP: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `lingopals`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activity_types`
--

CREATE TABLE `activity_types` (
  `id_activity_type` int NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `activity_types`
--

INSERT INTO `activity_types` (`id_activity_type`, `type`) VALUES
(2, 'LESSON'),
(1, 'REVIEW');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activity_types_seq`
--

CREATE TABLE `activity_types_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `activity_types_seq`
--

INSERT INTO `activity_types_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE `categories` (
  `id_category` int NOT NULL,
  `word_reference_name` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grammatical_categories`
--

CREATE TABLE `grammatical_categories` (
  `id_grammatical_category` int NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `grammatical_categories`
--

INSERT INTO `grammatical_categories` (`id_grammatical_category`, `name`) VALUES
(1, 'noun'),
(2, 'pronoun'),
(3, 'verb'),
(4, 'adjective'),
(5, 'adverb'),
(6, 'preposition'),
(7, 'conjunction'),
(8, 'interjection');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grammatical_categories_seq`
--

CREATE TABLE `grammatical_categories_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `grammatical_categories_seq`
--

INSERT INTO `grammatical_categories_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `languages`
--

CREATE TABLE `languages` (
  `id_language` int NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `iso_code` varchar(255) DEFAULT NULL,
  `language_name` varchar(255) DEFAULT NULL,
  `id_writing_system` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `languages`
--

INSERT INTO `languages` (`id_language`, `flag`, `iso_code`, `language_name`, `id_writing_system`) VALUES
(1, 'flag_en.png', 'en', 'English', 1),
(2, 'flag_es.png', 'es', 'Español', 1),
(3, 'flag_fr.png', 'fr', 'Français', 1),
(4, 'flag_ko.png', 'ko', '한국어', 2),
(5, 'flag_ar.png', 'ar', 'العربية', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `language_levels`
--

CREATE TABLE `language_levels` (
  `id_level` int NOT NULL,
  `level_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `language_levels`
--

INSERT INTO `language_levels` (`id_level`, `level_name`) VALUES
(1, 'A1'),
(2, 'A2'),
(3, 'B1'),
(4, 'B2'),
(5, 'C1'),
(6, 'C2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lessons`
--

CREATE TABLE `lessons` (
  `id_lesson` int NOT NULL,
  `lesson_name` varchar(255) DEFAULT NULL,
  `language_level` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lessons_wordsref`
--

CREATE TABLE `lessons_wordsref` (
  `id_lesson` int NOT NULL,
  `id_ref` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profiles`
--

CREATE TABLE `profiles` (
  `id_profile` int NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `profiles`
--

INSERT INTO `profiles` (`id_profile`, `name`) VALUES
(1, 'ADMIN'),
(2, 'DEBUGGER'),
(3, 'USER_STANDARD'),
(4, 'USER_PREMIUM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `profile_image_url` varchar(255) DEFAULT NULL,
  `registration_date` datetime(6) DEFAULT NULL,
  `time_zone` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `id_language` int NOT NULL,
  `id_user_progress_data` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `email`, `password_hash`, `profile_image_url`, `registration_date`, `time_zone`, `username`, `id_language`, `id_user_progress_data`) VALUES
(1, 'admin@admin.com', '$2a$10$6/8dF/DGG.MlyMDPOR7ZuOagOIK03nXz1cF4arsy2b.WGXrZvxyVq', NULL, '2024-05-29 13:27:52.313876', 'Europe/Madrid', 'admin', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_activity`
--

CREATE TABLE `users_activity` (
  `id_user_activity` bigint NOT NULL,
  `activity_date` datetime(6) NOT NULL,
  `lesson` int DEFAULT NULL,
  `xp_gained` int DEFAULT NULL,
  `activity_type` int NOT NULL,
  `id_user` bigint NOT NULL,
  `id_user_languages` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_activity_seq`
--

CREATE TABLE `users_activity_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users_activity_seq`
--

INSERT INTO `users_activity_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_completed_lessons`
--

CREATE TABLE `users_completed_lessons` (
  `id_user_completed_lesson` bigint NOT NULL,
  `completion_date` datetime(6) NOT NULL,
  `id_lesson` int NOT NULL,
  `id_user_languages` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_completed_lessons_seq`
--

CREATE TABLE `users_completed_lessons_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users_completed_lessons_seq`
--

INSERT INTO `users_completed_lessons_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_languages`
--

CREATE TABLE `users_languages` (
  `id_user_languages` bigint NOT NULL,
  `preferred` bit(1) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `id_language_level` int NOT NULL,
  `language_origin` int DEFAULT NULL,
  `language_target` int DEFAULT NULL,
  `id_user` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_languages_seq`
--

CREATE TABLE `users_languages_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users_languages_seq`
--

INSERT INTO `users_languages_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_profiles`
--

CREATE TABLE `users_profiles` (
  `id_user` bigint NOT NULL,
  `id_profile` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_progress_data`
--

CREATE TABLE `users_progress_data` (
  `id_user_progress_data` bigint NOT NULL,
  `coins` int DEFAULT NULL,
  `current_streak` int DEFAULT NULL,
  `max_streak` int DEFAULT NULL,
  `streak_end_date` datetime(6) DEFAULT NULL,
  `streak_start_date` datetime(6) DEFAULT NULL,
  `xp_points` bigint DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  `xp_level` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users_progress_data`
--

INSERT INTO `users_progress_data` (`id_user_progress_data`, `coins`, `current_streak`, `max_streak`, `streak_end_date`, `streak_start_date`, `xp_points`, `id_user`, `xp_level`) VALUES
(1, 0, 0, NULL, NULL, NULL, 0, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_relationships`
--

CREATE TABLE `users_relationships` (
  `id_relationship` bigint NOT NULL,
  `connection_date` date DEFAULT NULL,
  `id_user1` bigint DEFAULT NULL,
  `id_user2` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_review_words`
--

CREATE TABLE `users_review_words` (
  `id_user_languages` bigint NOT NULL,
  `id_word_ref` bigint NOT NULL,
  `difficulty` int DEFAULT NULL,
  `last_review_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_ar`
--

CREATE TABLE `words_ar` (
  `id_word` bigint NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `gramatical_gender` varchar(255) DEFAULT NULL,
  `pronunciation` varchar(255) DEFAULT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `word_string` varchar(255) DEFAULT NULL,
  `id_language` int NOT NULL,
  `id_word_reference` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_en`
--

CREATE TABLE `words_en` (
  `id_word` bigint NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `gramatical_gender` varchar(255) DEFAULT NULL,
  `pronunciation` varchar(255) DEFAULT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `word_string` varchar(255) DEFAULT NULL,
  `id_language` int NOT NULL,
  `id_word_reference` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_es`
--

CREATE TABLE `words_es` (
  `id_word` bigint NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `gramatical_gender` varchar(255) DEFAULT NULL,
  `pronunciation` varchar(255) DEFAULT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `word_string` varchar(255) DEFAULT NULL,
  `id_language` int NOT NULL,
  `id_word_reference` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_fr`
--

CREATE TABLE `words_fr` (
  `id_word` bigint NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `gramatical_gender` varchar(255) DEFAULT NULL,
  `pronunciation` varchar(255) DEFAULT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `word_string` varchar(255) DEFAULT NULL,
  `id_language` int NOT NULL,
  `id_word_reference` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_ko`
--

CREATE TABLE `words_ko` (
  `id_word` bigint NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `gramatical_gender` varchar(255) DEFAULT NULL,
  `pronunciation` varchar(255) DEFAULT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `word_string` varchar(255) DEFAULT NULL,
  `id_language` int NOT NULL,
  `id_word_reference` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_references`
--

CREATE TABLE `words_references` (
  `id_word_ref` bigint NOT NULL,
  `english_definition` varchar(255) DEFAULT NULL,
  `english_word` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `grammatical_category` int NOT NULL,
  `language_level` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_references_seq`
--

CREATE TABLE `words_references_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `words_references_seq`
--

INSERT INTO `words_references_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `writing_system`
--

CREATE TABLE `writing_system` (
  `id_writing_system` int NOT NULL,
  `iso_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `writing_system`
--

INSERT INTO `writing_system` (`id_writing_system`, `iso_code`, `name`) VALUES
(1, 'rom', 'Roman Characters'),
(2, 'hangul', 'Hangul Characters'),
(3, 'arab', 'Arabic Characters');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `xp_levels`
--

CREATE TABLE `xp_levels` (
  `level_number` int NOT NULL,
  `has_medal` bit(1) DEFAULT NULL,
  `xp_range_end` int DEFAULT NULL,
  `xp_range_start` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `xp_levels`
--

INSERT INTO `xp_levels` (`level_number`, `has_medal`, `xp_range_end`, `xp_range_start`) VALUES
(1, b'0', 100, 0),
(2, b'0', 201, 101),
(3, b'0', 302, 202),
(4, b'0', 403, 303),
(5, b'0', 504, 404),
(6, b'0', 605, 505),
(7, b'0', 706, 606),
(8, b'0', 807, 707),
(9, b'0', 908, 808),
(10, b'1', 1009, 909),
(11, b'0', 1110, 1010),
(12, b'0', 1211, 1111),
(13, b'0', 1312, 1212),
(14, b'0', 1413, 1313),
(15, b'0', 1514, 1414),
(16, b'0', 1615, 1515),
(17, b'0', 1716, 1616),
(18, b'0', 1817, 1717),
(19, b'0', 1918, 1818),
(20, b'1', 2019, 1919),
(21, b'0', 2120, 2020),
(22, b'0', 2241, 2121),
(23, b'0', 2386, 2242),
(24, b'0', 2559, 2387),
(25, b'0', 2767, 2560),
(26, b'0', 3016, 2768),
(27, b'0', 3315, 3017),
(28, b'0', 3674, 3316),
(29, b'0', 4104, 3675),
(30, b'1', 4620, 4105),
(31, b'0', 5240, 4621),
(32, b'0', 5984, 5241),
(33, b'0', 6876, 5985),
(34, b'0', 7946, 6877),
(35, b'0', 9230, 7947),
(36, b'0', 10771, 9231),
(37, b'0', 12620, 10772),
(38, b'0', 14839, 12621),
(39, b'0', 17502, 14840),
(40, b'1', 20697, 17503),
(41, b'0', 24531, 20698),
(42, b'0', 29132, 24532),
(43, b'0', 34653, 29133),
(44, b'0', 41278, 34654),
(45, b'0', 49228, 41279),
(46, b'0', 58768, 49229),
(47, b'0', 70216, 58769),
(48, b'0', 83954, 70217),
(49, b'0', 100439, 83955),
(50, b'1', 120221, 100440),
(51, b'0', 143959, 120222),
(52, b'0', 172445, 143960),
(53, b'0', 206628, 172446),
(54, b'0', 247647, 206629),
(55, b'0', 296870, 247648),
(56, b'0', 355937, 296871),
(57, b'0', 426818, 355938),
(58, b'0', 511875, 426819),
(59, b'0', 613943, 511876),
(60, b'1', 736424, 613944),
(61, b'0', 883402, 736425),
(62, b'0', 1059775, 883403),
(63, b'0', 1271423, 1059776),
(64, b'0', 1525400, 1271424),
(65, b'0', 1830172, 1525401),
(66, b'0', 2195899, 1830173),
(67, b'0', 2634771, 2195900),
(68, b'0', 3161417, 2634772),
(69, b'0', 3793392, 3161418),
(70, b'1', 4551762, 3793393),
(71, b'0', 5461806, 4551763),
(72, b'0', 6553859, 5461807),
(73, b'0', 7864323, 6553860),
(74, b'0', 9436879, 7864324),
(75, b'0', 11323946, 9436880),
(76, b'0', 13588427, 11323947),
(77, b'0', 16305804, 13588428),
(78, b'0', 19566656, 16305805),
(79, b'0', 23479678, 19566657),
(80, b'1', 28175305, 23479679),
(81, b'0', 33810057, 28175306),
(82, b'0', 40571759, 33810058),
(83, b'0', 48685802, 40571760),
(84, b'0', 58422653, 48685803),
(85, b'0', 70106874, 58422654),
(86, b'0', 84127939, 70106875),
(87, b'0', 100953217, 84127940),
(88, b'0', 121143551, 100953218),
(89, b'0', 145371951, 121143552),
(90, b'1', 174446031, 145371952),
(91, b'0', 209334927, 174446032),
(92, b'0', 251201602, 209334928),
(93, b'0', 301441612, 251201603),
(94, b'0', 361729624, 301441613),
(95, b'0', 434075239, 361729625),
(96, b'0', 520889976, 434075240),
(97, b'0', 625067661, 520889977),
(98, b'0', 750080883, 625067662),
(99, b'0', 900096749, 750080884),
(100, b'1', 1080115788, 900096750);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activity_types`
--
ALTER TABLE `activity_types`
  ADD PRIMARY KEY (`id_activity_type`),
  ADD UNIQUE KEY `UK_d2em13kpvbixihind1w9id44h` (`type`);

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id_category`),
  ADD UNIQUE KEY `UK_54ov48ghbxyrcv281sm2ni8ad` (`word_reference_name`);

--
-- Indices de la tabla `grammatical_categories`
--
ALTER TABLE `grammatical_categories`
  ADD PRIMARY KEY (`id_grammatical_category`);

--
-- Indices de la tabla `languages`
--
ALTER TABLE `languages`
  ADD PRIMARY KEY (`id_language`),
  ADD KEY `FK1jehgb0lhjldnfdjr87ywfxnw` (`id_writing_system`);

--
-- Indices de la tabla `language_levels`
--
ALTER TABLE `language_levels`
  ADD PRIMARY KEY (`id_level`);

--
-- Indices de la tabla `lessons`
--
ALTER TABLE `lessons`
  ADD PRIMARY KEY (`id_lesson`),
  ADD KEY `FK98c8sfja1tjgys2yobn1pfq4b` (`language_level`);

--
-- Indices de la tabla `lessons_wordsref`
--
ALTER TABLE `lessons_wordsref`
  ADD KEY `FKmnfrcklf42vdjpmtt17vrve7r` (`id_ref`),
  ADD KEY `FKfbcrwmy9p95kwo16dixxtfgg2` (`id_lesson`);

--
-- Indices de la tabla `profiles`
--
ALTER TABLE `profiles`
  ADD PRIMARY KEY (`id_profile`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK_rpyslm1e9vwnxdieo8cskym24` (`id_user_progress_data`),
  ADD KEY `FK8pbj2nsrxosm3225us23fis6b` (`id_language`);

--
-- Indices de la tabla `users_activity`
--
ALTER TABLE `users_activity`
  ADD PRIMARY KEY (`id_user_activity`),
  ADD KEY `FKlj6i821armf9ppgu5kuxvowq7` (`activity_type`),
  ADD KEY `FK2hf95ac72f7c1e2xoxromsyls` (`id_user`),
  ADD KEY `FKchu72emf54gqg1b2yohrhhki0` (`id_user_languages`);

--
-- Indices de la tabla `users_completed_lessons`
--
ALTER TABLE `users_completed_lessons`
  ADD PRIMARY KEY (`id_user_completed_lesson`),
  ADD KEY `FKbf3wtq4v6u1rtfvnktvm9yuij` (`id_lesson`),
  ADD KEY `FK99j6gogiixxp5g61108nsv9jr` (`id_user_languages`);

--
-- Indices de la tabla `users_languages`
--
ALTER TABLE `users_languages`
  ADD PRIMARY KEY (`id_user_languages`),
  ADD KEY `FK31dijys7yd3t62wpst2qwvbdl` (`id_language_level`),
  ADD KEY `FK4x1uhrc2aq8x3p61783rn6963` (`language_origin`),
  ADD KEY `FK6mdtd9kr7445yvnq3ivlw4g7g` (`language_target`),
  ADD KEY `FKd02kqdfvbdmgkgkxhodpdqy7k` (`id_user`);

--
-- Indices de la tabla `users_profiles`
--
ALTER TABLE `users_profiles`
  ADD KEY `FKrogbsl5ufv6gdqwxff0nq5wrm` (`id_profile`),
  ADD KEY `FKri1mhekq3lfqqx9hoqaiigj61` (`id_user`);

--
-- Indices de la tabla `users_progress_data`
--
ALTER TABLE `users_progress_data`
  ADD PRIMARY KEY (`id_user_progress_data`),
  ADD UNIQUE KEY `UK_ilkp1g3dlp8exo7jc2ar3gcxy` (`id_user`),
  ADD KEY `FKk2te2qvo993y00nvv1sr3v878` (`xp_level`);

--
-- Indices de la tabla `users_relationships`
--
ALTER TABLE `users_relationships`
  ADD PRIMARY KEY (`id_relationship`),
  ADD KEY `FKf63qvdx88wueybq32ai30pl9i` (`id_user1`),
  ADD KEY `FK52vupt2w21jvxecskty14bsye` (`id_user2`);

--
-- Indices de la tabla `users_review_words`
--
ALTER TABLE `users_review_words`
  ADD PRIMARY KEY (`id_user_languages`,`id_word_ref`);

--
-- Indices de la tabla `words_ar`
--
ALTER TABLE `words_ar`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKrefs122dhmutfo9n57qnnehjd` (`id_language`),
  ADD KEY `FKqhr83o8e6udoapb2ceo2an5uy` (`id_word_reference`);

--
-- Indices de la tabla `words_en`
--
ALTER TABLE `words_en`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKmqqnepquqrtcorkb3iqnvyv4l` (`id_language`),
  ADD KEY `FK3kle1f0j36a20cs10xisbw4s` (`id_word_reference`);

--
-- Indices de la tabla `words_es`
--
ALTER TABLE `words_es`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKidxcha5og11g9y6j629dsq04m` (`id_language`),
  ADD KEY `FKtj9otv8lapt6ru6pd57xtauo8` (`id_word_reference`);

--
-- Indices de la tabla `words_fr`
--
ALTER TABLE `words_fr`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKfghrlclfk3ldmjtiobccu2mhg` (`id_language`),
  ADD KEY `FKh1dd2e16d4g2t2mki4kicxi0s` (`id_word_reference`);

--
-- Indices de la tabla `words_ko`
--
ALTER TABLE `words_ko`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKr9hyjpg1jf6axdm1081wotjvi` (`id_language`),
  ADD KEY `FKdwbq99xdgilyq6npp43o827qd` (`id_word_reference`);

--
-- Indices de la tabla `words_references`
--
ALTER TABLE `words_references`
  ADD PRIMARY KEY (`id_word_ref`),
  ADD KEY `FKfixkocnge9odx8hb06pnkbfmu` (`grammatical_category`),
  ADD KEY `FKdpr73vefs1n4fik2dak8om6ey` (`language_level`);

--
-- Indices de la tabla `writing_system`
--
ALTER TABLE `writing_system`
  ADD PRIMARY KEY (`id_writing_system`),
  ADD UNIQUE KEY `UK_43gfu6dj6yfjxmfc9i9eyeb7n` (`iso_code`),
  ADD UNIQUE KEY `UK_7ng1ygkn8xy8tm1ipdss11blp` (`name`);

--
-- Indices de la tabla `xp_levels`
--
ALTER TABLE `xp_levels`
  ADD PRIMARY KEY (`level_number`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `profiles`
--
ALTER TABLE `profiles`
  MODIFY `id_profile` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `users_progress_data`
--
ALTER TABLE `users_progress_data`
  MODIFY `id_user_progress_data` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `users_relationships`
--
ALTER TABLE `users_relationships`
  MODIFY `id_relationship` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_ar`
--
ALTER TABLE `words_ar`
  MODIFY `id_word` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_en`
--
ALTER TABLE `words_en`
  MODIFY `id_word` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_es`
--
ALTER TABLE `words_es`
  MODIFY `id_word` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_fr`
--
ALTER TABLE `words_fr`
  MODIFY `id_word` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_ko`
--
ALTER TABLE `words_ko`
  MODIFY `id_word` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `writing_system`
--
ALTER TABLE `writing_system`
  MODIFY `id_writing_system` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `xp_levels`
--
ALTER TABLE `xp_levels`
  MODIFY `level_number` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categories`
--
ALTER TABLE `categories`
  ADD CONSTRAINT `FKhg4x3e4swg3wt9pcrcmu9pwq9` FOREIGN KEY (`word_reference_name`) REFERENCES `words_references` (`id_word_ref`);

--
-- Filtros para la tabla `languages`
--
ALTER TABLE `languages`
  ADD CONSTRAINT `FK1jehgb0lhjldnfdjr87ywfxnw` FOREIGN KEY (`id_writing_system`) REFERENCES `writing_system` (`id_writing_system`);

--
-- Filtros para la tabla `lessons`
--
ALTER TABLE `lessons`
  ADD CONSTRAINT `FK98c8sfja1tjgys2yobn1pfq4b` FOREIGN KEY (`language_level`) REFERENCES `language_levels` (`id_level`);

--
-- Filtros para la tabla `lessons_wordsref`
--
ALTER TABLE `lessons_wordsref`
  ADD CONSTRAINT `FKfbcrwmy9p95kwo16dixxtfgg2` FOREIGN KEY (`id_lesson`) REFERENCES `lessons` (`id_lesson`),
  ADD CONSTRAINT `FKmnfrcklf42vdjpmtt17vrve7r` FOREIGN KEY (`id_ref`) REFERENCES `words_references` (`id_word_ref`);

--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK8pbj2nsrxosm3225us23fis6b` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`),
  ADD CONSTRAINT `FKqj9x21sfqd587eftgyadv12xs` FOREIGN KEY (`id_user_progress_data`) REFERENCES `users_progress_data` (`id_user_progress_data`);

--
-- Filtros para la tabla `users_activity`
--
ALTER TABLE `users_activity`
  ADD CONSTRAINT `FK2hf95ac72f7c1e2xoxromsyls` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `FKchu72emf54gqg1b2yohrhhki0` FOREIGN KEY (`id_user_languages`) REFERENCES `users_languages` (`id_user_languages`),
  ADD CONSTRAINT `FKlj6i821armf9ppgu5kuxvowq7` FOREIGN KEY (`activity_type`) REFERENCES `activity_types` (`id_activity_type`);

--
-- Filtros para la tabla `users_completed_lessons`
--
ALTER TABLE `users_completed_lessons`
  ADD CONSTRAINT `FK99j6gogiixxp5g61108nsv9jr` FOREIGN KEY (`id_user_languages`) REFERENCES `users_languages` (`id_user_languages`),
  ADD CONSTRAINT `FKbf3wtq4v6u1rtfvnktvm9yuij` FOREIGN KEY (`id_lesson`) REFERENCES `lessons` (`id_lesson`);

--
-- Filtros para la tabla `users_languages`
--
ALTER TABLE `users_languages`
  ADD CONSTRAINT `FK31dijys7yd3t62wpst2qwvbdl` FOREIGN KEY (`id_language_level`) REFERENCES `language_levels` (`id_level`),
  ADD CONSTRAINT `FK4x1uhrc2aq8x3p61783rn6963` FOREIGN KEY (`language_origin`) REFERENCES `languages` (`id_language`),
  ADD CONSTRAINT `FK6mdtd9kr7445yvnq3ivlw4g7g` FOREIGN KEY (`language_target`) REFERENCES `languages` (`id_language`),
  ADD CONSTRAINT `FKd02kqdfvbdmgkgkxhodpdqy7k` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Filtros para la tabla `users_profiles`
--
ALTER TABLE `users_profiles`
  ADD CONSTRAINT `FKri1mhekq3lfqqx9hoqaiigj61` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `FKrogbsl5ufv6gdqwxff0nq5wrm` FOREIGN KEY (`id_profile`) REFERENCES `profiles` (`id_profile`);

--
-- Filtros para la tabla `users_progress_data`
--
ALTER TABLE `users_progress_data`
  ADD CONSTRAINT `FKk2te2qvo993y00nvv1sr3v878` FOREIGN KEY (`xp_level`) REFERENCES `xp_levels` (`level_number`),
  ADD CONSTRAINT `FKl9hg2k2nr5w3bjxcab7gng00` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Filtros para la tabla `users_relationships`
--
ALTER TABLE `users_relationships`
  ADD CONSTRAINT `FK52vupt2w21jvxecskty14bsye` FOREIGN KEY (`id_user2`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `FKf63qvdx88wueybq32ai30pl9i` FOREIGN KEY (`id_user1`) REFERENCES `users` (`id_user`);

--
-- Filtros para la tabla `words_ar`
--
ALTER TABLE `words_ar`
  ADD CONSTRAINT `FKqhr83o8e6udoapb2ceo2an5uy` FOREIGN KEY (`id_word_reference`) REFERENCES `words_references` (`id_word_ref`),
  ADD CONSTRAINT `FKrefs122dhmutfo9n57qnnehjd` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`);

--
-- Filtros para la tabla `words_en`
--
ALTER TABLE `words_en`
  ADD CONSTRAINT `FK3kle1f0j36a20cs10xisbw4s` FOREIGN KEY (`id_word_reference`) REFERENCES `words_references` (`id_word_ref`),
  ADD CONSTRAINT `FKmqqnepquqrtcorkb3iqnvyv4l` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`);

--
-- Filtros para la tabla `words_es`
--
ALTER TABLE `words_es`
  ADD CONSTRAINT `FKidxcha5og11g9y6j629dsq04m` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`),
  ADD CONSTRAINT `FKtj9otv8lapt6ru6pd57xtauo8` FOREIGN KEY (`id_word_reference`) REFERENCES `words_references` (`id_word_ref`);

--
-- Filtros para la tabla `words_fr`
--
ALTER TABLE `words_fr`
  ADD CONSTRAINT `FKfghrlclfk3ldmjtiobccu2mhg` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`),
  ADD CONSTRAINT `FKh1dd2e16d4g2t2mki4kicxi0s` FOREIGN KEY (`id_word_reference`) REFERENCES `words_references` (`id_word_ref`);

--
-- Filtros para la tabla `words_ko`
--
ALTER TABLE `words_ko`
  ADD CONSTRAINT `FKdwbq99xdgilyq6npp43o827qd` FOREIGN KEY (`id_word_reference`) REFERENCES `words_references` (`id_word_ref`),
  ADD CONSTRAINT `FKr9hyjpg1jf6axdm1081wotjvi` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`);

--
-- Filtros para la tabla `words_references`
--
ALTER TABLE `words_references`
  ADD CONSTRAINT `FKdpr73vefs1n4fik2dak8om6ey` FOREIGN KEY (`language_level`) REFERENCES `language_levels` (`id_level`),
  ADD CONSTRAINT `FKfixkocnge9odx8hb06pnkbfmu` FOREIGN KEY (`grammatical_category`) REFERENCES `grammatical_categories` (`id_grammatical_category`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
