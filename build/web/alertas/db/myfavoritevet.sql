-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2018 a las 18:29:28
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `myfavoritevet`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_roles`
--

CREATE TABLE `tbl_roles` (
  `PK_ROL_IdRol` int(11) NOT NULL COMMENT 'En este campo se especifica el identificador del rol',
  `ROL_NombreRol` varchar(20) NOT NULL COMMENT 'En este campo se especifica el nombre del rol'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_roles`
--

INSERT INTO `tbl_roles` (`PK_ROL_IdRol`, `ROL_NombreRol`) VALUES
(1, 'Administrador'),
(2, 'Veterinario'),
(3, 'Cliente'),
(4, 'Empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `PK_USU_IdUsuario` int(11) NOT NULL COMMENT 'En este campo se especifica el identificador del usuario',
  `USU_Nombre` varchar(50) DEFAULT NULL COMMENT 'En este campo se especifica el nombre del usuario',
  `USU_Apellido` varchar(50) DEFAULT NULL COMMENT 'En este campo se especifica el apellido del usuario',
  `USU_Direccion` varchar(30) DEFAULT NULL COMMENT 'En este campo se especifica la dirección del usuario',
  `USU_Email` varchar(50) NOT NULL COMMENT 'En este campo se especifica la direccion de correo del usuario',
  `USU_Sexo` varchar(50) DEFAULT NULL COMMENT 'En este campo se especifica el sexo del usuario',
  `USU_FechaNacimiento` date DEFAULT NULL COMMENT 'En este campo se especifica la fecha de nacimiento del usuario',
  `USU_TipoDocumento` varchar(25) DEFAULT NULL COMMENT 'En este campo se especifica el tipo de documento de identificacion del usuario',
  `USU_NumeroDocumento` bigint(20) DEFAULT NULL COMMENT 'En este campo se especifica el numero de documento del usuario',
  `USU_Telefono` bigint(20) DEFAULT NULL COMMENT 'En este campo se especifica el numero telefonico del usuario',
  `USU_Clave` varchar(255) DEFAULT NULL,
  `USU_Estado` varchar(35) DEFAULT 'Inactivo'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`PK_USU_IdUsuario`, `USU_Nombre`, `USU_Apellido`, `USU_Direccion`, `USU_Email`, `USU_Sexo`, `USU_FechaNacimiento`, `USU_TipoDocumento`, `USU_NumeroDocumento`, `USU_Telefono`, `USU_Clave`, `USU_Estado`) VALUES
