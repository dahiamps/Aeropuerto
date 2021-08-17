-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-08-2021 a las 16:14:32
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aeropuertois`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviones`
--

CREATE TABLE `aviones` (
  `matriculaAvion` varchar(7) NOT NULL,
  `modeloAvion` varchar(50) NOT NULL,
  `cedulaPropietario` int(11) NOT NULL,
  `tipoContrato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aviones`
--

INSERT INTO `aviones` (`matriculaAvion`, `modeloAvion`, `cedulaPropietario`, `tipoContrato`) VALUES
('CLA28Y', 'Jumbo', 43250423, 2),
('DAH27C', 'Airbus', 1035878882, 1),
('Jer07R', 'Airbus', 12345, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratos`
--

CREATE TABLE `contratos` (
  `tipoContrato` int(11) NOT NULL,
  `valorContrato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contratos`
--

INSERT INTO `contratos` (`tipoContrato`, `valorContrato`) VALUES
(1, 25000000),
(2, 60000000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hangares`
--

CREATE TABLE `hangares` (
  `codigoHangar` int(11) NOT NULL,
  `cuposTotales` int(11) NOT NULL,
  `cuposDisponibles` int(11) NOT NULL,
  `cuposReservados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hangares`
--

INSERT INTO `hangares` (`codigoHangar`, `cuposTotales`, `cuposDisponibles`, `cuposReservados`) VALUES
(160, 16, 13, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hangaresaviones`
--

CREATE TABLE `hangaresaviones` (
  `codigoHangar` int(11) NOT NULL,
  `matriculaAvion` varchar(7) NOT NULL,
  `fechaIngreso` datetime NOT NULL,
  `numeroCeldas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hangaresaviones`
--

INSERT INTO `hangaresaviones` (`codigoHangar`, `matriculaAvion`, `fechaIngreso`, `numeroCeldas`) VALUES
(160, 'DAH27C', '2021-08-16 15:02:03', 1),
(160, 'CLA28Y', '2021-08-16 15:02:53', 2),
(160, 'Jer07R', '2021-08-16 15:04:23', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodopago`
--

CREATE TABLE `metodopago` (
  `metodoPago` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `metodopago`
--

INSERT INTO `metodopago` (`metodoPago`, `nombre`) VALUES
(1, 'Contado'),
(2, 'Credito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `cedulaPropietario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `metodoPago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`cedulaPropietario`, `nombre`, `metodoPago`) VALUES
(12345, 'Jeremi', 2),
(43250423, 'Claudia', 2),
(1035878882, 'Dahiam', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD PRIMARY KEY (`matriculaAvion`),
  ADD KEY `fk_cedulaPropietario` (`cedulaPropietario`),
  ADD KEY `fk_tipoContrato` (`tipoContrato`);

--
-- Indices de la tabla `contratos`
--
ALTER TABLE `contratos`
  ADD PRIMARY KEY (`tipoContrato`);

--
-- Indices de la tabla `hangares`
--
ALTER TABLE `hangares`
  ADD PRIMARY KEY (`codigoHangar`);

--
-- Indices de la tabla `hangaresaviones`
--
ALTER TABLE `hangaresaviones`
  ADD KEY `fk_codigoHangar` (`codigoHangar`),
  ADD KEY `fk_matriculaAvion` (`matriculaAvion`);

--
-- Indices de la tabla `metodopago`
--
ALTER TABLE `metodopago`
  ADD PRIMARY KEY (`metodoPago`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`cedulaPropietario`),
  ADD KEY `fk_metodoPago` (`metodoPago`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD CONSTRAINT `fk_cedulaPropietario` FOREIGN KEY (`cedulaPropietario`) REFERENCES `propietarios` (`cedulaPropietario`),
  ADD CONSTRAINT `fk_tipoContrato` FOREIGN KEY (`tipoContrato`) REFERENCES `contratos` (`tipoContrato`);

--
-- Filtros para la tabla `hangaresaviones`
--
ALTER TABLE `hangaresaviones`
  ADD CONSTRAINT `fk_codigoHangar` FOREIGN KEY (`codigoHangar`) REFERENCES `hangares` (`codigoHangar`),
  ADD CONSTRAINT `fk_matriculaAvion` FOREIGN KEY (`matriculaAvion`) REFERENCES `aviones` (`matriculaAvion`);

--
-- Filtros para la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD CONSTRAINT `fk_metodoPago` FOREIGN KEY (`metodoPago`) REFERENCES `metodopago` (`metodoPago`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
