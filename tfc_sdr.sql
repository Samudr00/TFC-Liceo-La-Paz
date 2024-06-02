-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2024 a las 12:40:07
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tfc.sdr`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `numeroParticipantes` int(11) DEFAULT NULL,
  `ubicacion` varchar(200) DEFAULT NULL,
  `verificacion` enum('Verificado','NoVerificado','','') NOT NULL,
  `contador` int(11) NOT NULL,
  `hora` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id`, `nombre`, `descripcion`, `fecha`, `numeroParticipantes`, `ubicacion`, `verificacion`, `contador`, `hora`) VALUES
(17, 'Pokemon Go', 'Quedada para jugar al pokemon go', '2024-06-01', 20, 'Perillo, Oleiros, Polideportivo', 'Verificado', 0, '16:00'),
(18, 'Padel', 'Queremos organizar un pequeño torneo de pádel', '2024-06-09', 8, 'Bastiagueiro, Oleiros, pista de padel de bastiagueiro', 'Verificado', 0, '14:00'),
(19, 'League of Legends', 'Necesitamos gente para jugar unas flex', '2024-06-02', 2, 'Loby de partida: 4532C contraseña: 12345', 'NoVerificado', 0, '20:00'),
(20, 'Pachanga', 'Buscamos gente que se anime a echar unas pachangas', '2024-06-09', 10, 'Campo del Dorneda, Oleiros', 'NoVerificado', 0, '16:00'),
(21, 'Pokemon', 'Me gustaria echar unos combates contra alguien', '2024-06-11', 5, 'Parque de los patos, Santa Cruz', 'NoVerificado', 0, '18:00'),
(22, 'Picnic por la Igualdad', 'Estais todos invitados a nuestro picnic anual por la Igualdad', '2024-06-30', 100, 'Parque Las Galeras, Bastiagueiro', 'Verificado', 0, '14:00'),
(23, 'Paseo con perros', 'Paseo por la playa con perros', '2024-06-29', 3, 'Playa de Mera, Oleiros', 'NoVerificado', 0, '16:00'),
(24, 'Coches antiguos', 'Quedada de coches vintage', '2024-07-04', 100, 'Maria Pita, A Coruña', 'Verificado', 0, '12:00'),
(25, 'Torneo de Yu-Gi-Oh', 'Necesitamos integrantes para un torneo de Yu-Gi-Oh', '2024-08-02', 20, 'Centro de ocio Porta Aberta, Santa Cruz, Oleiros', 'Verificado', 0, '19:00'),
(26, 'Coches Deportivos', 'Quedada de coches deportivos', '2024-07-06', 100, 'Palacio de la Opera, A Coruña', 'NoVerificado', 0, '20:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE `perfiles` (
  `id` int(11) NOT NULL,
  `perfil` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`id`, `perfil`) VALUES
(1, 'USUARIO'),
(2, 'SUPERVISOR'),
(3, 'ADMINISTRADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarioperfil`
--

CREATE TABLE `usuarioperfil` (
  `idUsuario` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarioperfil`
--

INSERT INTO `usuarioperfil` (`idUsuario`, `idPerfil`) VALUES
(1, 3),
(2, 3),
(11, 1),
(13, 2),
(13, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `estatus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `email`, `username`, `password`, `estatus`) VALUES
(1, 'samuel', 'samueldapena@gmail.com', 'samuel', 'samuel', 1),
(2, 'Rico', 'rico@gmail.com', 'rico', 'rico', 1),
(11, 'a', 'a@gmail.com', 'a', 'a', 1),
(13, 'prueba', 'prueba@gmail.com', 'prueba', 'prueba', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viajes`
--

CREATE TABLE `viajes` (
  `id` int(11) NOT NULL,
  `destino` varchar(200) NOT NULL,
  `salida` varchar(200) NOT NULL,
  `transporte` enum('Avion','Tren','Autobus','Coche') NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `presupuesto` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `horaSalida` varchar(10) NOT NULL,
  `horaRegreso` varchar(10) NOT NULL,
  `transporteRegreso` enum('Avion','Autobus','Coche','Tren') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `viajes`
--

INSERT INTO `viajes` (`id`, `destino`, `salida`, `transporte`, `fechaInicio`, `fechaFin`, `presupuesto`, `descripcion`, `horaSalida`, `horaRegreso`, `transporteRegreso`) VALUES
(2, 'Zimbabue', 'Santiago', 'Coche', '2024-05-02', '2024-05-16', 900, 'Viajecito con tato que no sabe escribir zimbajue', '18:07', '21:07', 'Avion'),
(6, 'Bolivia', 'España', 'Avion', '2024-05-24', '2024-05-24', 600, 'Viaje con la parienta', '19:06', '19:05', 'Avion'),
(7, 'Mayorca', 'Alvedro, A Coruña', 'Avion', '2024-08-02', '2024-08-06', 750, 'Visita turística a las playas de Mayorca', '10:30', '15:00', 'Avion'),
(8, 'Orense', 'A Coruña', 'Coche', '2024-07-18', '2024-07-20', 60, 'Ruta por las termas de Orense', '16:00', '16:00', 'Coche'),
(9, 'Vigo', 'Orense', 'Tren', '2024-07-27', '2024-07-30', 40, 'Viaje para ir a ver el Marisquiño', '12:00', '12:00', 'Tren'),
(10, 'Monte Carlo', 'Santiago', 'Avion', '2024-08-23', '2024-08-27', 2300, 'Participación en el High Roller', '09:00', '06:30', 'Avion');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarioperfil`
--
ALTER TABLE `usuarioperfil`
  ADD KEY `usuarioperfiltoperfil` (`idPerfil`),
  ADD KEY `usuarioperfiltousuario` (`idUsuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `viajes`
--
ALTER TABLE `viajes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `viajes`
--
ALTER TABLE `viajes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarioperfil`
--
ALTER TABLE `usuarioperfil`
  ADD CONSTRAINT `usuarioperfiltoperfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfiles` (`id`),
  ADD CONSTRAINT `usuarioperfiltousuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
