-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 28-02-2023 a las 05:53:11
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectoconst`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarPropietario` (IN `pid_propietario` INT, IN `pnombre` VARCHAR(30), IN `pdireccion` VARCHAR(50), IN `ptelefono` VARCHAR(15), IN `pcorreo` VARCHAR(50))   BEGIN
UPDATE propietario
SET nombre = pnombre, direccion = pdireccion, telefono = ptelefono, correo = pcorreo
WHERE id_propietario = pid_propietario;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_busquedaFiltrada` (IN `pid_propietario` INT, IN `pplaca` VARCHAR(10), IN `pmarca` VARCHAR(15))   BEGIN
	IF pplaca != 'null' THEN
    	SELECT * FROM vehiculo as v WHERE v.placa = pplaca;
    ELSEIF pmarca != 'null' THEN
    	SELECT * FROM vehiculo as v WHERE v.marca = pmarca AND v.id_propietario = pid_propietario;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crearCuentaPropietario` (IN `pcedula` VARCHAR(12), IN `pclave` VARCHAR(80), IN `pestado` BOOLEAN)   BEGIN
INSERT INTO cuenta_propietario(cedula, clave, estado) VALUES(pcedula, pclave, pestado);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crearPropietario` (IN `p_cpid` INT, IN `pnombre` VARCHAR(20), IN `pcedula` VARCHAR(12), IN `plicencia` VARCHAR(12), IN `pcorreo` VARCHAR(35), IN `pdireccion` VARCHAR(35), IN `pfecha_nac` DATE, IN `ptelefono` VARCHAR(12), IN `pestado` BOOLEAN)   BEGIN
	INSERT INTO propietario(id_cuenta_prop, nombre, cedula, licencia, correo, direccion, fecha_nac, telefono, estado) VALUES(p_cpid, pnombre, pcedula, plicencia, pcorreo, pdireccion, pfecha_nac, ptelefono, pestado);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crearVehiculo` (IN `pid_propietario` INT, IN `pmarca` VARCHAR(15), IN `pmodelo` VARCHAR(15), IN `panio` VARCHAR(10), IN `pplaca` VARCHAR(10), IN `pestado` BOOLEAN, IN `pcolor` VARCHAR(10))   BEGIN
INSERT INTO vehiculo(id_propietario, marca, modelo, anio, placa, estado, color) VALUES(pid_propietario, pmarca, pmodelo, panio, pplaca, pestado, pcolor);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminarVehiculo` (IN `placa` VARCHAR(10))   BEGIN
	UPDATE vehiculo AS v SET v.estado = false WHERE v.placa = placa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_modificarVehiculo` (IN `pcolor` VARCHAR(12), IN `pplaca` VARCHAR(10))   BEGIN
	UPDATE vehiculo SET color = pcolor WHERE placa = pplaca;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtenerPagos` (IN `pid_propietario` INT)   BEGIN
SELECT * FROM registro_pago WHERE id_propietario = pid_propietario;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registroPago` (IN `pid_propietario` INT, IN `pcantidad_vehiculo` INT, IN `pimpuesto_unitario` DOUBLE, IN `pimpuesto_emision_gas` DOUBLE, IN `pestado` BOOLEAN, IN `pfecha_registro` DATE, IN `ppago_total` DOUBLE)   BEGIN
INSERT INTO registro_pago(id_propietario, cantidad_vehiculo, impuesto_unitario, impuesto_emision_gas, estado, fecha_registro, pago_total) VALUES(pid_propietario, pcantidad_vehiculo, pimpuesto_unitario, pimpuesto_emision_gas, pestado, pfecha_registro, ppago_total);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornaClave` (IN `cedula` VARCHAR(12))   BEGIN
	SELECT clave FROM cuenta_propietario as cu_prop WHERE cu_prop.cedula = cedula;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornaCuentaPropietario` (IN `cedula` VARCHAR(12))   BEGIN
	SELECT * FROM cuenta_propietario as c_prop WHERE c_prop.cedula = cedula;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornaPropietario` (IN `cedula` VARCHAR(12))   BEGIN
	SELECT * FROM propietario as prop WHERE prop.cedula = cedula;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retornaVehiculo` (IN `id_propietario` INT)   BEGIN
	SELECT * FROM vehiculo as v WHERE v.id_propietario = id_propietario;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_propietario`
--

CREATE TABLE `cuenta_propietario` (
  `id_cpropietario` int(11) NOT NULL,
  `cedula` varchar(12) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `clave` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuenta_propietario`
--

