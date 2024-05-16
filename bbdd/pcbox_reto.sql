DROP TABLE IF EXISTS lineapedido;
DROP TABLE IF EXISTS factura;
DROP TABLE IF EXISTS historico;
DROP TABLE IF EXISTS carrito;
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
    ID_Producto INT NOT NULL,
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
ALTER TABLE historico ADD CONSTRAINT FK_Historico FOREIGN KEY (ID_Producto)
    REFERENCES producto(ID) ON DELETE CASCADE;

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
DROP EVENT IF EXISTS Actualizar_datos //
DROP PROCEDURE IF EXISTS Actualizar_total //

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
    
    SET TOTAL = 0;
    
    -- Insertar la factura
    INSERT INTO factura(ID, Fecha, Total, Pagado, Tipo_Factura)
    VALUES (ID, p_Fecha, TOTAL, 'No', 'Pedido');

    COMMIT;

END//

CREATE PROCEDURE Insertar_Carrito_LineaPedido (
    IN p_ID_Pedido INT,
    IN p_ID_Producto INT,
    IN p_Cantidad INT
) 
BEGIN
    DECLARE v_Stock INT;

    -- Obtener el stock actual del producto
    SELECT Stock INTO v_Stock
    FROM producto
    WHERE ID = p_ID_Producto;
    
    -- Verificar si hay suficiente stock
    IF v_Stock >= p_Cantidad THEN
        
        UPDATE producto
        SET Stock = Stock - p_Cantidad
        WHERE ID = p_ID_Producto;
        
        -- Insertar la línea de pedido
        INSERT INTO lineapedido(ID_Pedido, ID_Producto, Cantidad)
        VALUES (p_ID_Pedido, p_ID_Producto, p_Cantidad);
        
    END IF;
    
    COMMIT;
    
END//

CREATE PROCEDURE Insertar_Reparacion (
    r_Tipo VARCHAR(20),
    r_Descripcion VARCHAR(90),
    r_Horas INT,
    r_Precio DECIMAL(5,2),
    f_total DECIMAL(6,2),
    f_Fecha DATE,
    r_DNI_Cliente VARCHAR(9)
)
BEGIN

	DECLARE ID INT;
    DECLARE v_TOTAL DECIMAL(6,2);
    
    -- Insertar la reparacion
    INSERT INTO reparacion(Tipo, Descripcion, Horas, Precio, DNI_Cliente)
    VALUES (r_Tipo, r_Descripcion, r_Horas, r_Precio, r_DNI_Cliente);
     
	SET v_TOTAL = r_Precio * r_Horas * 1.21;
     
	SET ID = LAST_INSERT_ID();
    -- Insertar la factura
    INSERT INTO factura(ID, Fecha, Total, Pagado, Tipo_Factura)
    VALUES (ID, f_Fecha, v_TOTAL, 'No', 'Reparacion');

    COMMIT;
END//

CREATE PROCEDURE Eliminar_Pedido(
	pedido_id INT
)
BEGIN
    -- Eliminar las facturas asociadas al pedido
    DELETE FROM factura WHERE ID IN (SELECT ID FROM pedido WHERE ID = pedido_id) AND Tipo_Factura = 'Pedido';
    
    -- Luego, eliminar el pedido
    DELETE FROM pedido WHERE ID = pedido_id;
    
    COMMIT;
END//

CREATE PROCEDURE Eliminar_Reparacion(
	reparacion_id INT
)
BEGIN
    -- Eliminar las facturas asociadas al pedido
    DELETE FROM factura WHERE ID IN (SELECT ID FROM reparacion WHERE ID = reparacion_id) AND Tipo_Factura = 'Reparacion';
    
    -- Luego, eliminar el pedido
    DELETE FROM reparacion WHERE ID = reparacion_id;

    COMMIT;
END//


