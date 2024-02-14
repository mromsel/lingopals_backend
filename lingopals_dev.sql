-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-02-2024 a las 21:19:23
-- Versión del servidor: 5.7.35-0ubuntu0.18.04.2
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `lingopals_dev`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE `categories` (
  `id_category` int(11) NOT NULL,
  `word_reference_name` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `languages`
--

CREATE TABLE `languages` (
  `id_language` int(11) NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `iso_code` varchar(255) DEFAULT NULL,
  `language_name` varchar(255) DEFAULT NULL,
  `id_writing_system` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `language_levels`
--

CREATE TABLE `language_levels` (
  `id_level` int(11) NOT NULL,
  `level_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lessons`
--

CREATE TABLE `lessons` (
  `id_lesson` int(11) NOT NULL,
  `language_level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lesson_words`
--

CREATE TABLE `lesson_words` (
  `id_lesson` int(11) NOT NULL,
  `id_ref` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_aditional_info_ar`
--

CREATE TABLE `words_aditional_info_ar` (
  `id_word_aditional_info` bigint(20) NOT NULL,
  `changes_on_gender` bit(1) NOT NULL,
  `changes_on_plural` bit(1) NOT NULL,
  `gender_variations` varbinary(255) DEFAULT NULL,
  `gramatical_category` varchar(255) NOT NULL,
  `gramatical_gender` varchar(255) NOT NULL,
  `number_variations` varbinary(255) DEFAULT NULL,
  `pronunciation` varchar(255) NOT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `id_word` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_aditional_info_en`
--

CREATE TABLE `words_aditional_info_en` (
  `id_word_aditional_info` bigint(20) NOT NULL,
  `changes_on_gender` bit(1) NOT NULL,
  `changes_on_plural` bit(1) NOT NULL,
  `gender_variations` varbinary(255) DEFAULT NULL,
  `gramatical_category` varchar(255) NOT NULL,
  `gramatical_gender` varchar(255) NOT NULL,
  `number_variations` varbinary(255) DEFAULT NULL,
  `pronunciation` varchar(255) NOT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `id_word` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_aditional_info_es`
--

CREATE TABLE `words_aditional_info_es` (
  `id_word_aditional_info` bigint(20) NOT NULL,
  `changes_on_gender` bit(1) NOT NULL,
  `changes_on_plural` bit(1) NOT NULL,
  `gender_variations` varbinary(255) DEFAULT NULL,
  `gramatical_category` varchar(255) NOT NULL,
  `gramatical_gender` varchar(255) NOT NULL,
  `number_variations` varbinary(255) DEFAULT NULL,
  `pronunciation` varchar(255) NOT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `id_word` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_aditional_info_fr`
--

CREATE TABLE `words_aditional_info_fr` (
  `id_word_aditional_info` bigint(20) NOT NULL,
  `changes_on_gender` bit(1) NOT NULL,
  `changes_on_plural` bit(1) NOT NULL,
  `gender_variations` varbinary(255) DEFAULT NULL,
  `gramatical_category` varchar(255) NOT NULL,
  `gramatical_gender` varchar(255) NOT NULL,
  `number_variations` varbinary(255) DEFAULT NULL,
  `pronunciation` varchar(255) NOT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `id_word` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_aditional_info_ko`
--

CREATE TABLE `words_aditional_info_ko` (
  `id_word_aditional_info` bigint(20) NOT NULL,
  `changes_on_gender` bit(1) NOT NULL,
  `changes_on_plural` bit(1) NOT NULL,
  `gender_variations` varbinary(255) DEFAULT NULL,
  `gramatical_category` varchar(255) NOT NULL,
  `gramatical_gender` varchar(255) NOT NULL,
  `number_variations` varbinary(255) DEFAULT NULL,
  `pronunciation` varchar(255) NOT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `id_word` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_ar`
--

CREATE TABLE `words_ar` (
  `id_word` bigint(20) NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `id_language` int(11) NOT NULL,
  `word_reference` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_en`
--

CREATE TABLE `words_en` (
  `id_word` bigint(20) NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `id_language` int(11) NOT NULL,
  `word_reference` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_es`
--

CREATE TABLE `words_es` (
  `id_word` bigint(20) NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `id_language` int(11) NOT NULL,
  `word_reference` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_fr`
--

CREATE TABLE `words_fr` (
  `id_word` bigint(20) NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `id_language` int(11) NOT NULL,
  `word_reference` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_ko`
--

CREATE TABLE `words_ko` (
  `id_word` bigint(20) NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `id_language` int(11) NOT NULL,
  `word_reference` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_references`
--

CREATE TABLE `words_references` (
  `id_word_ref` bigint(20) NOT NULL,
  `category` int(11) NOT NULL,
  `language_level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_references_lessons`
--

CREATE TABLE `words_references_lessons` (
  `words_references_id_word_ref` bigint(20) NOT NULL,
  `lessons_id_lesson` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `writing_system`
--

CREATE TABLE `writing_system` (
  `id_writing_system` int(11) NOT NULL,
  `iso_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id_category`),
  ADD UNIQUE KEY `UK_54ov48ghbxyrcv281sm2ni8ad` (`word_reference_name`);

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
-- Indices de la tabla `lesson_words`
--
ALTER TABLE `lesson_words`
  ADD KEY `FKqb6kieyjofs2qs3knb0jo1tqd` (`id_ref`),
  ADD KEY `FK6vvtcla2smpgxl7t3r42iu14i` (`id_lesson`);

--
-- Indices de la tabla `words_aditional_info_ar`
--
ALTER TABLE `words_aditional_info_ar`
  ADD PRIMARY KEY (`id_word_aditional_info`),
  ADD UNIQUE KEY `UK_83q099eu2c7w84hs2okj6w5av` (`id_word`);

--
-- Indices de la tabla `words_aditional_info_en`
--
ALTER TABLE `words_aditional_info_en`
  ADD PRIMARY KEY (`id_word_aditional_info`),
  ADD UNIQUE KEY `UK_ekfsb7459jrhkf6x2h9qg5p5w` (`id_word`);

--
-- Indices de la tabla `words_aditional_info_es`
--
ALTER TABLE `words_aditional_info_es`
  ADD PRIMARY KEY (`id_word_aditional_info`),
  ADD UNIQUE KEY `UK_d1dn24uwjvcxfbw9isgo3opu8` (`id_word`);

--
-- Indices de la tabla `words_aditional_info_fr`
--
ALTER TABLE `words_aditional_info_fr`
  ADD PRIMARY KEY (`id_word_aditional_info`),
  ADD UNIQUE KEY `UK_h4h3fra721trr5n7og0cl1rw7` (`id_word`);

--
-- Indices de la tabla `words_aditional_info_ko`
--
ALTER TABLE `words_aditional_info_ko`
  ADD PRIMARY KEY (`id_word_aditional_info`),
  ADD UNIQUE KEY `UK_7n4iif448hweok5ir7iqop08a` (`id_word`);

--
-- Indices de la tabla `words_ar`
--
ALTER TABLE `words_ar`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKrefs122dhmutfo9n57qnnehjd` (`id_language`),
  ADD KEY `FK44e5hpcv920emswb3r0ytf3o8` (`word_reference`);

--
-- Indices de la tabla `words_en`
--
ALTER TABLE `words_en`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKmqqnepquqrtcorkb3iqnvyv4l` (`id_language`),
  ADD KEY `FKkluboy5ytvaj6rv4ut1qt3cs` (`word_reference`);

--
-- Indices de la tabla `words_es`
--
ALTER TABLE `words_es`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKidxcha5og11g9y6j629dsq04m` (`id_language`),
  ADD KEY `FKlfkcro1y8gcjkme83myp27ji1` (`word_reference`);

--
-- Indices de la tabla `words_fr`
--
ALTER TABLE `words_fr`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKfghrlclfk3ldmjtiobccu2mhg` (`id_language`),
  ADD KEY `FK7ln7q69km9fxya92du78hs3bu` (`word_reference`);

--
-- Indices de la tabla `words_ko`
--
ALTER TABLE `words_ko`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKr9hyjpg1jf6axdm1081wotjvi` (`id_language`),
  ADD KEY `FK1c2bxwuqqxi4ptt4ykj8i8lu6` (`word_reference`);

--
-- Indices de la tabla `words_references`
--
ALTER TABLE `words_references`
  ADD PRIMARY KEY (`id_word_ref`),
  ADD KEY `FK5h41kgjj1uw36pp4a5670c4g5` (`category`),
  ADD KEY `FKdpr73vefs1n4fik2dak8om6ey` (`language_level`);

--
-- Indices de la tabla `words_references_lessons`
--
ALTER TABLE `words_references_lessons`
  ADD KEY `FKd0de19y38qmnm6qlom3y8y1f7` (`lessons_id_lesson`),
  ADD KEY `FKd891ptf5fvafdigrt8iau7gsf` (`words_references_id_word_ref`);

--
-- Indices de la tabla `writing_system`
--
ALTER TABLE `writing_system`
  ADD PRIMARY KEY (`id_writing_system`),
  ADD UNIQUE KEY `UK_43gfu6dj6yfjxmfc9i9eyeb7n` (`iso_code`),
  ADD UNIQUE KEY `UK_7ng1ygkn8xy8tm1ipdss11blp` (`name`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `words_aditional_info_ar`
--
ALTER TABLE `words_aditional_info_ar`
  MODIFY `id_word_aditional_info` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_aditional_info_en`
--
ALTER TABLE `words_aditional_info_en`
  MODIFY `id_word_aditional_info` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_aditional_info_es`
--
ALTER TABLE `words_aditional_info_es`
  MODIFY `id_word_aditional_info` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_aditional_info_fr`
--
ALTER TABLE `words_aditional_info_fr`
  MODIFY `id_word_aditional_info` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_aditional_info_ko`
--
ALTER TABLE `words_aditional_info_ko`
  MODIFY `id_word_aditional_info` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_ar`
--
ALTER TABLE `words_ar`
  MODIFY `id_word` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_en`
--
ALTER TABLE `words_en`
  MODIFY `id_word` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_es`
--
ALTER TABLE `words_es`
  MODIFY `id_word` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_fr`
--
ALTER TABLE `words_fr`
  MODIFY `id_word` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words_ko`
--
ALTER TABLE `words_ko`
  MODIFY `id_word` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `writing_system`
--
ALTER TABLE `writing_system`
  MODIFY `id_writing_system` int(11) NOT NULL AUTO_INCREMENT;

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
-- Filtros para la tabla `lesson_words`
--
ALTER TABLE `lesson_words`
  ADD CONSTRAINT `FK6vvtcla2smpgxl7t3r42iu14i` FOREIGN KEY (`id_lesson`) REFERENCES `lessons` (`id_lesson`),
  ADD CONSTRAINT `FKqb6kieyjofs2qs3knb0jo1tqd` FOREIGN KEY (`id_ref`) REFERENCES `words_references` (`id_word_ref`);

--
-- Filtros para la tabla `words_aditional_info_ar`
--
ALTER TABLE `words_aditional_info_ar`
  ADD CONSTRAINT `FKa2yrvjod68fqf67m32h6kucqe` FOREIGN KEY (`id_word`) REFERENCES `words_ar` (`id_word`);

--
-- Filtros para la tabla `words_aditional_info_en`
--
ALTER TABLE `words_aditional_info_en`
  ADD CONSTRAINT `FKfktrvbsd3we45nk607kvd7q60` FOREIGN KEY (`id_word`) REFERENCES `words_en` (`id_word`);

--
-- Filtros para la tabla `words_aditional_info_es`
--
ALTER TABLE `words_aditional_info_es`
  ADD CONSTRAINT `FKd14l2dog36kirxpvmj3oea31l` FOREIGN KEY (`id_word`) REFERENCES `words_es` (`id_word`);

--
-- Filtros para la tabla `words_aditional_info_fr`
--
ALTER TABLE `words_aditional_info_fr`
  ADD CONSTRAINT `FK31w8b741sg0pcm9k5plyl9233` FOREIGN KEY (`id_word`) REFERENCES `words_fr` (`id_word`);

--
-- Filtros para la tabla `words_aditional_info_ko`
--
ALTER TABLE `words_aditional_info_ko`
  ADD CONSTRAINT `FK2es90yeowj3yytpnnr5fbepye` FOREIGN KEY (`id_word`) REFERENCES `words_ko` (`id_word`);

--
-- Filtros para la tabla `words_ar`
--
ALTER TABLE `words_ar`
  ADD CONSTRAINT `FK44e5hpcv920emswb3r0ytf3o8` FOREIGN KEY (`word_reference`) REFERENCES `words_references` (`id_word_ref`),
  ADD CONSTRAINT `FKrefs122dhmutfo9n57qnnehjd` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`);

--
-- Filtros para la tabla `words_en`
--
ALTER TABLE `words_en`
  ADD CONSTRAINT `FKkluboy5ytvaj6rv4ut1qt3cs` FOREIGN KEY (`word_reference`) REFERENCES `words_references` (`id_word_ref`),
  ADD CONSTRAINT `FKmqqnepquqrtcorkb3iqnvyv4l` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`);

--
-- Filtros para la tabla `words_es`
--
ALTER TABLE `words_es`
  ADD CONSTRAINT `FKidxcha5og11g9y6j629dsq04m` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`),
  ADD CONSTRAINT `FKlfkcro1y8gcjkme83myp27ji1` FOREIGN KEY (`word_reference`) REFERENCES `words_references` (`id_word_ref`);

--
-- Filtros para la tabla `words_fr`
--
ALTER TABLE `words_fr`
  ADD CONSTRAINT `FK7ln7q69km9fxya92du78hs3bu` FOREIGN KEY (`word_reference`) REFERENCES `words_references` (`id_word_ref`),
  ADD CONSTRAINT `FKfghrlclfk3ldmjtiobccu2mhg` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`);

--
-- Filtros para la tabla `words_ko`
--
ALTER TABLE `words_ko`
  ADD CONSTRAINT `FK1c2bxwuqqxi4ptt4ykj8i8lu6` FOREIGN KEY (`word_reference`) REFERENCES `words_references` (`id_word_ref`),
  ADD CONSTRAINT `FKr9hyjpg1jf6axdm1081wotjvi` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`);

--
-- Filtros para la tabla `words_references`
--
ALTER TABLE `words_references`
  ADD CONSTRAINT `FK5h41kgjj1uw36pp4a5670c4g5` FOREIGN KEY (`category`) REFERENCES `categories` (`id_category`),
  ADD CONSTRAINT `FKdpr73vefs1n4fik2dak8om6ey` FOREIGN KEY (`language_level`) REFERENCES `language_levels` (`id_level`);

--
-- Filtros para la tabla `words_references_lessons`
--
ALTER TABLE `words_references_lessons`
  ADD CONSTRAINT `FKd0de19y38qmnm6qlom3y8y1f7` FOREIGN KEY (`lessons_id_lesson`) REFERENCES `lessons` (`id_lesson`),
  ADD CONSTRAINT `FKd891ptf5fvafdigrt8iau7gsf` FOREIGN KEY (`words_references_id_word_ref`) REFERENCES `words_references` (`id_word_ref`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
