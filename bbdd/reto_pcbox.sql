DROP TABLE IF EXISTS lineapedido;
DROP TABLE IF EXISTS factura;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS reparacion;
DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    DNI VARCHAR(9) NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Apellido VARCHAR(30) NOT NULL,
    Direccion VARCHAR(50) NOT NULL,
    CodigoPostal INT NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Telefono INT NOT NULL
);

CREATE TABLE reparacion (
    ID INT NOT NULL,
    Tipo VARCHAR(20) NOT NULL,
    Descripcion VARCHAR(90) NOT NULL,
    Horas INT NOT NULL,
    Precio DECIMAL(5,2) NOT NULL,
    DNI_CLIENTE VARCHAR(9) NOT NULL
);

CREATE TABLE pedido (
    ID INT NOT NULL,
    Fecha DATE NOT NULL,
    DNI_Cliente VARCHAR(9) NOT NULL
);

CREATE TABLE producto (
    ID INT NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Tipo VARCHAR(50) NOT NULL,
    Marca VARCHAR(15) NOT NULL,
    Precio DECIMAL(6,2) NOT NULL,
    Stock INT NOT NULL
);

CREATE TABLE lineapedido (
    ID_Pedido INT NOT NULL,
    ID_Producto INT NOT NULL,
    Cantidad INT NOT NULL
);

CREATE TABLE factura (
    ID INT NOT NULL,
    Fecha DATE NOT NULL,
    Total DECIMAL(5,2) NOT NULL,
    Pagado CHAR(2) NOT NULL,
    Tipo_Factura VARCHAR(20) NOT NULL
);

-- Primary Keys
ALTER TABLE cliente ADD PRIMARY KEY (DNI);
ALTER TABLE reparacion ADD PRIMARY KEY (ID);
ALTER TABLE pedido ADD PRIMARY KEY (ID);
ALTER TABLE producto ADD PRIMARY KEY (ID);
ALTER TABLE lineapedido ADD PRIMARY KEY (ID_Pedido, ID_Producto);
ALTER TABLE factura ADD PRIMARY KEY (ID, Tipo_Factura);

-- Auto-increments
ALTER TABLE producto MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE pedido MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE reparacion MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE factura MODIFY ID INT AUTO_INCREMENT;

-- Foreign Keys
ALTER TABLE reparacion ADD CONSTRAINT FK_Reparacion FOREIGN KEY (DNI_CLIENTE)
    REFERENCES cliente(DNI) ON DELETE CASCADE;
ALTER TABLE pedido ADD CONSTRAINT FK_Pedido FOREIGN KEY (DNI_Cliente)
    REFERENCES cliente(DNI) ON DELETE CASCADE;
ALTER TABLE lineapedido ADD CONSTRAINT FK_LineaPedido FOREIGN KEY (ID_Pedido)
    REFERENCES pedido(ID) ON DELETE CASCADE;
ALTER TABLE lineapedido ADD CONSTRAINT FK_LineaPedido1 FOREIGN KEY (ID_Producto)
    REFERENCES producto(ID) ON DELETE CASCADE;
ALTER TABLE factura ADD CONSTRAINT FK_Factura FOREIGN KEY (ID)
    REFERENCES pedido(ID) ON DELETE CASCADE;

-- Checks
ALTER TABLE factura ADD CHECK (Pagado IN ('Si', 'No'));
ALTER TABLE factura ADD CHECK (Tipo_Factura IN ('Pedido', 'Reparacion'));

-- Procedures
DELIMITER //

DROP PROCEDURE IF EXISTS Insertar_Pedido //
DROP PROCEDURE IF EXISTS Insertar_Reparacion //
DROP PROCEDURE IF EXISTS Eliminar_Pedido //
DROP PROCEDURE IF EXISTS Eliminar_Reparacion //

CREATE PROCEDURE Insertar_Pedido (
    p_ID_Pedido INT,
    p_Fecha DATE,
    f_Total DECIMAL(5,2),
    p_DNI_Cliente VARCHAR(9)
)
BEGIN
    -- Insertar el pedido
    INSERT INTO pedido(ID, Fecha, DNI_Cliente)
    VALUES (p_ID_Pedido, p_Fecha, p_DNI_Cliente);
    
    -- Insertar la factura
    INSERT INTO factura(ID, Fecha, Total, Pagado, Tipo_Factura)
    VALUES (p_ID_Pedido, p_Fecha, f_Total, 'No', 'Pedido');

    COMMIT;
    -- SELECT CONCAT('Factura creada correctamente para el pedido ', p_ID_Pedido, ' de tipo pedido.') AS Message;
END//

