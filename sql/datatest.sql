-- Marque
INSERT INTO Marque (nom) VALUES
                             ('Porsche'),
                             ('Chevrolet'),
                             ('Toyota'),
                             ('Ford'),
                             ('BMW'),
                             ('Audi'),
                             ('Nissan'),
                             ('Hyundai'),
                             ('Ferrari'),
                             ('Lamborghini');

-- Typevoiture
INSERT INTO Typevoiture (typevoiture) VALUES ('Sedan');
INSERT INTO Typevoiture (typevoiture) VALUES ('SUV');
INSERT INTO Typevoiture (typevoiture) VALUES ('Cabriolet');
INSERT INTO Typevoiture (typevoiture) VALUES ('Sportive');
INSERT INTO Typevoiture (typevoiture) VALUES ('Berline');


-- Modele
INSERT INTO Modele (modele, Id_Typevoiture, Id_Marque) VALUES
                                                           ('Camry', 1, 1),
                                                           ('Civic', 1, 2),
                                                           ('Fusion', 1, 3),
                                                           ('Malibu', 1, 4),
                                                           ('Passat', 1, 5),
                                                           ('C-Class', 2, 6),
                                                           ('3 Series', 2, 7),
                                                           ('A4', 2, 8),
                                                           ('Altima', 1, 9),
                                                           ('Elantra', 1, 10),
                                                           ('911', 4, 1),            -- Cabriolet - Porsche
                                                           ('Corvette', 4, 2),        -- Cabriolet - Chevrolet
                                                           ('Supra', 4, 3),           -- Cabriolet - Toyota
                                                           ('Mustang', 4, 4),         -- Cabriolet - Ford
                                                           ('Z4', 4, 5),              -- Cabriolet - BMW
                                                           ('R8', 4, 6),              -- Cabriolet - Audi
                                                           ('GT-R', 4, 7),            -- Cabriolet - Nissan
                                                           ('Veloster', 4, 8),        -- Cabriolet - Hyundai
                                                           ('488 Spider', 4, 9),      -- Cabriolet - Ferrari
                                                           ('Aventador', 4, 10),      -- Cabriolet - Lamborghini
                                                           ('Crevette', 5, 1),        -- Sportive - Chevrolet
                                                           ('RS5', 5, 2),             -- Sportive - Audi
                                                           ('GT-M', 5, 3),            -- Sportive - Nissan
                                                           ('Genesis Coupe', 5, 4),   -- Sportive - Hyundai
                                                           ('M4', 5, 5),              -- Sportive - BMW
                                                           ('M3', 5, 6),              -- Sportive - BMW
                                                           ('Huracan', 5, 7),        -- Sportive - Lamborghini
                                                           ('488 GTB', 5, 8),         -- Sportive - Ferrari
                                                           ('911 GT3', 5, 9),             -- Berline - Porsche
                                                           ('Marivu', 3, 1),          -- Berline - Chevrolet
                                                           ('Cialiv', 3, 1),           -- Berline - Toyota
                                                           ('Fasion', 3, 2),          -- Berline - Ford
                                                           ('4 Series', 3, 3),        -- Berline - BMW
                                                           ('A5', 3, 4),              -- Berline - Audi
                                                           ('Ultimate', 3, 5),          -- Berline - Nissan
                                                           ('Mangina', 3, 6),         -- Berline - Hyundai
                                                           ('Portofino', 3, 7),       -- Berline - Ferrari
                                                           ('Urus', 3, 8);



-- Couleur
INSERT INTO Couleur (nom) VALUES ('Blue');
INSERT INTO Couleur (nom) VALUES ('Red');

-- Transmission
INSERT INTO Transmission (transmission_) VALUES ('Automatic');
INSERT INTO Transmission (transmission_) VALUES ('Manual');

-- Carburant
INSERT INTO Carburant (carburant) VALUES ('Gasoline');
INSERT INTO Carburant (carburant) VALUES ('Hybrid');

-- Utilisateur
--INSERT INTO Utilisateur (prenom, nom, datenaissance, login, motdepasse, role, telephone) VALUES
                                                                                             --('John', 'Doe', '1990-01-15', 'john_doe', 'password123', 'client', '123-456-7890'),
                                                                                             --('Alice', 'Smith', '1985-05-22', 'alice_smith', 'securepass', 'client', '987-654-3210'),
                                                                                             --('Admin', 'Adminson', '1980-10-10', 'admin', 'adminpass', 'admin', '555-555-5555');

