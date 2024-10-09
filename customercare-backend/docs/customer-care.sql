DROP DATABASE IF EXISTS customercareDB;

CREATE DATABASE customercareDB;

USE customercareDB;

CREATE TABLE `adjunto_seq` (
  `next_val` bigint DEFAULT NULL
);
INSERT INTO `customercareDB`.`adjunto_seq` VALUES (1);

CREATE TABLE `empresa_seq` (
  `next_val` bigint DEFAULT NULL
);
INSERT INTO `customercareDB`.`empresa_seq` VALUES (1);

CREATE TABLE `reclamo_estado_maestro_seq` (
  `next_val` bigint DEFAULT NULL
);
INSERT INTO `customercareDB`.`reclamo_estado_maestro_seq` VALUES (1);

CREATE TABLE `reclamo_estado_seq` (
  `next_val` bigint DEFAULT NULL
);
INSERT INTO `customercareDB`.`reclamo_estado_seq` VALUES (1);

CREATE TABLE `reclamo_motivo_seq` (
  `next_val` bigint DEFAULT NULL
);
INSERT INTO `customercareDB`.`reclamo_motivo_seq` VALUES (1);

CREATE TABLE `reclamo_seq` (
  `next_val` bigint DEFAULT NULL
);
INSERT INTO `customercareDB`.`reclamo_seq` VALUES (1);

CREATE TABLE `reclamo_estado_maestro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre_estado` enum('ANULADA','CERRADA','EN_REVISION','PENDIENTE') NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `customercareDB`.`reclamo_estado_maestro`
(`id`,`descripcion`,`nombre_estado`) VALUES
(1,
'Pendiente',
'PENDIENTE');

INSERT INTO `customercareDB`.`reclamo_estado_maestro`
(`id`,`descripcion`,`nombre_estado`) VALUES
(2,
'En revisión',
'EN_REVISION');

INSERT INTO `customercareDB`.`reclamo_estado_maestro`
(`id`,`descripcion`,`nombre_estado`) VALUES
(3,
'Cerrada',
'CERRADA');

INSERT INTO `customercareDB`.`reclamo_estado_maestro`
(`id`,`descripcion`,`nombre_estado`) VALUES
(4,
'Anulada',
'ANULADA');

CREATE TABLE `reclamo_motivo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `nombre` enum('FECHA_ENTREGA_INCUMPLIDA','PROBLEMAS_CON_PERSONAL','PRODUCTO_CON_DEFECTOS') NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `customercareDB`.`reclamo_motivo`
(`id`,`descripcion`,`nombre`) VALUES
(1,
'Fecha de Entrega Incumplida',
'FECHA_ENTREGA_INCUMPLIDA');

INSERT INTO `customercareDB`.`reclamo_motivo`
(`id`,`descripcion`,`nombre`) VALUES
(2,
'Problemas con Personal)',
'PROBLEMAS_CON_PERSONAL');

INSERT INTO `customercareDB`.`reclamo_motivo`
(`id`,`descripcion`,`nombre`) VALUES
(3,
'Producto con Defectos',
'PRODUCTO_CON_DEFECTOS');

CREATE TABLE `empresa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion_empresa` varchar(255) NOT NULL,
  `nombre_empresa` enum('Oeschle','Promart','Vivanda','plazaVea') NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `customercareDB`.`empresa`
(`id`,`descripcion_empresa`,`nombre_empresa`) VALUES
(1,
'Oeschle',
'Oeschle');

INSERT INTO `customercareDB`.`empresa`
(`id`,`descripcion_empresa`,`nombre_empresa`) VALUES
(2,
'Promart',
'Promart');

INSERT INTO `customercareDB`.`empresa`
(`id`,`descripcion_empresa`,`nombre_empresa`) VALUES
(3,
'Vivanda',
'Vivanda');

INSERT INTO `customercareDB`.`empresa`
(`id`,`descripcion_empresa`,`nombre_empresa`) VALUES
(4,
'plazaVea',
'plazaVea');

CREATE TABLE `reclamo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `correo_cliente` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `empresa_id` int DEFAULT NULL,
  `reclamo_motivo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`reclamo_motivo_id`) REFERENCES `reclamo_motivo` (`id`),
  FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`)
);

CREATE TABLE `adjunto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_adjunto` varchar(255) NOT NULL,
  `reclamo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`reclamo_id`),
  FOREIGN KEY (`reclamo_id`) REFERENCES `reclamo` (`id`)
);

CREATE TABLE `reclamo_estado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comentario_asesor` varchar(150) NOT NULL,
  `correo_asesor` varchar(50) NOT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `reclamo_estado_maestro_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`reclamo_estado_maestro_id`) REFERENCES `reclamo_estado_maestro` (`id`)
);