CREATE PROCEDURE Insertar_Reparacion (
    r_ID_Reparacion INT,
    r_Tipo VARCHAR(20),
    r_Descripcion VARCHAR(90),
    r_Horas INT,
    r_Precio DECIMAL(5,2),
    f_total DECIMAL(5,2),
    f_Fecha DATE,
    r_DNI_Cliente VARCHAR(9)
)
BEGIN
    -- Insertar la reparacion
    INSERT INTO reparacion(ID, Tipo, Descripcion, Horas, Precio, DNI_Cliente)
    VALUES (r_ID_Reparacion, r_Tipo, r_Descripcion, r_Horas, r_Precio, r_DNI_Cliente);
    
    -- Insertar la factura
    INSERT INTO factura(ID, Fecha, Total, Pagado, Tipo_Factura)
    VALUES (r_ID_Reparacion, f_Fecha, f_Total, 'No', 'Reparacion');

    COMMIT;
    SELECT CONCAT('Factura creada correctamente para la reparacion ', r_ID_Reparacion, ' de tipo reparacion.') AS Message;
END//

CREATE PROCEDURE Eliminar_Pedido(
	pedido_id INT
)
BEGIN
    -- Iniciar una transacción
    START TRANSACTION;
    
    -- Eliminar las facturas asociadas al pedido
    DELETE FROM factura WHERE ID IN (SELECT ID FROM pedido WHERE ID = pedido_id) AND Tipo_Factura = 'Pedido';
    
    -- Luego, eliminar el pedido
    DELETE FROM pedido WHERE ID = pedido_id;
    
    -- Confirmar la transacción
    COMMIT;
    
    SELECT 'Pedido eliminado exitosamente' AS Message;
END//

CREATE PROCEDURE Eliminar_Reparacion(
	reparacion_id INT
)
BEGIN
    -- Iniciar una transacción
    START TRANSACTION;
    
    -- Eliminar las facturas asociadas al pedido
    DELETE FROM factura WHERE ID IN (SELECT ID FROM reparacion WHERE ID = reparacion_id) AND Tipo_Factura = 'Reparacion';
    
    -- Luego, eliminar el pedido
    DELETE FROM reparacion WHERE ID = reparacion_id;
    
    -- Confirmar la transacción
    COMMIT;
    
    SELECT 'Reparacion eliminada exitosamente' AS Message;
END//
DELIMITER ;

INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellido`, `Direccion`, `CodigoPostal`, `Email`, `Telefono`) VALUES
('21376754C', 'Asier', 'Manterola', 'Arbes Kalea, 18', 20304, 'mantequilla@gmail.com', 612095941),
('44577788E', 'Iñigo', 'Vicente', 'Av. Navarra, 15', 20035, 'hastalaproxima@gmail.com', 654421129),
('54647912K', 'Juan', 'Antero Asumu Azeme Efiri', 'Tolosa kalea, 2', 20302, 'naafiri@gmail.com', 602335837),
('76343784D', 'Beñat', 'Merino', 'Dario de Reboyos, 5', 20229, 'lujazo@gmail.com', 676676776),
('89211425L', 'Jagoba', 'Peruarena', 'Amute Kalea, 17', 20303, 'jperuvian@gmail.com', 634607848),
('90987654G', 'Xabier', 'Vacas', 'Av. Gipuzkoa, 5', 20300, 'ponytail32@gmail.com', 643326766);

INSERT INTO `producto`(`Nombre`, `Tipo`, `Marca`, `Precio`, `Stock`) VALUES
('GeForce RTX 4060 Ti OC 8GB GDD','Tarjeta gráfica','Asus',275.00,80),
('B760 GAMING PLUS WIFI','Placa base','MSI',154.99,150),
('Vengance RGB 8GB','Memoria RAM','Corsair',30.99,500),
('Ryzen 7 5800X 3.8GHz','Procesador','AMD',219.00,120),
('EXCERIA PLUS G3 2TB SSD M.2','Disco Duro SSD','Kioxia',105.99,340),
('Liquid Cooler 360 ARGB 360mm','Refrigeración Líquida','Tempest',134.99,175);

CALL Insertar_Pedido (1,'2024-04-04',0.0,'54647912K');
CALL Insertar_Pedido (2,'2024-04-14',0.0,'89211425L');
CALL Insertar_Pedido (3,'2024-04-12',0.0,'21376754C');
CALL Insertar_Pedido (4,'2024-04-03',0.0,'90987654G');
CALL Insertar_Pedido (5,'2024-04-27',0.0,'76343784D');
CALL Insertar_Pedido (6,'2024-04-18',0.0,'21376754C');

INSERT INTO `lineapedido` (`ID_Pedido`, `ID_Producto`, `Cantidad`) VALUES
(1,1,1),
(2,3,4),
(3,5,1),
(3,1,1),
(4,2,2),
(5,3,2),
(6,6,1);

-- Create roles
-- CREATE ROLE appAdmin;
-- CREATE ROLE appUser;

-- Grant privileges to appAdmin role
-- GRANT CREATE USER, CREATE TABLESPACE, ALTER ON *.* TO appAdmin;

-- Grant privileges to appUser role
-- GRANT CREATE ON *.* TO appUser;

-- Create users
-- CREATE USER 'app_admin' IDENTIFIED BY 'admin';
-- CREATE USER 'app_user' IDENTIFIED BY 'user';

-- Assign roles to users
-- GRANT appAdmin TO 'app_admin'@'localhost';
-- GRANT appUser TO 'app_user'@'localhost';

-- DROP USER 'app_admin'@'localhost';
-- DROP USER 'app_user'@'localhost';