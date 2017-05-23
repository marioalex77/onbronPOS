DROP DATABASE IF EXISTS `DBDProject`;
CREATE DATABASE `DBDProject` /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `genero` varchar(1) NOT NULL,
  `estado` varchar(30) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  CHECK(`genero` IN ("M","F") AND `estado` IN ("ACTIVO","INACTIVO","BORRADO","BLOQUEADO"))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `rolusuario`;
CREATE TABLE `rolusuario` (
  `idRolUsuario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`idRolUsuario`),
  CHECK(`tipo` IN ("USUARIO","ADMIN","SUPER"))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `usuariorolusuario`;
CREATE TABLE `usuariorolusuario` (
  `idUsuario` int(11) unsigned NOT NULL,
  `idRolUsuario` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idUsuario`,`idRolUsuario`),
  KEY `FK_RolUsuario_idx` (`idRolUsuario`),
  CONSTRAINT `FK_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON UPDATE CASCADE,
  CONSTRAINT `FK_RolUsuario` FOREIGN KEY (`idRolUsuario`) REFERENCES `rolusuario` (`idRolUsuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Populate USER_PROFILE Table */
INSERT INTO rolusuario(tipo)
VALUES ('USUARIO');
INSERT INTO rolusuario(tipo)
VALUES ('ADMIN');
INSERT INTO rolusuario(tipo)
VALUES ('SUPER');
COMMIT;

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
`idCategoria` int(11) unsigned NOT NULL AUTO_INCREMENT,
`nombre` varchar(255) NOT NULL,
PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `persistentlogins`;
CREATE TABLE `persistentlogins` (
  `correo` varchar(255) NOT NULL,
  `series` VARCHAR(64) NOT NULL,
  `token` VARCHAR(64) NOT NULL,
  `ultimoIngreso` TIMESTAMP NOT NULL,
  PRIMARY KEY (series)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `nrc` varchar(15) DEFAULT NULL,
  `nit` varchar(17) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `nrc_UNIQUE` (`nrc`),
  UNIQUE KEY `nit_UNIQUE` (`nit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `impuesto`;
CREATE TABLE `impuesto` (
  `idImpuesto` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `porcentaje` decimal(25,6) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` varchar(30) NOT NULL,
  PRIMARY KEY (`idImpuesto`),
  CHECK(`estado` IN ("ACTIVO","INACTIVO","BORRADO","BLOQUEADO"))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `documento`;
CREATE TABLE `documento` (
  `idDocumento` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `tipo` varchar(100) NOT NULL,
  `documento` longblob NOT NULL,
  PRIMARY KEY (`idDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `idProducto` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `idCategoria` int(10) unsigned NOT NULL,
  `idImpuesto` int(10) unsigned NOT NULL,
  `idProveedor` int(11) unsigned NOT NULL,
  `precioUnitario` decimal(25,6) NOT NULL,
  `precioCompra` decimal(25,6) NOT NULL,
  `orden` int(11) NOT NULL,
  `descripcion` text,
  `estado` varchar(30) NOT NULL,
  `visible` varchar(1) NOT NULL,
  `idDocumento` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `idDocumento_UNIQUE` (`idDocumento`),
  KEY `FKProductoImpuesto_idx` (`idImpuesto`),
  KEY `FKProductoProveedor_idx` (`idProveedor`),
  KEY `FKProductoImagen_idx` (`idDocumento`),
  KEY `FKProductoCategoria_idx` (`idCategoria`),
  CONSTRAINT `FKProductoCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FKProductoDocuemnto` FOREIGN KEY (`idDocumento`) REFERENCES `documento` (`idDocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FKProductoImpuesto` FOREIGN KEY (`idImpuesto`) REFERENCES `impuesto` (`idImpuesto`) ON UPDATE CASCADE,
  CONSTRAINT `FKProductoProveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON UPDATE CASCADE,
  CHECK(`estado` IN ("ACTIVO","INACTIVO","BORRADO","BLOQUEADO"))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `genero` varchar(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tipopago`;
CREATE TABLE `tipopago` (
  `idTipoPago` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `estado` varchar(30) NOT NULL,
  PRIMARY KEY (`idTipoPago`),
  CHECK(`estado` IN ("ACTIVO","INACTIVO","BORRADO","BLOQUEADO"))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tipofactura`;
CREATE TABLE `tipofactura` (
  `idTipoFactura` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripción` varchar(255) NOT NULL,
  PRIMARY KEY (`idTipoFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `formato`;
CREATE TABLE `formato` (
  `idFormato` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `signoMoneda` varchar(50) DEFAULT NULL,
  `encabezado` varchar(50) DEFAULT NULL,
  `subtitulo` varchar(50) DEFAULT NULL,
  `encabezadoDetalle` varchar(50) DEFAULT NULL,
  `leyendaDetalle` text,
  `tipodePago` varchar(50) DEFAULT NULL,
  `nombreEmpresa` varchar(50) DEFAULT NULL,
  `nit` varchar(50) DEFAULT NULL,
  `lenguaje` varchar(50) DEFAULT NULL,
  `codigoMoneda` varchar(25) DEFAULT NULL,
  `posicionMoneda` varchar(25) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idFormato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `factura`;
CREATE TABLE `factura` (
  `idFactura` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) unsigned NOT NULL,
  `idTipoFactura` int(11) unsigned NOT NULL,
  `idFormato` int(11) unsigned NOT NULL,
  `fecha` datetime NOT NULL,
  `comentarios` text,
  `totalGrabado` decimal(25,6) NOT NULL,
  `totalExento` decimal(25,6) NOT NULL,
  `total` decimal(25,6) NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `FKCliente_idx` (`idCliente`),
  KEY `FKTipoFactura_idx` (`idTipoFactura`),
  KEY `FKFormato_idx` (`idFormato`),
  CONSTRAINT `FKCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON UPDATE CASCADE,
  CONSTRAINT `FKFormato` FOREIGN KEY (`idFormato`) REFERENCES `formato` (`idFormato`) ON UPDATE CASCADE,
  CONSTRAINT `FKTipoFactura` FOREIGN KEY (`idTipoFactura`) REFERENCES `tipofactura` (`idTipoFactura`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `facturaitem`;
CREATE TABLE `facturaitem` (
  `idFacturaItem` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idFactura` int(11) unsigned NOT NULL,
  `cantidad` int(10) NOT NULL,
  `idProducto` int(11) unsigned NOT NULL,
  `precioUnitario` decimal(25,6) NOT NULL,
  `idImpuesto` int(11) unsigned NOT NULL,
  `impuesto` decimal(25,6) NOT NULL,
  `subTotal` decimal(25,6) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`idFacturaItem`),
  KEY `FKFactura_idx` (`idFactura`),
  KEY `FKProducto_idx` (`idProducto`),
  KEY `FKImpuesto_idx` (`idImpuesto`),
  CONSTRAINT `FKFactura` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON UPDATE CASCADE,
  CONSTRAINT `FKImpuesto` FOREIGN KEY (`idImpuesto`) REFERENCES `impuesto` (`idImpuesto`) ON UPDATE CASCADE,
  CONSTRAINT `FKProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `inventario`;
CREATE TABLE `inventario` (
  `idInventario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) unsigned NOT NULL,
  `cantidad` int(11) unsigned NOT NULL,
  `costo` decimal(25,6) NOT NULL,
  `fechaProduccion` datetime NOT NULL,
  `fechaVencimiento` datetime NOT NULL,
  `comentario` text,
  PRIMARY KEY (`idInventario`),
  KEY `FKProductos_idx` (`idProducto`),
  CONSTRAINT `FKProductos` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `pago`;
CREATE TABLE `pago` (
  `idpago` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idFactura` int(11) unsigned NOT NULL,
  `idTipoPago` int(11) unsigned NOT NULL,
  `monto` decimal(25,6) NOT NULL,
  `fecha` datetime NOT NULL,
  `referenciaExterna` varchar(255) DEFAULT NULL,
  `comentario` text,
  PRIMARY KEY (`idpago`),
  KEY `FKPagoFactura_idx` (`idFactura`),
  KEY `FKPagoTipoPago_idx` (`idTipoPago`),
  CONSTRAINT `FKPagoFactura` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON UPDATE CASCADE,
  CONSTRAINT `FKPagoTipoPago` FOREIGN KEY (`idTipoPago`) REFERENCES `tipopago` (`idTipoPago`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
