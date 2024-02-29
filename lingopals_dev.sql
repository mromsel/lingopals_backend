-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 29-02-2024 a las 00:57:18
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
  `id_writing_system` int(11) NOT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `iso_code` varchar(255) DEFAULT NULL,
  `language_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `languages`
--

INSERT INTO `languages` (`id_language`, `id_writing_system`, `flag`, `iso_code`, `language_name`) VALUES
(1, 1, 'flag_en.png', 'en', 'English'),
(2, 1, 'flag_es.png', 'es', 'Español'),
(3, 1, 'flag_fr.png', 'fr', 'Français'),
(4, 2, 'flag_ko.png', 'ko', '한국어'),
(5, 3, 'flag_ar.png', 'ar', 'العربية');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `language_levels`
--

CREATE TABLE `language_levels` (
  `id_level` int(11) NOT NULL,
  `level_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `id_lesson` int(11) NOT NULL,
  `language_level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lessons_wordsref`
--

CREATE TABLE `lessons_wordsref` (
  `id_lesson` int(11) NOT NULL,
  `id_ref` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words`
--

CREATE TABLE `words` (
  `id_language` int(11) NOT NULL,
  `id_word` bigint(20) NOT NULL,
  `id_word_reference` bigint(20) NOT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `words`
--

INSERT INTO `words` (`id_language`, `id_word`, `id_word_reference`, `definition`, `word`) VALUES
(1, 1, 1, 'A domesticated carnivorous mammal (Canis familiaris) related to the foxes and wolves and raised in a wide variety of breeds.', 'dog'),
(2, 2, 1, 'Un mamífero carnívoro doméstico (Canis familiaris) relacionado con los zorros y lobos y criado en una amplia variedad de razas.', 'perro'),
(3, 3, 1, 'A domesticated carnivorous mammal (Canis familiaris) related to the foxes and wolves and raised in a wide variety of breeds.', 'chien'),
(4, 4, 1, '개는 여우와 늑대에 관련된 가축의 육식 동물입니다. 다양한 품종으로 기르고 있습니다.', '개'),
(5, 5, 1, 'هو حيوان من الثدييات اللاحمة الحيوانية المألوفة يُربى في مجموعة واسعة من السلالات.', 'كلب');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_additional_info`
--

CREATE TABLE `words_additional_info` (
  `changes_on_gender` bit(1) NOT NULL,
  `changes_on_plural` bit(1) NOT NULL,
  `id_word` bigint(20) NOT NULL,
  `id_word_additional_info` bigint(20) NOT NULL,
  `gramatical_category` varchar(255) NOT NULL,
  `gramatical_gender` varchar(255) NOT NULL,
  `pronunciation` varchar(255) NOT NULL,
  `romanization` varchar(255) DEFAULT NULL,
  `gender_variations` varbinary(255) DEFAULT NULL,
  `number_variations` varbinary(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words_references`
--

CREATE TABLE `words_references` (
  `category` int(11) DEFAULT NULL,
  `language_level` int(11) NOT NULL,
  `id_word_ref` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `words_references`
--

INSERT INTO `words_references` (`category`, `language_level`, `id_word_ref`) VALUES
(NULL, 1, 1);

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
-- Volcado de datos para la tabla `writing_system`
--

INSERT INTO `writing_system` (`id_writing_system`, `iso_code`, `name`) VALUES
(1, 'rom', 'Roman Characters'),
(2, 'hangul', 'Hangul Characters'),
(3, 'arab', 'Arabic Characters');

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
-- Indices de la tabla `lessons_wordsref`
--
ALTER TABLE `lessons_wordsref`
  ADD KEY `FKmnfrcklf42vdjpmtt17vrve7r` (`id_ref`),
  ADD KEY `FKfbcrwmy9p95kwo16dixxtfgg2` (`id_lesson`);

--
-- Indices de la tabla `words`
--
ALTER TABLE `words`
  ADD PRIMARY KEY (`id_word`),
  ADD KEY `FKel7o806pyraf1uyhcvt6wst0u` (`id_language`),
  ADD KEY `FKkdc1n0gj2x214298t2q137qqf` (`id_word_reference`);

--
-- Indices de la tabla `words_additional_info`
--
ALTER TABLE `words_additional_info`
  ADD PRIMARY KEY (`id_word_additional_info`),
  ADD UNIQUE KEY `UK_7j56y4s53l73rjo70oqslciq6` (`id_word`);

--
-- Indices de la tabla `words_references`
--
ALTER TABLE `words_references`
  ADD PRIMARY KEY (`id_word_ref`),
  ADD KEY `FK5h41kgjj1uw36pp4a5670c4g5` (`category`),
  ADD KEY `FKdpr73vefs1n4fik2dak8om6ey` (`language_level`);

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
-- AUTO_INCREMENT de la tabla `words`
--
ALTER TABLE `words`
  MODIFY `id_word` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `words_additional_info`
--
ALTER TABLE `words_additional_info`
  MODIFY `id_word_additional_info` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `writing_system`
--
ALTER TABLE `writing_system`
  MODIFY `id_writing_system` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
-- Filtros para la tabla `words`
--
ALTER TABLE `words`
  ADD CONSTRAINT `FKel7o806pyraf1uyhcvt6wst0u` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id_language`),
  ADD CONSTRAINT `FKkdc1n0gj2x214298t2q137qqf` FOREIGN KEY (`id_word_reference`) REFERENCES `words_references` (`id_word_ref`);

--
-- Filtros para la tabla `words_additional_info`
--
ALTER TABLE `words_additional_info`
  ADD CONSTRAINT `FK8h0stg5luqnomdxgqfyt8rd5b` FOREIGN KEY (`id_word`) REFERENCES `words` (`id_word`);

--
-- Filtros para la tabla `words_references`
--
ALTER TABLE `words_references`
  ADD CONSTRAINT `FK5h41kgjj1uw36pp4a5670c4g5` FOREIGN KEY (`category`) REFERENCES `categories` (`id_category`),
  ADD CONSTRAINT `FKdpr73vefs1n4fik2dak8om6ey` FOREIGN KEY (`language_level`) REFERENCES `language_levels` (`id_level`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
