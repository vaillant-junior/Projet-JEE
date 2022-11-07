-- SEARCH PATH

SET search_path TO projet;

-- Supprime toutes les données
DELETE FROM Enchere;
DELETE FROM Mouvement;
DELETE FROM Produit;
DELETE FROM Role;
DELETE FROM Compte;

INSERT INTO Compte(IdCompte, Pseudo, Nom, Prenom, Email, MotDePasse, Credit) VALUES
    (1, 'Okarner', 'YOUMBISSI', 'Junior', 'youmbisv@3il.fr', 'Test12345@', 20),
    (2, 'Asmita33', 'TCHOMTE', 'Ivan', 'tchomtei@3il.fr', 'Test12345@', 22),
    (3, 'Misspermis', 'NGADJUI', 'Elizabeth', 'ngadjuie@3il.fr', 'Test12345@', 15),
    (4, 'youms', 'FOPPA', 'Sabine', 'njuines@3il.fr', 'Test12345@', 0);

ALTER TABLE Compte ALTER COLUMN IdCompte RESTART WITH 5;

INSERT INTO Role(IdCompte, Libelle) VALUES
    (1, 'GESTIONNAIRE'),
    (1, 'USAGER'),
    (2, 'USAGER'),
    (3, 'USAGER'),
    (4, 'USAGER');

INSERT INTO Produit(IdProduit, Nom, Description, Photo, PrixMinimal, DebutEnchere, FinEnchere, Cloturee, IdAcheteur, IdVendeur) VALUES
    (1, 'Balle de basket', 'Balle de basket signé par MJ en 2003', 'photo_1.jpg', 30, '2022-09-30 14:30:00', '2022-11-01 15:00:00', FALSE, 2, 1),
    (2, 'Peugeot 505', 'Voiture de collection du début des années 2000, 350000km au compteur', 'photo_2.jpg', 799.99, '2020-03-05 10:00:00', '2020-06-30 00:00:00', TRUE, 3, 4),
    (3, 'Miroir dantiquité', 'Utilisé par Picasso lors de ses oeuvres pour faire des autoportraits', 'photo_3.jpg', 150, '2022-09-30 08:00:00', '2022-10-05 08:00:00', TRUE, NULL, 3),
    (4, 'Chemise de Duala Manga Bell', 'Chemise portée par Rudolph Duala Manga Bell avant sa mort', 'photo_4.jpg', 44.99, '2019-01-05 10:00:00', '2020-01-10 10:00:00', TRUE, 3, 2);

ALTER TABLE Produit ALTER COLUMN IdProduit RESTART WITH 5;

INSERT INTO Enchere(IdEnchere, IdProduit, Montant) VALUES
    (1, 1, 40),
    (2, 1, 60),
    (3, 1, 100),
    (4, 2, 900),
    (5, 2, 1000),
    (8, 4, 45);

ALTER TABLE Enchere ALTER COLUMN IdEnchere RESTART WITH 9;

INSERT INTO Mouvement(IdMouvement, IdCompte, TypeMouvement, Montant, DateMouvement) VALUES
    (1, 1, 'V', 200, '2022-09-30 14:00:00'),
    (2, 1, 'R', 130, '2022-10-01 00:03:25'),
    (3, 2, 'V', 50, '2021-01-03 02:56:21'),
    (4, 2, 'R', 60, '2021-04-04 13:25:54'),
    (5, 3, 'V', 800, '2021-09-25 23:54:42'),
    (6, 3, 'R', 200.23, '2021-10-10 09:54:12'),
    (7, 4, 'V', 200, '2021-01-25 23:54:42'),
    (8, 4, 'R', 100.25, '2021-04-10 09:54:12');

ALTER TABLE Mouvement ALTER COLUMN IdMouvement RESTART WITH 9;