INSERT INTO `cuenta_propietario` (`id_cpropietario`, `cedula`, `estado`, `descripcion`, `clave`) VALUES
(1, '0943536813', 1, NULL, '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),
(2, '0123456789', 1, NULL, 'cfec06f95862b3003cda004b1755268e39095965c25638ff9bf67a0ce74535b5'),
(3, '1', 1, NULL, '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietario`
--

CREATE TABLE `propietario` (
  `id_propietario` int(11) NOT NULL,
  `id_cuenta_prop` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `correo` varchar(35) NOT NULL,
  `licencia` varchar(15) NOT NULL,
  `cedula` varchar(12) NOT NULL,
  `fecha_nac` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `propietario`
--

INSERT INTO `propietario` (`id_propietario`, `id_cuenta_prop`, `nombre`, `direccion`, `telefono`, `correo`, `licencia`, `cedula`, `fecha_nac`, `estado`) VALUES
(1, 1, 'Jose Franco', '20 y Capitan Najera', '4252524', 'jose2001franco@gmail.com', '01249381391', '0943536813', '2001-12-05', 1),
(2, 2, 'Jhonny Arias', 'Flor de bastion', '093746182712', 'jhonnya@hotmail.com', '3918271829', '0123456789', '2000-01-12', 1),
(3, 3, '2', 'prueba2', 'prueba2', 'prueba2', 'prueba', '1', '2023-01-01', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_pago`
--

CREATE TABLE `registro_pago` (
  `id_pago` int(11) NOT NULL,
  `cantidad_vehiculo` int(11) NOT NULL,
  `impuesto_unitario` double NOT NULL,
  `impuesto_emision_gas` double NOT NULL,
  `pago_total` double NOT NULL,
  `fecha_registro` date NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `id_propietario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registro_pago`
--

INSERT INTO `registro_pago` (`id_pago`, `cantidad_vehiculo`, `impuesto_unitario`, `impuesto_emision_gas`, `pago_total`, `fecha_registro`, `estado`, `id_propietario`) VALUES
(1, 4, 30, 20, 200, '2023-02-26', 1, 1),
(2, 4, 30, 20, 200, '2023-02-26', 1, 1),
(4, 5, 30, 20, 250, '2023-02-27', 1, 1),
(5, 5, 12, 5, 2550, '2023-02-27', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `id_vehiculo` int(11) NOT NULL,
  `id_propietario` int(11) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `anio` varchar(10) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `color` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id_vehiculo`, `id_propietario`, `marca`, `modelo`, `anio`, `placa`, `estado`, `color`) VALUES
(1, 1, 'BMW', 'Serie 1', '2022', 'GSD-3133', 1, 'Blanco'),
(2, 1, 'Alfa Romeo', 'Giulia', '2020', 'GTA-5422', 1, 'Negro'),
(3, 2, 'PRUEBA', 'PRUEBA', '2010', 'GRTX-360', 1, 'Negro'),
(4, 1, 'BMW', 'Serie 2', '2021', 'GAA-2111', 1, 'Beige'),
(7, 1, 'Toyota', 'Corolla', '2023', 'GAA-3112', 1, 'Marron'),
(8, 1, 'Kia', 'Optima', '2019', 'GUU-2022', 1, 'Beige');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuenta_propietario`
--
ALTER TABLE `cuenta_propietario`
  ADD PRIMARY KEY (`id_cpropietario`);

--
-- Indices de la tabla `propietario`
--
ALTER TABLE `propietario`
  ADD PRIMARY KEY (`id_propietario`),
  ADD KEY `id_cuenta_prop` (`id_cuenta_prop`);

--
-- Indices de la tabla `registro_pago`
--
ALTER TABLE `registro_pago`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `fk_id_propietario` (`id_propietario`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`id_vehiculo`),
  ADD KEY `id_propietario` (`id_propietario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuenta_propietario`
--
ALTER TABLE `cuenta_propietario`
  MODIFY `id_cpropietario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `propietario`
--
ALTER TABLE `propietario`
  MODIFY `id_propietario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `registro_pago`
--
ALTER TABLE `registro_pago`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `propietario`
--
ALTER TABLE `propietario`
  ADD CONSTRAINT `propietario_ibfk_1` FOREIGN KEY (`id_cuenta_prop`) REFERENCES `cuenta_propietario` (`id_cpropietario`);

--
-- Filtros para la tabla `registro_pago`
--
ALTER TABLE `registro_pago`
  ADD CONSTRAINT `fk_id_propietario` FOREIGN KEY (`id_propietario`) REFERENCES `propietario` (`id_propietario`);

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`id_propietario`) REFERENCES `propietario` (`id_propietario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
