INSERT INTO mi_basedatos_2.public.category (name, description) VALUES
                                                                   ('Electrónica', 'Productos tecnológicos y dispositivos digitales'),
                                                                   ('Hogar', 'Artículos y accesorios para el hogar'),
                                                                   ('Jardinería', 'Herramientas y productos para el cuidado del jardín'),
                                                                   ('Deportes', 'Equipamiento y accesorios deportivos'),
                                                                   ('Oficina', 'Material de oficina y suministros profesionales'),
                                                                   ('Cocina', 'Utensilios y electrodomésticos de cocina'),
                                                                   ('Iluminación', 'Lámparas y sistemas de iluminación'),
                                                                   ('Audio', 'Equipos de sonido y accesorios de audio'),
                                                                   ('Videojuegos', 'Consolas, juegos y accesorios gamer'),
                                                                   ('Telefonía', 'Smartphones y accesorios móviles');




INSERT INTO mi_basedatos_2.public.product (
    category_id,
    sku,
    name,
    description,
    price,
    stock,
    active
) VALUES
      (1, 'SKU-TECL-001', 'Teclado mecánico RGB', 'Teclado mecánico con switches rojos y retroiluminación RGB.', 59.99, 25, true),
      (1, 'SKU-MONI-002', 'Monitor 27" IPS', 'Monitor IPS de 27 pulgadas con resolución 1440p.', 199.90, 12, true),
      (1, 'SKU-RATO-003', 'Ratón inalámbrico', 'Ratón inalámbrico ergonómico con batería de larga duración.', 29.95, 40, true),
      (1, 'SKU-AURI-004', 'Auriculares Bluetooth', 'Auriculares inalámbricos con cancelación de ruido activa.', 89.99, 18, true),
      (1, 'SKU-WEBC-005', 'Webcam HD 1080p', 'Webcam de alta definición con micrófono integrado.', 39.50, 22, true),

      (2, 'SKU-CAFE-006', 'Cafetera Express', 'Cafetera express de acero inoxidable con vaporizador.', 89.50, 8, true),
      (2, 'SKU-TOST-007', 'Tostadora 2 ranuras', 'Tostadora de dos ranuras con control de temperatura.', 24.99, 15, true),
      (2, 'SKU-LAMP-008', 'Lámpara LED', 'Lámpara LED de escritorio con brillo regulable.', 17.49, 30, true),
      (2, 'SKU-PLAN-009', 'Plancha de vapor', 'Plancha de vapor con suela cerámica y calentamiento rápido.', 34.95, 20, true),
      (2, 'SKU-VENT-010', 'Ventilador de pie', 'Ventilador de pie con 3 velocidades y modo silencioso.', 45.00, 10, true);



