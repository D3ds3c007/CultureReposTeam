-- Insertion des données dans la table "owner"
INSERT INTO owner (id_owner, name, email, pwd) VALUES
(1, 'John Doe', 'john@example.com', 'password123'),
(2, 'Jane Smith', 'jane@example.com', 'password456'),
(3, 'Robert Johnson', 'robert@example.com', 'password789');

-- Insertion des données dans la table "ground_type"
INSERT INTO ground_type (id_ground_type, name) VALUES
(1, 'Type A'),
(2, 'Type B'),
(3, 'Type C');

-- Insertion des données dans la table "field"
INSERT INTO field (id_field, latitude, longitude, id_owner) VALUES
(1, 40.7128, -74.0060, 1),
(2, 34.0522, -118.2437, 2),
(3, 41.8781, -87.6298, 3);

-- Insertion des données dans la table "plot"
INSERT INTO plot (id_plot, id_field, area, id_ground_type) VALUES
(1, 1, 10.5, 1),
(2, 1, 8.2, 2),
(3, 2, 15.2, 1),
(4, 3, 12.0, 3);

-- Insertion des données dans la table "action"
INSERT INTO action (id_action, name) VALUES
(1, 'Plantation'),
(2, 'Arrosage'),
(3, 'Insecticide');

-- Insertion des données dans la table "simulation"
-- Insertion des données dans la table "simulation"
INSERT INTO simulation (id_simulation, id_plot, id_culture, date_simulation) VALUES
(1, 1, 1, '2024-01-01 10:00:00'),
(2, 2, 2, '2024-01-10 12:30:00'),
(3, 1, 1, '2024-01-21 10:00:00'),
(4, 2, 2, '2024-02-02 12:30:00'),
(5, 1, 1, '2024-02-04 10:00:00'),
(6, 2, 2, '2024-02-11 12:30:00'),
(7, 1, 1, '2024-02-17 10:00:00'),
(8, 2, 2, '2024-03-28 12:30:00'),
(9, 3, 1, '2024-04-03 15:45:00');


-- Insertion des données dans la table "simulation_details"
INSERT INTO simulation_details (id_details, id_simulation, id_action, quantity, price) VALUES
(1, 1, 1, 100, 50.0),
(2, 2, 2, 1, 10.0),
(3, 3, 3, 80, 100.0),
(4, 4, 1, 120, 60.0),
(5, 5, 2, 2, 20.0),
(6, 6, 3, 70, 90.0),
(7, 7, 1, 90, 45.0),
(8, 8, 2, 3, 30.0),
(9, 9, 3, 60, 80.0);


INSERT INTO field (id_field, latitude, longitude, id_owner) VALUES
(1, 40.7128, -74.0060, 1),
(2, 34.0522, -118.2437, 2),
(3, 41.8781, -87.6298, 3);

---------------------------------------------------------------------------------------------------

-- Insertion des données dans la table "culture"
INSERT INTO culture (id_culture, name, seed_quantity, yield_quantity, unit, seed_price, yield_price, id_ground_type) VALUES
(1, 'Culture A', 10.0, 200.0, 1, 5.0, 100.0, 1),
(2, 'Culture B', 8.0, 180.0, 2, 4.0, 90.0, 2),
(3, 'Culture C', 12.0, 220.0, 1, 6.0, 110.0, 3);

-- Insertion des données dans la table "plot"
INSERT INTO plot (id_plot, id_field, area, id_ground_type) VALUES
(1, 1, 10.5, 1),
(2, 1, 8.2, 2),
(3, 2, 15.2, 1),
(4, 3, 12.0, 3);

-- Insertion des données dans la table "simulation"
INSERT INTO simulation (id_simulation, id_plot, id_culture, date_simulation) VALUES
(10, 1, 1, '2024-01-01 10:00:00'),
(11, 2, 2, '2024-02-02 12:30:00'),
(12, 3, 1, '2024-03-03 15:45:00'),
(13, 4, 3, '2024-04-04 18:00:00');

-- Insertion des données dans la table "yield"
INSERT INTO yield (id_yield, id_simulation, date_yield, quantity) VALUES
(1, 1, '2024-01-15 14:30:00', 150),
(2, 2, '2024-02-20 16:45:00', 130),
(3, 3, '2024-03-25 20:00:00', 180),
(4, 4, '2024-04-30 22:15:00', 160);





