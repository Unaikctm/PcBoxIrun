DROP TABLE IF EXISTS lineapedido;
DROP TABLE IF EXISTS factura;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS reparacion;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS historico;
DROP TABLE IF EXISTS carrito;

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
    Precio DECIMAL(6,2) NOT NULL,
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
    Total DECIMAL(6,2) NOT NULL,
    Pagado CHAR(2) NOT NULL,
    Tipo_Factura VARCHAR(20) NOT NULL
);

CREATE TABLE historico (
    ID INT NOT NULL,
    Mes DATE NOT NULL,
    Producto_Mas_Vendido INT NOT NULL,
    Cantidad_Vendida INT NOT NULL
);

CREATE TABLE carrito (
    ID_Producto INT NOT NULL,
    Cantidad INT NOT NULL,
    Precio DECIMAL(6,2) NOT NULL
);

-- Primary Keys
ALTER TABLE cliente ADD PRIMARY KEY (DNI);
ALTER TABLE reparacion ADD PRIMARY KEY (ID);
ALTER TABLE pedido ADD PRIMARY KEY (ID);
ALTER TABLE producto ADD PRIMARY KEY (ID);
ALTER TABLE lineapedido ADD PRIMARY KEY (ID_Pedido, ID_Producto);
ALTER TABLE factura ADD PRIMARY KEY (ID, Tipo_Factura);
ALTER TABLE historico ADD PRIMARY KEY (ID);

-- Auto-increments
ALTER TABLE producto MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE pedido MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE reparacion MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE factura MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE historico MODIFY ID INT AUTO_INCREMENT;

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
DROP PROCEDURE IF EXISTS Producto_Mas_Vendido //
DROP EVENT IF EXISTS Calcular_Producto_Mas_Vendido //
DROP PROCEDURE IF EXISTS Insertar_Carrito_LineaPedido //

CREATE PROCEDURE Insertar_Pedido (
    p_Fecha DATE,
    p_DNI_Cliente VARCHAR(9)
) 
-- QUIERO CALCULAR EL TOTAL, PERO DA CONSTRAINT FOREIGN KEY ERROR. LINEA PEDIDO SE INSERTA MAS TARDE, POR LO QUE NO SE COMO HACERLO
BEGIN

	DECLARE ID INT;
    DECLARE TOTAL DECIMAL(6,2);
    
    -- Insertar el pedido
    INSERT INTO pedido(Fecha, DNI_Cliente)
    VALUES (p_Fecha, p_DNI_Cliente);
    
    SET ID = LAST_INSERT_ID();
    
    -- Realizar la consulta para calcular el total del pedido
    SELECT SUM(producto.Precio * lineapedido.Cantidad)
    INTO TOTAL
    FROM pedido
    JOIN lineapedido ON pedido.ID = lineapedido.ID_Pedido
    JOIN producto ON lineapedido.ID_Producto = producto.ID
    WHERE pedido.ID = ID;
    
    SET TOTAL = TOTAL * 1.21;
    
    -- Insertar la factura
    INSERT INTO factura(ID, Fecha, Total, Pagado, Tipo_Factura)
    VALUES (ID, p_Fecha, TOTAL, 'No', 'Pedido');

    COMMIT;

END//

CREATE PROCEDURE Insertar_Carrito_LineaPedido (
	ID_Pedido INT,
    ID_Producto INT,
    Cantidad INT
) 
BEGIN

    -- Insertar la lineapedido
    INSERT INTO lineapedido(ID_Pedido, ID_Producto, Cantidad)
    VALUES (ID_Pedido, ID_Producto, Cantidad);
    
    COMMIT;

END//

CREATE PROCEDURE Insertar_Reparacion (
    r_Tipo VARCHAR(20),
    r_Descripcion VARCHAR(90),
    r_Horas INT,
    r_Precio DECIMAL(5,2),
    f_total DECIMAL(5,2),
    f_Fecha DATE,
    r_DNI_Cliente VARCHAR(9)
)
BEGIN

	DECLARE ID INT;
    -- Insertar la reparacion
    INSERT INTO reparacion(Tipo, Descripcion, Horas, Precio, DNI_Cliente)
    VALUES (r_Tipo, r_Descripcion, r_Horas, r_Precio, r_DNI_Cliente);
     
	SET ID = LAST_INSERT_ID();
    -- Insertar la factura
    INSERT INTO factura(ID, Fecha, Total, Pagado, Tipo_Factura)
    VALUES (ID, f_Fecha, f_Total, 'No', 'Reparacion');

    COMMIT;
END//

CREATE PROCEDURE Eliminar_Pedido(
	pedido_id INT
)
BEGIN
    -- Iniciar una transaccion
    START TRANSACTION;
    
    -- Eliminar las facturas asociadas al pedido
    DELETE FROM factura WHERE ID IN (SELECT ID FROM pedido WHERE ID = pedido_id) AND Tipo_Factura = 'Pedido';
    
    -- Luego, eliminar el pedido
    DELETE FROM pedido WHERE ID = pedido_id;
    
    -- Confirmar la transaccion
    COMMIT;
END//

