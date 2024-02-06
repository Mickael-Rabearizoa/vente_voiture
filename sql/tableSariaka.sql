CREATE TABLE Marque(
                       Id_Marque SERIAL,
                       nom VARCHAR(50) ,
                       PRIMARY KEY(Id_Marque)
);



CREATE TABLE Typevoiture(
                            Id_Typevoiture SERIAL,
                            typevoiture VARCHAR(50) ,
                            PRIMARY KEY(Id_Typevoiture),
                            UNIQUE(typevoiture)
);


CREATE TABLE Modele(
                       Id_Modele SERIAL,
                       modele VARCHAR(50) ,
                       Id_Typevoiture INTEGER NOT NULL,
                       Id_Marque INTEGER NOT NULL,
                       PRIMARY KEY(Id_Modele),
                       UNIQUE(modele),
                       FOREIGN KEY(Id_Typevoiture) REFERENCES Typevoiture(Id_Typevoiture),
                       FOREIGN KEY(Id_Marque) REFERENCES Marque(Id_Marque)
);


CREATE TABLE Couleur(
                        Id_Couleur SERIAL,
                        nom VARCHAR(50) ,
                        PRIMARY KEY(Id_Couleur),
                        UNIQUE(nom)
);


CREATE TABLE Transmission(
                             Id_Transmission SERIAL,
                             transmission_ VARCHAR(50) ,
                             PRIMARY KEY(Id_Transmission),
                             UNIQUE(transmission_)
);


CREATE TABLE Carburant(
                          Id_Carburant SERIAL,
                          carburant VARCHAR(50) ,
                          PRIMARY KEY(Id_Carburant),
                          UNIQUE(carburant)
);


CREATE TABLE Utilisateur(
                            Idutilisateur SERIAL,
                            prenom VARCHAR(50)  NOT NULL,
                            nom VARCHAR(50)  NOT NULL,
                            datenaissance DATE NOT NULL,
                            login VARCHAR(29) Not NULL ,
                            motdepasse VARCHAR  NOT NULL,
                            role VARCHAR(20) NOT NULL,
                            telephone VARCHAR(50) ,
                            PRIMARY KEY(Idutilisateur)
);


CREATE TABLE Volant(
                       Id_Volant SERIAL,
                       volant VARCHAR(50)  NOT NULL,
                       PRIMARY KEY(Id_Volant),
                       UNIQUE(volant)
);



CREATE TABLE Region(
                       Id_Region SERIAL,
                       region VARCHAR(50) ,
                       PRIMARY KEY(Id_Region)
);
CREATE TABLE Commission(
                           Id_Commission SERIAL,
                           datecommission DATE,
                           pourcentage_ DOUBLE PRECISION,
                           PRIMARY KEY(Id_Commission)
);



CREATE TABLE Annonceutilisateur(
                                   Id_Annonceutilisateur SERIAL,
                                   matricule VARCHAR(50)  NOT NULL,
                                   dateannonce DATE,
                                   kilometrage DOUBLE PRECISION,
                                   annee INTEGER NOT NULL,
                                   moteur VARCHAR(50) NOT NULL,
                                   description TEXT,
                                   climatisation INTEGER,
                                   prix NUMERIC(15,2),
                                   Id_Region INTEGER NOT NULL,
                                   Id_Volant INTEGER NOT NULL,
                                   Id_Couleur INTEGER NOT NULL,
                                   Id_Carburant INTEGER NOT NULL,
                                   Id_Transmission INTEGER NOT NULL,
                                   Id_Modele INTEGER NOT NULL,
                                   Idutilisateur INTEGER NOT NULL,
                                   status INTEGER NOT NULL,
                                   PRIMARY KEY(Id_Annonceutilisateur),
                                   FOREIGN KEY(Id_Region) REFERENCES Region(Id_Region),
                                   FOREIGN KEY(Id_Volant) REFERENCES Volant(Id_Volant),
                                   FOREIGN KEY(Id_Couleur) REFERENCES Couleur(Id_Couleur),
                                   FOREIGN KEY(Id_Carburant) REFERENCES Carburant(Id_Carburant),
                                   FOREIGN KEY(Id_Transmission) REFERENCES Transmission(Id_Transmission),
                                   FOREIGN KEY(Id_Modele) REFERENCES Modele(Id_Modele),
                                   FOREIGN KEY(Idutilisateur) REFERENCES Utilisateur(Idutilisateur)
);

CREATE TABLE commissionannonce (
                                   Id_CommissionAnnonce serial primary key,
                                   Id_Annonceutilisateur int,
                                   commissionannonce double precision,
                                   foreign key (Id_Annonceutilisateur) references Annonceutilisateur(Id_Annonceutilisateur)
);


CREATE TABLE Annoncefavoris(
                               Id_Annoncefavoris SERIAL,
                               Id_Annonceutilisateur INTEGER NOT NULL,
                               Idutilisateur INTEGER NOT NULL,
                               PRIMARY KEY(Id_Annoncefavoris),
                               FOREIGN KEY(Id_Annonceutilisateur) REFERENCES Annonceutilisateur(Id_Annonceutilisateur),
                               FOREIGN KEY(Idutilisateur) REFERENCES Utilisateur(Idutilisateur)
);

CREATE TABLE Photo(
                      Id_Photo SERIAL,
                      nomphoto VARCHAR  NOT NULL,
                      Id_Annonceutilisateur integer references Annonceutilisateur(Id_Annonceutilisateur),
                      PRIMARY KEY(Id_Photo)
);


CREATE TABLE annoncevalide(
                              Id_annoncevalide SERIAL,
                              datevalidation DATE NOT NULL,
                              Idutilisateur INTEGER NOT NULL,
                              Id_Annonceutilisateur INTEGER NOT NULL,
                              PRIMARY KEY(Id_annoncevalide),
                              FOREIGN KEY(Idutilisateur) REFERENCES Utilisateur(Idutilisateur),
                              FOREIGN KEY(Id_Annonceutilisateur) REFERENCES Annonceutilisateur(Id_Annonceutilisateur)
);

CREATE TABLE Historiqueachat(
                                Id_Historiqueachat SERIAL,
                                dateachat DATE,
                                prixachat DOUBLE PRECISION,
                                Id_Utilisateur INTEGER NOT NULL,
                                Id_Annonceutilisateur INTEGER NOT NULL,
                                PRIMARY KEY(Id_Historiqueachat),
                                FOREIGN KEY(Id_Utilisateur) REFERENCES Utilisateur(Idutilisateur),
                                FOREIGN KEY(Id_Annonceutilisateur) REFERENCES Annonceutilisateur(Id_Annonceutilisateur)
);

create table mois (
    idmois serial primary key,
    mois varchar(50)
);