CREATE PROCEDURE Producto_Mas_Vendido()
BEGIN
    DECLARE fechaInicio DATE;
    DECLARE fechaFin DATE;
    DECLARE productoID INT;
    DECLARE cantidadMaxima INT;
    DECLARE productoEncontrado BOOLEAN DEFAULT FALSE;
    
    SET fechaInicio = LAST_DAY(DATE_SUB(NOW(), INTERVAL 2 MONTH)) + INTERVAL 1 DAY; -- Primer día del mes anterior
    SET fechaFin = LAST_DAY(DATE_SUB(NOW(), INTERVAL 1 MONTH)); -- Último día del mes anterior

    -- Consulta para encontrar el producto más vendido
    SELECT ID_Producto, SUM(Cantidad) AS Total_Vendido
    INTO productoID, cantidadMaxima
    FROM lineapedido lp
    JOIN pedido p ON lp.ID_Pedido = p.ID
    WHERE p.Fecha BETWEEN fechaInicio AND fechaFin
    GROUP BY ID_Producto
    ORDER BY Total_Vendido DESC
    LIMIT 1;

    IF productoID IS NOT NULL THEN
        INSERT INTO historico (Mes, ID_Producto, Cantidad_Vendida)
        VALUES (fechaInicio, productoID, cantidadMaxima);
    END IF;

END//

CREATE PROCEDURE Actualizar_total()
BEGIN
    DECLARE v_Total DECIMAL(6,2);
    
    -- Calcular el total de cada factura de tipo 'Pedido' y actualizarlo
    UPDATE factura f
    SET Total = (
        SELECT SUM(p.Precio * lp.Cantidad) * 1.21
        FROM lineapedido lp
        JOIN producto p ON lp.ID_Producto = p.ID
        WHERE lp.ID_Pedido = f.ID
    )
    WHERE f.Tipo_Factura = 'Pedido';
    
    COMMIT;
    
END//

DELIMITER ;

CREATE EVENT Calcular_Producto_Mas_Vendido
ON SCHEDULE
    EVERY 1 MONTH  -- Ejecutar cada mes
    STARTS '2024-04-01 00:00:00'  -- Fecha de inicio del evento
DO CALL Producto_Mas_Vendido();

CREATE EVENT Actualizar_datos
ON SCHEDULE
    EVERY 1 MINUTE  -- Ejecutar cada minuto
    STARTS '2024-05-14 9:40:00'  -- Fecha de inicio del evento
DO CALL Actualizar_total();

-- INSERCIÓN DE DATOS

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

CALL Insertar_Reparacion('Reemplazo', 'Reemplazo del disco duro dañado por uno nuevo de 1TB', 2, 80.00, 0,'2024-04-15', '21376754C');
CALL Insertar_Reparacion('Instalaciones', 'Instalacion y configuracion del paquete de software de diseño grafico', 3, 120.00, 0,'2024-04-20', '44577788E');
CALL Insertar_Reparacion('Limpieza', 'Limpieza interna y externa de la computadora portatil', 1, 50.00, 0,'2024-04-25','54647912K');
CALL Insertar_Reparacion('Reemplazo', 'Instalacion de modulos de memoria RAM adicionales para mejorar el rendimiento',2, 70.00, 0, '2024-04-28', '76343784D');
CALL Insertar_Reparacion('Reemplazo', 'Reemplazo de la pantalla LCD dañada por una nueva de alta resolucion', 3, 150.00, 0,'2024-05-02', '89211425L');
CALL Insertar_Reparacion('Soluciones', 'Diagnostico y solucion de problemas de hardware detectados', 2, 90.00, 0,'2024-05-05','90987654G');

-- SIMULA LOS MESES ANTERIORES EN HISTORICO
INSERT INTO `historico` (`Mes`, `ID_Producto`, `Cantidad_Vendida`) VALUES
('2024-01-01',1,1),
('2024-02-01',3,6),
('2024-03-01',5,1),
('2024-04-01',2,2);

CREATE ROLE IF NOT EXISTS appAdmin;
CREATE ROLE IF NOT EXISTS appUser;

GRANT CREATE USER, CREATE TABLESPACE, ALTER ON *.* TO appAdmin;
GRANT CREATE ON *.* TO appUser;

CREATE USER IF NOT EXISTS 'app_admin'@'localhost' IDENTIFIED BY 'admin';
CREATE USER IF NOT EXISTS 'app_user'@'localhost' IDENTIFIED BY 'user';

GRANT appAdmin TO 'app_admin'@'localhost';
GRANT appUser TO 'app_user'@'localhost';

-- Eliminar un usuario
-- DROP USER IF EXISTS 'nombre_usuario'@'localhost';