-- Volant
INSERT INTO Volant (volant) VALUES ('Leather');
INSERT INTO Volant (volant) VALUES ('Wooden');

-- Commission
INSERT INTO Commission (datecommission, pourcentage_) VALUES ('2024-01-14', 20.0);
INSERT INTO Commission (datecommission, pourcentage_) VALUES ('2024-01-17', 17.5);
INSERT INTO Commission (datecommission, pourcentage_) VALUES ('2024-01-20', 10.5);

-- Insertions dans la table Region
INSERT INTO Region (region) VALUES
                                ('North'),
                                ('South');

-- Insertions dans la table Annonceutilisateur
INSERT INTO Annonceutilisateur (matricule, dateannonce, kilometrage, annee, moteur, description, climatisation, prix, Id_Region, Id_Volant, Id_Couleur, Id_Carburant, Id_Transmission, Id_Modele, Idutilisateur, status)
VALUES
    ('ABC123', '2024-01-05', 50000, 2019, '1.6L Essence', 'Bonne condition', 1, 15000.00, 1, 1, 1, 1, 1, 1, 1, 1),
    ('DEF456', '2024-02-10', 70000, 2015, '2.0L Diesel', 'Quelques égratignures', 0, 12000.00, 2, 2, 2, 2, 2, 2, 2, 1),
    ('GHI789', '2024-03-15', 30000, 2020, '1.4L Essence', 'Comme neuf', 1, 18000.00, 1, 1, 1, 1, 1, 3, 3, 1),
    ('JKL012', '2024-04-20', 90000, 2012, '1.8L Essence', 'Besoin de réparations mineures', 1, 8000.00, 2, 2, 2, 2, 2, 4, 1, 0),
    ('MNO345', '2024-05-25', 60000, 2017, '2.5L Essence', 'En bon état, entretien régulier', 1, 20000.00, 1, 1, 1, 1, 1, 5, 2, 1),
    ('PQR678', '2024-06-30', 40000, 2018, '1.6L Diesel', 'Faible consommation de carburant', 1, 17000.00, 2, 2, 2, 2, 2, 6, 3, 1),
    ('STU901', '2024-07-05', 80000, 2014, '2.0L Essence', 'Quelques bosses', 0, 10000.00, 1, 1, 1, 1, 1, 7, 1, 0),
    ('VWX234', '2024-08-10', 35000, 2019, '1.4L Diesel', 'Excellent état, peu utilisé', 1, 19000.00, 2, 2, 2, 2, 2, 8, 2, 1),
    ('YZA567', '2024-09-15', 75000, 2016, '1.8L Diesel', 'Nécessite une révision', 0, 13000.00, 1, 1, 1, 1, 1, 9, 3, 0),
    ('BCD890', '2024-10-20', 55000, 2015, '2.2L Essence', 'Vendu tel quel, prix négociable', 1, 11000.00, 2, 2, 2, 2, 2, 10, 1, 1),
    ('EFG123', '2024-01-05', 55000, 2020, '1.8L Essence', 'En excellent état, entretien régulier', 1, 19000.00, 2, 2, 2, 2, 2, 11, 1, 1),
    ('HIJ456', '2024-02-10', 80000, 2014, '2.5L Diesel', 'Quelques rayures mineures', 0, 13000.00, 1, 1, 1, 1, 1, 12, 2, 1),
    ('KLM789', '2024-03-15', 40000, 2021, '2.0L Essence', 'Presque neuf, très peu utilisé', 1, 22000.00, 2, 2, 2, 2, 2, 13, 3, 1),
    ('NOP012', '2024-04-20', 95000, 2013, '2.0L Essence', 'Besoin de réparations mineures', 1, 9000.00, 1, 1, 1, 1, 1, 14, 1, 0),
    ('QRS345', '2024-05-25', 65000, 2018, '1.6L Diesel', 'Très économique en carburant', 1, 18000.00, 2, 2, 2, 2, 2, 15, 2, 1),
    ('TUV678', '2024-06-30', 45000, 2019, '1.4L Essence', 'Très bien entretenu, comme neuf', 1, 20000.00, 1, 1, 1, 1, 1, 16, 3, 1),
    ('VWX901', '2024-07-05', 85000, 2015, '2.0L Essence', 'Légères égratignures sur la carrosserie', 0, 11000.00, 2, 2, 2, 2, 2, 17, 1, 0),
    ('YZA234', '2024-08-10', 40000, 2020, '1.6L Diesel', 'Excellent état, faible kilométrage', 1, 19000.00, 1, 1, 1, 1, 1, 18, 2, 1),
    ('BCD567', '2024-09-15', 80000, 2017, '2.0L Diesel', 'Besoin de quelques réparations mécaniques', 0, 13500.00, 2, 2, 2, 2, 2, 19, 3, 0),
    ('EFG890', '2024-10-20', 60000, 2016, '1.8L Essence', 'Bon état général, bon rapport qualité-prix', 1, 15000.00, 1, 1, 1, 1, 1, 20, 1, 1);

