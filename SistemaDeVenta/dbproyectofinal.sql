-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2015 a las 20:02:39
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dbproyectofinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblarticulos`
--

CREATE TABLE IF NOT EXISTS `tblarticulos` (
  `codigoProducto` bigint(13) NOT NULL,
  `nombreArticulo` varchar(60) NOT NULL,
  `idCategoriaProducto` int(2) NOT NULL,
  `idMarcaProducto` int(2) NOT NULL,
  `idUnidadmedida` int(2) NOT NULL,
  `costo` double NOT NULL,
  `efectivo` double NOT NULL,
  `stockMaximo` int(11) NOT NULL,
  `stockMinimo` int(11) NOT NULL,
  `existencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblarticulos`
--

INSERT INTO `tblarticulos` (`codigoProducto`, `nombreArticulo`, `idCategoriaProducto`, `idMarcaProducto`, `idUnidadmedida`, `costo`, `efectivo`, `stockMaximo`, `stockMinimo`, `existencia`) VALUES
(1288846277, 'Salami Super Especial', 1, 2, 1, 150, 200, 10, 50, 0),
(1535281240, 'Mantequilla', 1, 3, 2, 40, 50, 5, 20, 0),
(1703571099, 'Panger ', 2, 1, 4, 200, 250, 40, 4, 0),
(1983496228, 'Arroz', 5, 5, 1, 20, 25, 20, 30, 0),
(1467248401, 'Nuesmocada', 7, 4, 2, 10, 20, 5, 50, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcategoriaproducto`
--

