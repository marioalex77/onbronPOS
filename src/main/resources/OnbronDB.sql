DROP DATABASE IF EXISTS `OnbronDB`;
CREATE DATABASE `OnbronDB` /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `genero` varchar(1) NOT NULL,
  `habilitado` varchar(1) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rolusuario`;
CREATE TABLE `rolusuario` (
`idRolUsuario` int(11) unsigned NOT NULL AUTO_INCREMENT,
`tipo` varchar(30) NOT NULL,
PRIMARY KEY (`idRolUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Populate USER_PROFILE Table */
INSERT INTO rolusuario(tipo)
VALUES ('USER');
INSERT INTO rolusuario(tipo)
VALUES ('ADMIN');
INSERT INTO rolusuario(tipo)
VALUES ('SUPER');
COMMIT;

DROP TABLE IF EXISTS `usuariorolusuario`;
CREATE TABLE `usuariorolusuario` (
  `idUsuario` int(11) unsigned NOT NULL,
  `idRolUsuario` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idUsuario`,`idRolUsuario`),
  KEY `FK_RolUsuario_idx` (`idRolUsuario`),
  CONSTRAINT `FK_RolUsuario` FOREIGN KEY (`idRolUsuario`) REFERENCES `rolusuario` (`idRolUsuario`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
`idCategoria` int(11) unsigned NOT NULL AUTO_INCREMENT,
`nombre` varchar(255) NOT NULL,
PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
