-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 15-09-2023 a las 21:44:45
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pedidos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestion_ofertas`
--

DROP TABLE IF EXISTS `gestion_ofertas`;
CREATE TABLE IF NOT EXISTS `gestion_ofertas` (
  `codigo_oferta` varchar(30) NOT NULL,
  `codigo_pedido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `precio_normal` varchar(30) NOT NULL,
  `precio_oferta` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo_oferta`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `gestion_ofertas`
--

INSERT INTO `gestion_ofertas` (`codigo_oferta`, `codigo_pedido`, `nombre`, `descripcion`, `precio_normal`, `precio_oferta`) VALUES
('765676', '12345', 'Reloj apple watch', 'Inoxidable, en plastico, deporte al maximo', '1800000', '1000000'),
('09876', '567865', 'iPhone 14', '6 de ram, 128 gb, 12 megapixeles', '4500000', '3500000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestion_pedidos`
--

DROP TABLE IF EXISTS `gestion_pedidos`;
CREATE TABLE IF NOT EXISTS `gestion_pedidos` (
  `codigo` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `nombre_producto` varchar(30) NOT NULL,
  `documento` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `gestion_pedidos`
--

INSERT INTO `gestion_pedidos` (`codigo`, `nombre`, `nombre_producto`, `documento`, `estado`) VALUES
('12345', 'Johan alexis', 'Ventilador', '6758886588', 'en reparto'),
('09876', 'maicol', 'silla gamer', '1008780890', 'preparando'),
('879844', 'adriana', 'apple watch', '40878908', 'enviado');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
