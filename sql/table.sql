

CREATE VIEW V_AnnonceUtilisateur AS
SELECT
    au.Id_Annonceutilisateur,
    au.matricule,
    au.dateannonce,
    au.kilometrage,
    au.annee,
    au.moteur,
    au.description,
    au.climatisation,
    au.prix,
    au.status,
    r.Id_Region as id_region,
    r.region AS nom_region,
    v.Id_Volant as id_volant,
    v.volant AS nom_volant,
    c.Id_Couleur as id_couleur,
    c.nom AS nom_couleur,
    carb.Id_Carburant as id_carburant,
    carb.carburant AS nom_carburant,
    t.Id_Transmission as id_transmission,
    t.transmission_ AS nom_transmission,
    m.Id_Modele as id_modele,
    m.modele AS nom_modele,
    marque.Id_Marque as id_marque,
    marque.nom as marque,
    type.Id_Typevoiture as id_typevoiture,
    type.typevoiture as typevoiture,
    u.Idutilisateur AS Idutilisateur,
    u.prenom AS prenom_utilisateur,
    u.nom AS nom_utilisateur
FROM
    Annonceutilisateur au
        JOIN Region r ON au.Id_Region = r.Id_Region
        JOIN Volant v ON au.Id_Volant = v.Id_Volant
        JOIN Couleur c ON au.Id_Couleur = c.Id_Couleur
        JOIN Carburant carb ON au.Id_Carburant = carb.Id_Carburant
        JOIN Transmission t ON au.Id_Transmission = t.Id_Transmission
        JOIN Modele m ON au.Id_Modele = m.Id_Modele
        JOIN Utilisateur u ON au.Idutilisateur = u.Idutilisateur
        join Typevoiture type ON m.Id_Typevoiture = type.Id_Typevoiture
        join marque marque ON marque.id_marque = m.Id_Marque ;



CREATE VIEW V_AnnonceFavorisUtilisateur AS
SELECT
    au.Id_Annonceutilisateur,
    au.matricule,
    au.dateannonce,
    au.kilometrage,
    au.annee,
    au.moteur,
    au.description,
    au.climatisation,
    au.prix,
    au.status,
    r.Id_Region as id_region,
    r.region AS nom_region,
    v.Id_Volant as id_volant,
    v.volant AS nom_volant,
    c.Id_Couleur as id_couleur,
    c.nom AS nom_couleur,
    carb.Id_Carburant as id_carburant,
    carb.carburant AS nom_carburant,
    t.Id_Transmission as id_transmission,
    t.transmission_ AS nom_transmission,
    m.Id_Modele as id_modele,
    m.modele AS nom_modele,
    u.Idutilisateur AS Idutilisateur,
    u.prenom AS prenom_utilisateur,
    u.nom AS nom_utilisateur
FROM
    Annonceutilisateur au
        JOIN Region r ON au.Id_Region = r.Id_Region
        JOIN Volant v ON au.Id_Volant = v.Id_Volant
        JOIN Couleur c ON au.Id_Couleur = c.Id_Couleur
        JOIN Carburant carb ON au.Id_Carburant = carb.Id_Carburant
        JOIN Transmission t ON au.Id_Transmission = t.Id_Transmission
        JOIN Modele m ON au.Id_Modele = m.Id_Modele
        JOIN Utilisateur u ON au.Idutilisateur = u.Idutilisateur
        JOIN Annoncefavoris af ON af.Id_Annonceutilisateur = au.Id_Annonceutilisateur;


CREATE VIEW V_HistoriqueAchat AS
SELECT
    au.Id_Annonceutilisateur,
    au.matricule,
    au.dateannonce,
    au.kilometrage,
    au.annee,
    au.moteur,
    au.description,
    au.prix,
    au.status,
    m.modele AS nom_modele,
    mq.Id_Marque AS id_marque,
    mq.nom AS nom_marque,
    u.Idutilisateur AS Idutilisateur,
    u.prenom AS prenom_utilisateur,
    u.nom AS nom_utilisateur,
    u.telephone,
    ht.dateachat as dateachat,
    ht.prixachat as prixachat,
    ht.Id_Utilisateur as Idacheteur,
    ca.commissionAnnonce as pourcentage_commission,
    ((ht.prixachat*ca.commissionAnnonce)/100) as commission,
    EXTRACT(YEAR FROM dateannonce) AS annee_extraction,
    EXTRACT(MONTH FROM dateannonce) AS mois