-- Insertions dans la table commissionannonce
INSERT INTO commissionannonce (Id_Annonceutilisateur, commissionannonce)
VALUES
    (1, 15.00),
    (2, 12.00),
    (3, 18.00),
    (4, 8.00),
    (5, 20.00),
    (6, 17.00),
    (7, 10.00),
    (8, 19.00),
    (9, 13.00),
    (10, 11.00),
    (11, 16.00),
    (12, 14.00),
    (13, 20.00),
    (14, 9.00),
    (15, 18.00),
    (16, 21.00),
    (17, 12.00),
    (18, 20.00),
    (19, 11.00),
    (20, 15.00);

-- Insertions dans la table Annoncefavoris
INSERT INTO Annoncefavoris (Id_Annonceutilisateur, Idutilisateur)
VALUES
    (1, 1),
    (3, 2),
    (5, 3),
    (7, 1),
    (9, 2),
    (2, 3),
    (4, 1),
    (6, 2),
    (8, 3),
    (10, 1),
    (11, 1),
    (13, 2),
    (15, 3),
    (17, 1),
    (19, 2),
    (12, 3),
    (14, 1),
    (16, 2),
    (18, 3),
    (20, 1);

-- Insertions dans la table annoncevalide
INSERT INTO annoncevalide (datevalidation, Idutilisateur, Id_Annonceutilisateur)
VALUES
    ('2024-01-10', 1, 1),
    ('2024-02-15', 2, 3),
    ('2024-03-20', 3, 5),
    ('2024-04-25', 1, 7),
    ('2024-05-30', 2, 9),
    ('2024-06-05', 3, 2),
    ('2024-07-10', 1, 4),
    ('2024-08-15', 2, 6),
    ('2024-09-20', 3, 8),
    ('2024-10-25', 1, 10),
    ('2024-01-10', 1, 11),
    ('2024-02-15', 2, 13),
    ('2024-03-20', 3, 15),
    ('2024-04-25', 1, 17),
    ('2024-05-30', 2, 19),
    ('2024-06-05', 3, 12),
    ('2024-07-10', 1, 14),
    ('2024-08-15', 2, 16),
    ('2024-09-20', 3, 18),
    ('2024-10-25', 1, 20);

-- Insertions dans la table Historiqueachat
INSERT INTO Historiqueachat (dateachat, prixachat, Id_Utilisateur, Id_Annonceutilisateur)
VALUES
    ('2024-01-20', 14500.00, 1, 1),
    ('2024-02-25', 11000.00, 2, 3),
    ('2024-03-30', 19000.00, 3, 5),
    ('2024-04-05', 7500.00, 1, 7),
    ('2024-05-10', 19500.00, 2, 9),
    ('2024-06-15', 11800.00, 3, 2),
    ('2024-07-20', 9800.00, 1, 4),
    ('2024-08-25', 14500.00, 2, 6),
    ('2024-09-30', 12500.00, 3, 8),
    ('2024-10-05', 10500.00, 1, 10),
    ('2024-01-20', 16500.00, 1, 11),
    ('2024-02-25', 12200.00, 2, 13),
    ('2024-03-30', 21000.00, 3, 15),
    ('2024-04-05', 8500.00, 1, 17),
    ('2024-05-10', 17500.00, 2, 19),
    ('2024-06-15', 12500.00, 3, 12),
    ('2024-07-20', 10200.00, 1, 14),
    ('2024-08-25', 14800.00, 2, 16),
    ('2024-09-30', 12900.00, 3, 18),
    ('2024-10-05', 11500.00, 1, 20);

INSERT INTO mois (mois) VALUES
                            ('janvier'),
                            ('février'),
                            ('mars'),
                            ('avril'),
                            ('mai'),
                            ('juin'),
                            ('juillet'),
                            ('août'),
                            ('septembre'),
                            ('octobre'),
                            ('novembre'),
                            ('décembre');