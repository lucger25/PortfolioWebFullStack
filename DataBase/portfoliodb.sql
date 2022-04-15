-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-04-2022 a las 01:33:18
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `portfoliodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `education`
--

CREATE TABLE `education` (
  `id` int(11) NOT NULL,
  `user` varchar(45) NOT NULL,
  `education_title` varchar(100) DEFAULT NULL,
  `school_name` varchar(100) DEFAULT NULL,
  `education_start_date` date DEFAULT NULL,
  `education_end_date` date DEFAULT NULL,
  `school_photo` varchar(200) DEFAULT NULL,
  `persona_id` int(11) NOT NULL,
  `persona_user` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `job_experience`
--

CREATE TABLE `job_experience` (
  `id` int(11) NOT NULL,
  `user` varchar(45) NOT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `job_title` varchar(45) DEFAULT NULL,
  `job_start_date` date DEFAULT NULL,
  `job_end_date` date DEFAULT NULL,
  `job_description` varchar(150) DEFAULT NULL,
  `job_photo` varchar(200) DEFAULT NULL,
  `is_current_job` tinyint(4) DEFAULT NULL,
  `persona_id` int(11) NOT NULL,
  `persona_user` varchar(45) NOT NULL,
  `job_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `job_type`
--

CREATE TABLE `job_type` (
  `id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `user` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `persona_photo` varchar(150) DEFAULT NULL,
  `banner_photo` varchar(150) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `phonenumber` varchar(12) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `about_me` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyect`
--

CREATE TABLE `proyect` (
  `id` int(11) NOT NULL,
  `user` varchar(45) NOT NULL,
  `proyect_title` varchar(45) DEFAULT NULL,
  `proyect_description` varchar(200) DEFAULT NULL,
  `proyect_start_date` date DEFAULT NULL,
  `proyect_end_date` date DEFAULT NULL,
  `proyect_photo` varchar(200) DEFAULT NULL,
  `persona_id` int(11) NOT NULL,
  `persona_user` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `skill`
--

CREATE TABLE `skill` (
  `id` int(11) NOT NULL,
  `user` varchar(45) NOT NULL,
  `skill_title` varchar(45) DEFAULT NULL,
  `skill_tipe` varchar(45) DEFAULT NULL,
  `skill_level` varchar(45) DEFAULT NULL,
  `skill_description` varchar(150) DEFAULT NULL,
  `persona_id` int(11) NOT NULL,
  `persona_user` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`id`,`persona_id`,`persona_user`),
  ADD KEY `fk_education_persona1` (`persona_id`,`persona_user`);

--
-- Indices de la tabla `job_experience`
--
ALTER TABLE `job_experience`
  ADD PRIMARY KEY (`id`,`persona_id`,`persona_user`,`job_type_id`),
  ADD KEY `fk_job_experience_persona` (`persona_id`,`persona_user`),
  ADD KEY `fk_job_experience_job_type1` (`job_type_id`);

--
-- Indices de la tabla `job_type`
--
ALTER TABLE `job_type`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`,`user`);

--
-- Indices de la tabla `proyect`
--
ALTER TABLE `proyect`
  ADD PRIMARY KEY (`id`,`persona_id`,`persona_user`),
  ADD KEY `fk_proyect_persona1` (`persona_id`,`persona_user`);

--
-- Indices de la tabla `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`,`persona_id`,`persona_user`),
  ADD KEY `fk_skill_persona1` (`persona_id`,`persona_user`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `education`
--
ALTER TABLE `education`
  ADD CONSTRAINT `fk_education_persona1` FOREIGN KEY (`persona_id`,`persona_user`) REFERENCES `persona` (`id`, `user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `job_experience`
--
ALTER TABLE `job_experience`
  ADD CONSTRAINT `fk_job_experience_job_type1` FOREIGN KEY (`job_type_id`) REFERENCES `job_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_job_experience_persona` FOREIGN KEY (`persona_id`,`persona_user`) REFERENCES `persona` (`id`, `user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `proyect`
--
ALTER TABLE `proyect`
  ADD CONSTRAINT `fk_proyect_persona1` FOREIGN KEY (`persona_id`,`persona_user`) REFERENCES `persona` (`id`, `user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `skill`
--
ALTER TABLE `skill`
  ADD CONSTRAINT `fk_skill_persona1` FOREIGN KEY (`persona_id`,`persona_user`) REFERENCES `persona` (`id`, `user`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