FROM
    Annonceutilisateur au
        JOIN Region r ON au.Id_Region = r.Id_Region
        JOIN Volant v ON au.Id_Volant = v.Id_Volant
        JOIN Couleur c ON au.Id_Couleur = c.Id_Couleur
        JOIN Carburant carb ON au.Id_Carburant = carb.Id_Carburant
        JOIN Transmission t ON au.Id_Transmission = t.Id_Transmission
        JOIN Modele m ON au.Id_Modele = m.Id_Modele
        JOIN Marque mq ON mq.Id_Marque = m.Id_Marque
        JOIN Utilisateur u ON au.Idutilisateur = u.Idutilisateur
        JOIN CommissionAnnonce ca ON ca.Id_Annonceutilisateur = au.Id_Annonceutilisateur
        JOIN Historiqueachat ht ON ht.Id_Annonceutilisateur = au.Id_Annonceutilisateur;

create or replace view V_Marqueplusvendu as
select id_marque,nom_marque,count(id_marque) as quantitevendu,sum(prixachat) as TotalPirx,sum(commission) as commission,annee_extraction,mois
from V_HistoriqueAchat
group by id_marque,nom_marque,annee_extraction,mois;

CREATE OR REPLACE VIEW V_Typevoiturevendu AS
SELECT id_typevoiture,
       typevoiture,
       quantitevendu,
       pourcentage_vente
FROM (
         SELECT id_typevoiture,
                typevoiture,
                SUM(id_marque) AS quantitevendu,
                (SUM(id_marque) * 100.0 / SUM(SUM(id_marque)) OVER ()) AS pourcentage_vente,
                ROW_NUMBER() OVER (ORDER BY SUM(id_marque) DESC) AS row_num
         FROM V_AnnonceUtilisateur
         GROUP BY id_typevoiture, typevoiture
     ) AS subquery
WHERE row_num <= 2
UNION ALL
SELECT NULL AS id_typevoiture,
       'Autres' AS typevoiture,
       SUM(quantitevendu) AS quantitevendu,
       SUM(pourcentage_vente) AS pourcentage_vente
FROM (
         SELECT SUM(id_marque) AS quantitevendu,
                (SUM(id_marque) * 100.0 / SUM(SUM(id_marque)) OVER ()) AS pourcentage_vente,
                ROW_NUMBER() OVER (ORDER BY SUM(id_marque) DESC) AS row_num
         FROM V_AnnonceUtilisateur
         GROUP BY id_typevoiture, typevoiture
     ) AS subquery
WHERE row_num > 2;

CREATE OR REPLACE VIEW V_NbVenteCommission as
SELECT
    m.idmois,
    m.mois,
    COALESCE(COUNT(h.id_annonceutilisateur), 0) as nbvente,
    COALESCE(SUM(h.commission), 0) as commission,
    extract(YEAR FROM current_date) as annee
FROM
    mois m
        LEFT JOIN
    V_HistoriqueAchat h ON m.idmois = h.mois
GROUP BY
    m.idmois, m.mois, extract(YEAR FROM current_date)
ORDER BY
    m.idmois;

CREATE OR REPLACE VIEW V_NbAnnnonce AS
SELECT
    m.idmois,
    m.mois,
    COUNT(a.Id_Annonceutilisateur) as nombre_annonce,
    EXTRACT(YEAR FROM current_date) as annee
FROM
    mois m
        LEFT JOIN
    V_AnnonceUtilisateur a ON m.idmois = EXTRACT(MONTH FROM a.dateannonce)
        AND EXTRACT(YEAR FROM a.dateannonce) = EXTRACT(YEAR FROM current_date)
GROUP BY
    m.idmois, m.mois
ORDER BY
    m.idmois;

CREATE OR REPLACE VIEW V_NbVenteCommissionNbAnnnonce AS
SELECT
    V1.idmois,
    V1.mois,
    V1.nbvente,
    V1.commission,
    V2.nombre_annonce
FROM
    V_NbVenteCommission V1
        LEFT JOIN
    V_NbAnnnonce V2 ON V1.idmois = V2.idmois
ORDER BY
    V1.idmois;

create or replace view bestvendeurdto as
select Idutilisateur,nom_utilisateur,prenom_utilisateur,telephone,count(id_annonceutilisateur) as nbvente,sum(commission) as chiffre_daffaire
from V_HistoriqueAchat
group by Idutilisateur,nom_utilisateur,prenom_utilisateur,telephone order by count(id_annonceutilisateur) desc limit 3


select * from V_AnnonceUtilisateur where status=1  and ( id_modele is not null or id_modele=?) and (Id_Couleur is not null or Id_Couleur=?) and (anne is not not null or annne = ?) and (id_typevoiture is not null or id_typevoiture=?) and (id_marque is not null or id_marque=?) and ((prix is not null) or prix <? and prix >? )



status=0 annonce tsy valide
      =1 annonce valide fa tsy nisy nividy
      =2 valide nisy nividy