CREATE PROCEDURE Eliminar_Reparacion(
	reparacion_id INT
)
BEGIN
    -- Iniciar una transaccion
    START TRANSACTION;
    
    -- Eliminar las facturas asociadas al pedido
    DELETE FROM factura WHERE ID IN (SELECT ID FROM reparacion WHERE ID = reparacion_id) AND Tipo_Factura = 'Reparacion';
    
    -- Luego, eliminar el pedido
    DELETE FROM reparacion WHERE ID = reparacion_id;
    
    -- Confirmar la transacciÃ³n
    COMMIT;
END//


CREATE PROCEDURE Producto_Mas_Vendido()
BEGIN
    DECLARE fechaInicio DATE;
    DECLARE fechaFin DATE;
    DECLARE mesActual DATE;
    DECLARE productoID INT;
    DECLARE cantidadMaxima INT;
    
    SET fechaInicio = LAST_DAY(DATE_SUB(NOW(), INTERVAL 2 MONTH)) + INTERVAL 1 DAY; -- Primer dÃ­a del mes anterior
    SET fechaFin = LAST_DAY(DATE_SUB(NOW(), INTERVAL 1 MONTH)); -- Ãšltimo dÃ­a del mes anterior
	
    SELECT ID_Producto, SUM(Cantidad) AS Total_Vendido
    INTO productoID, cantidadMaxima
    FROM lineapedido lp
    JOIN pedido p ON lp.ID_Pedido = p.ID
    WHERE p.Fecha BETWEEN fechaInicio AND fechaFin
    GROUP BY ID_Producto
    ORDER BY Total_Vendido DESC
    LIMIT 1;

    IF productoID IS NOT NULL THEN
        INSERT INTO historico (Mes, Producto_Mas_Vendido, Cantidad_Vendida)
        VALUES (fechaInicio, productoID, cantidadMaxima);
    END IF;
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
('GeForce RTX 4060 Ti OC 8GB GDD','Tarjeta grafica','Asus',275.00,80),
('B760 GAMING PLUS WIFI','Placa base','MSI',154.99,150),
('Vengeance RGB 8GB','Memoria RAM','Corsair',30.99,500),
('Ryzen 7 5800X 3.8GHz','Procesador','AMD',219.00,120),
('EXCERIA PLUS G3 2TB SSD M.2','Disco Duro SSD','Kioxia',105.99,340),
('Liquid Cooler 360 ARGB 360mm','Refrigeracion Liquida','Tempest',134.99,175);

CALL Insertar_Pedido ('2024-01-04','54647912K');
CALL Insertar_Pedido ('2024-02-14','89211425L');
CALL Insertar_Pedido ('2024-03-12','21376754C');
CALL Insertar_Pedido ('2024-04-03','90987654G');
CALL Insertar_Pedido ('2024-02-27','76343784D');
CALL Insertar_Pedido ('2024-04-18','21376754C');
CALL Insertar_Pedido ('2024-05-03','54647912K');

INSERT INTO `lineapedido` (`ID_Pedido`, `ID_Producto`, `Cantidad`) VALUES
(1,1,1),
(2,3,4),
(3,5,1),
(3,1,1),
(4,2,2),
(5,3,2),
(6,6,1),
(7,2,1);

CALL Insertar_Reparacion('Reemplazo', 'Reemplazo del disco duro dañado por uno nuevo de 1TB', 2, 80.00, 90.00, '2024-04-15', '21376754C');
CALL Insertar_Reparacion('Instalaciones', 'Instalacion y configuracion del paquete de software de diseño grafico', 3, 120.00, 130.00, '2024-04-20', '44577788E');
CALL Insertar_Reparacion('Limpieza', 'Limpieza interna y externa de la computadora portÃ¡til', 1, 50.00, 60.00, '2024-04-25', '54647912K');
CALL Insertar_Reparacion('Reemplazo', 'Instalacion de modulos de memoria RAM adicionales para mejorar el rendimiento', 2, 70.00, 80.00, '2024-04-28', '76343784D');
CALL Insertar_Reparacion('Reemplazo', 'Reemplazo de la pantalla LCD dañada por una nueva de alta resolucion', 3, 150.00, 160.00, '2024-05-02', '89211425L');
CALL Insertar_Reparacion('Soluciones', 'Diagnostico y solucion de problemas de hardware detectados', 2, 90.00, 100.00, '2024-05-05', '90987654G');

CREATE EVENT Calcular_Producto_Mas_Vendido
ON SCHEDULE
    EVERY 1 MONTH  -- Ejecutar cada mes
    STARTS '2024-01-01 00:00:00'  -- Fecha de inicio del evento
DO CALL ProductoMasVendido();

SELECT *
FROM historico;

SELECT id FROM pedido WHERE id=LAST_INSERT_ID()
/*
DELIMITER //
DROP PROCEDURE IF EXISTS obtenerFechas //

CREATE PROCEDURE obtenerFechas()
BEGIN
    DECLARE fechaInicio DATE;
    DECLARE fechaFin DATE;
    
    SET fechaInicio = LAST_DAY(DATE_SUB(NOW(), INTERVAL 2 MONTH)) + INTERVAL 1 DAY;
    SET fechaFin = LAST_DAY(DATE_SUB(NOW(), INTERVAL 1 MONTH));

    SELECT fechaInicio, fechaFin;
END //

DELIMITER ;

CALL obtenerFechas();
*/

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