(96, 'Jorge D', 'E', 'mi casa', 'correo@correo.com.co', NULL, NULL, 'Tarjeta de identidad', 123456987, 5777777, '123', 'Inactivo'),
(97, 'AndreaJeimmy', NULL, NULL, 'jeimmy@sena.com', NULL, NULL, NULL, NULL, NULL, '1234567', 'Inactivo'),
(98, 'fernanda garcia', NULL, NULL, 'fernanda@gmail.com', NULL, NULL, NULL, NULL, NULL, '1234', 'Inactivo'),
(99, 'Natalia', 'Herrera', 'Carrera 2E # 2-73', 'nherrera086@misena.edu.co', NULL, NULL, 'Cedula de ciudadania', 1073239680, 8931678, '1234', 'Activo'),
(100, 'NicolasAguilera', NULL, NULL, 'haguilera@hotmail.com', NULL, NULL, NULL, NULL, NULL, '9785893', 'Inactivo'),
(101, 'Diego', NULL, NULL, 'diego@gmail.com', NULL, NULL, NULL, NULL, NULL, '123', 'Inactivo'),
(102, 'Anderson ', NULL, NULL, 'adsalguero@misena.edu.co', NULL, NULL, NULL, NULL, NULL, '1621', 'Inactivo'),
(103, 'ClarissaPenagos', NULL, NULL, 'cpenagos95@misena.edu.co', NULL, NULL, NULL, NULL, NULL, 'clary99', 'Inactivo'),
(104, 'camilo', NULL, NULL, 'camiloram@camiloram.com', NULL, NULL, NULL, NULL, NULL, '1234', 'Inactivo'),
(105, 'Alex', NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '', 'Inactivo'),
(106, 'Juan Sanchez', 'ssdsdds', 'dsdsds', 'jfsanchez026@misena.edu.co', NULL, NULL, 'Cedula de ciudadania', 33333, 23233232, '1234', 'Inactivo'),
(108, 'Yhoiner', 'Morales Rios', 'qwer123 324', 'yomo@gmail', NULL, NULL, 'Cedula de ciudadania', 12345, 23456, '123', 'Inactivo'),
(109, 'sebastian ', 'barreto', 'mi casa', 'fenix@hotmail.com', NULL, NULL, 'Tarjeta de identidad', 1014182765, 123456788, '1234', 'Inactivo'),
(111, 'Jhon7', NULL, NULL, 'jhon7@gmail.com', NULL, NULL, NULL, NULL, NULL, 'jhon123', 'Inactivo'),
(112, 'stiven', NULL, NULL, 'stiven@gmail.com', NULL, NULL, NULL, NULL, NULL, '123', 'Inactivo'),
(114, 'Laliendra', NULL, NULL, 'laliendramillos@millos.com', NULL, NULL, NULL, NULL, NULL, '1234', 'Inactivo'),
(115, 'kate', NULL, NULL, 'kate@gmail.com', NULL, NULL, NULL, NULL, NULL, '1234', 'Inactivo'),
(116, 'HaiverNicolas', NULL, NULL, 'hnaguilera1@hotmail.com', NULL, NULL, NULL, NULL, NULL, '4567', 'Inactivo'),
(117, 'Yasuri yamile', NULL, NULL, 'yasuriyamile@gmail.com', NULL, NULL, NULL, NULL, NULL, '1234', 'Inactivo'),
(119, 'jose', NULL, NULL, 'jose@gmail.com', NULL, NULL, NULL, NULL, NULL, '1234', 'Inactivo'),
(120, 'jose', NULL, NULL, 'afbandera@misena.edu.co', NULL, NULL, NULL, NULL, NULL, '1234', 'Inactivo'),
(122, 'Diego Andres', 'Burgos Estrada', 'Cr: 23 ', 'diedburgos@gmail.com', NULL, NULL, 'Cedula de ciudadania', 1005418132, 1111111111, '123', 'Inactivo'),
(125, 'Doppelganger', 'Clon', 'Cra clon', 'clon@clon.com', NULL, NULL, 'Cedula de ciudadania', 1007101368, 123456789, '123', 'Inactivo'),
(126, 'nicolas0105', NULL, NULL, 'nicolas@tw.com', NULL, NULL, NULL, NULL, NULL, 'nicolas', 'Inactivo'),
(127, 'Cristian', NULL, NULL, 'cortiz721@misena.edu.co', NULL, NULL, NULL, NULL, NULL, '0123', 'Inactivo'),
(128, 'daniel', NULL, NULL, 'dani@dani.com', NULL, NULL, NULL, NULL, NULL, '123456', 'Inactivo'),
(129, 'cristian', NULL, NULL, 'cris@gmail.com', NULL, NULL, NULL, NULL, NULL, '1234', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuariosroles`
--

CREATE TABLE `tbl_usuariosroles` (
  `FK_USU_IdUsuario` int(11) NOT NULL COMMENT 'En este campo se especifica el identificador del usuario',
  `FK_ROL_IdRol` int(11) NOT NULL COMMENT 'En este campo se identifica el identificador del rol'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_usuariosroles`
--

INSERT INTO `tbl_usuariosroles` (`FK_USU_IdUsuario`, `FK_ROL_IdRol`) VALUES
(96, 3),
(97, 3),
(98, 3),
(99, 3),
(100, 3),
(101, 3),
(102, 3),
(103, 3),
(104, 3),
(105, 3),
(106, 3),
(108, 3),
(109, 3),
(111, 3),
(112, 3),
(114, 3),
(115, 3),
(116, 3),
(117, 3),
(119, 3),
(120, 3),
(99, 1),
(122, 3),
(125, 3),
(126, 3),
(127, 3),
(128, 3),
(129, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_roles`
--
ALTER TABLE `tbl_roles`
  ADD PRIMARY KEY (`PK_ROL_IdRol`);

--
-- Indices de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`PK_USU_IdUsuario`,`USU_Email`),
  ADD UNIQUE KEY `USU_Email` (`USU_Email`);

--
-- Indices de la tabla `tbl_usuariosroles`
--
ALTER TABLE `tbl_usuariosroles`
  ADD KEY `FK_USU_IdUsuario` (`FK_USU_IdUsuario`),
  ADD KEY `FK_ROL_IdRol` (`FK_ROL_IdRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_roles`
--
ALTER TABLE `tbl_roles`
  MODIFY `PK_ROL_IdRol` int(11) NOT NULL AUTO_INCREMENT COMMENT 'En este campo se especifica el identificador del rol', AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `PK_USU_IdUsuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'En este campo se especifica el identificador del usuario', AUTO_INCREMENT=130;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_usuariosroles`
--
ALTER TABLE `tbl_usuariosroles`
  ADD CONSTRAINT `tbl_usuariosroles_ibfk_1` FOREIGN KEY (`FK_USU_IdUsuario`) REFERENCES `tbl_usuarios` (`PK_USU_IdUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tbl_usuariosroles_ibfk_2` FOREIGN KEY (`FK_ROL_IdRol`) REFERENCES `tbl_roles` (`PK_ROL_IdRol`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