CREATE TABLE IF NOT EXISTS `tblcategoriaproducto` (
`idCategoriaProducto` int(11) NOT NULL,
  `Descripcion` varchar(60) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `tblcategoriaproducto`
--

INSERT INTO `tblcategoriaproducto` (`idCategoriaProducto`, `Descripcion`) VALUES
(1, 'Embutido'),
(2, 'Pamper'),
(4, 'Detergente'),
(5, 'Comida'),
(6, 'Refrigerio'),
(7, 'Otros'),
(9, 'Frutas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblciudades`
--

CREATE TABLE IF NOT EXISTS `tblciudades` (
`idCiudad` int(11) NOT NULL,
  `descripcion` varchar(60) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `tblciudades`
--

INSERT INTO `tblciudades` (`idCiudad`, `descripcion`) VALUES
(1, 'San Francisco De Macoris'),
(2, 'La Vega '),
(3, 'San Juan'),
(4, 'San Pedro '),
(5, 'Santiago'),
(6, 'Nagua');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblclientes`
--

CREATE TABLE IF NOT EXISTS `tblclientes` (
  `codigoCliente` int(10) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `fechaNacimiento` varchar(20) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `estadoCivil` varchar(10) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `idCiudad` int(2) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `email` varchar(40) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `ocupacion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblclientes`
--

INSERT INTO `tblclientes` (`codigoCliente`, `nombres`, `apellidos`, `fechaNacimiento`, `sexo`, `estadoCivil`, `cedula`, `idCiudad`, `direccion`, `email`, `celular`, `ocupacion`) VALUES
(298583837, '', 'De La Cruz Medina', '13/05/1990', 'Masculino', 'Soltero', '402-2001396-1', 1, 'Sabana Rey, El Ranchito # 34', 'pdelacruzmedina@gmail.com', '(809)-961-8021', 'Ing. En Sistema y Computacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblmarcaproducto`
--

CREATE TABLE IF NOT EXISTS `tblmarcaproducto` (
`idMarcaProducto` int(11) NOT NULL,
  `Descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `tblmarcaproducto`
--

INSERT INTO `tblmarcaproducto` (`idMarcaProducto`, `Descripcion`) VALUES
(1, 'Nestle'),
(2, 'Induveca'),
(3, 'Mayita'),
(4, 'Nido'),
(5, 'Yocaju');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproveedor`
--

CREATE TABLE IF NOT EXISTS `tblproveedor` (
  `codigoProveedor` int(10) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `fechaNacimiento` varchar(20) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `estadoCivil` varchar(10) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `idCiudad` int(2) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `email` varchar(40) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `ocupacion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblproveedor`
--

INSERT INTO `tblproveedor` (`codigoProveedor`, `nombres`, `apellidos`, `fechaNacimiento`, `sexo`, `estadoCivil`, `cedula`, `idCiudad`, `direccion`, `email`, `celular`, `ocupacion`) VALUES
(52841839, 'Juan Santos', 'Beato', '09/03/1990', 'Masculino', 'Casado', '403-0304838-4', 3, 'No Me Acuerdo', 'juan@gmail.com', '(444)-444-4444', 'Estudiante'),
(93517268, 'Vlady', 'Taveras', '19/01/1990', 'Femenino', 'Soltero', '304-0493949-5', 1, 'Calle Princiapl', 'vlady@gmail.com', '(444)-444-4444', 'Ing Sistema'),
(86102588, 'Johan', 'Ostaire', '02/04/1980', 'Masculino', 'Soltero', '484-8494939-4', 5, 'La Baraja', 'honana2@gmail.com', '(444)-444-4444', 'Ebanista'),
(52662942, 'Yadira', 'Mejia', '03/04/1990', 'Femenino', 'Casado', '222-2222222-2', 2, 'el sabe', 'yadira@gmail.com', '(444)-444-4444', 'Ing Civil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipousuario`
--

CREATE TABLE IF NOT EXISTS `tbltipousuario` (
`idTipoUsuario` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tbltipousuario`
--

INSERT INTO `tbltipousuario` (`idTipoUsuario`, `descripcion`) VALUES
(1, 'Administador'),
(2, 'Caja'),
(3, 'Digitador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblunidadmedida`
--

CREATE TABLE IF NOT EXISTS `tblunidadmedida` (
`idUnidadMedida` int(11) NOT NULL,
  `Descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `tblunidadmedida`
--

INSERT INTO `tblunidadmedida` (`idUnidadMedida`, `Descripcion`) VALUES
(1, 'Libra'),
(2, 'Onza'),
(3, 'Galon'),
(4, 'Caja'),
(5, 'Paquete'),
(6, 'Otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuario`
--

CREATE TABLE IF NOT EXISTS `tblusuario` (
  `nombreUsuario` varchar(30) NOT NULL,
  `contrasena` varchar(30) NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fechaNacimiento` varchar(12) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `pConfiguracion` tinyint(1) NOT NULL,
  `pBackup` tinyint(1) NOT NULL,
  `pNUsuario` tinyint(1) NOT NULL,
  `pCUsuario` tinyint(1) NOT NULL,
  `pSalirSistema` tinyint(1) NOT NULL,
  `pRVenta` tinyint(1) NOT NULL,
  `pCVenta` tinyint(1) NOT NULL,
  `pRCompra` tinyint(1) NOT NULL,
  `pCCompra` tinyint(1) NOT NULL,
  `pNArticulo` tinyint(1) NOT NULL,
  `pCArticulo` tinyint(1) NOT NULL,
  `pNCliente` tinyint(1) NOT NULL,
  `pCCliente` tinyint(1) NOT NULL,
  `pNProveedores` tinyint(1) NOT NULL,
  `pCProveedores` tinyint(1) NOT NULL,
  `pTablasAxu` tinyint(1) NOT NULL,
  `pReporteVenta` tinyint(1) NOT NULL,
  `pReporteCompras` tinyint(1) NOT NULL,
  `pRArticulo` tinyint(1) NOT NULL,
  `pRCliente` tinyint(1) NOT NULL,
  `pRProveedores` tinyint(1) NOT NULL,
  `pCajaDiaria` tinyint(1) NOT NULL,
  `pInformeVentaD` tinyint(1) NOT NULL,
  `pBusquedaFactura` tinyint(1) NOT NULL,
  `pListaArti` tinyint(1) NOT NULL,
  `pManualUsu` tinyint(1) NOT NULL,
  `pAcercaApli` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblusuario`
--

INSERT INTO `tblusuario` (`nombreUsuario`, `contrasena`, `tipoUsuario`, `nombre`, `apellidos`, `fechaNacimiento`, `telefono`, `email`, `pConfiguracion`, `pBackup`, `pNUsuario`, `pCUsuario`, `pSalirSistema`, `pRVenta`, `pCVenta`, `pRCompra`, `pCCompra`, `pNArticulo`, `pCArticulo`, `pNCliente`, `pCCliente`, `pNProveedores`, `pCProveedores`, `pTablasAxu`, `pReporteVenta`, `pReporteCompras`, `pRArticulo`, `pRCliente`, `pRProveedores`, `pCajaDiaria`, `pInformeVentaD`, `pBusquedaFactura`, `pListaArti`, `pManualUsu`, `pAcercaApli`) VALUES
('pabloalfredo', 'alfredo1234', 1, 'Pablo Alfredo', 'De La Cruz Medina', '13/051990', '(809)-961-8021', 'pdelacruzmedina@gmail.com', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('manuel08', 'manuel1234', 3, 'Juan Manuel', 'Monegro Medina', '12/12/1989', '(444)-444-4444', 'juanmanuel@gmail.com', 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1),
('maria45', 'maria1234', 2, 'Maria Yinet', 'Perdomo', '__/__/____', '(___)-___-____', '', 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblcategoriaproducto`
--
ALTER TABLE `tblcategoriaproducto`
 ADD PRIMARY KEY (`idCategoriaProducto`);

--
-- Indices de la tabla `tblciudades`
--
ALTER TABLE `tblciudades`
 ADD PRIMARY KEY (`idCiudad`);

--
-- Indices de la tabla `tblmarcaproducto`
--
ALTER TABLE `tblmarcaproducto`
 ADD PRIMARY KEY (`idMarcaProducto`);

--
-- Indices de la tabla `tbltipousuario`
--
ALTER TABLE `tbltipousuario`
 ADD PRIMARY KEY (`idTipoUsuario`);

--
-- Indices de la tabla `tblunidadmedida`
--
ALTER TABLE `tblunidadmedida`
 ADD PRIMARY KEY (`idUnidadMedida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblcategoriaproducto`
--
ALTER TABLE `tblcategoriaproducto`
MODIFY `idCategoriaProducto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `tblciudades`
--
ALTER TABLE `tblciudades`
MODIFY `idCiudad` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `tblmarcaproducto`
--
ALTER TABLE `tblmarcaproducto`
MODIFY `idMarcaProducto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `tbltipousuario`
--
ALTER TABLE `tbltipousuario`
MODIFY `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tblunidadmedida`
--
ALTER TABLE `tblunidadmedida`
MODIFY `idUnidadMedida` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
