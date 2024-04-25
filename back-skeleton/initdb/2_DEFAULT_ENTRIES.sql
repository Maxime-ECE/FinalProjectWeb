INSERT INTO majors (id, name, description) VALUES (1, 'Ingéniérie du Numérique', 'Ouaiiis du code partout');
INSERT INTO majors (id, name, description) VALUES (2, 'Structure & Matériaux', 'Beaucoup de béton et des poutres (snif elle a été renomée)');
INSERT INTO majors (id, name, description) VALUES (3, 'Aéronautique & Espace', 'Vive le vent');
INSERT INTO majors (id, name, description) VALUES (4, 'Data Engineering', 'Trop cool plein de données à ordonner');
INSERT INTO majors (id, name, description) VALUES (5, 'Energie & Environnement', 'On est full green');
INSERT INTO majors (id, name, description) VALUES (6, 'Engineering Management', 'Des managers de qualité');
INSERT INTO majors (id, name, description) VALUES (7, 'Ingénierie & Santé', 'On connait tous les os et tous les muscles du corps humain');
INSERT INTO majors (id, name, description) VALUES (8, 'Ingénierie & Architecture durable', 'Objectif 0 carbon');
INSERT INTO majors (id, name, description) VALUES (9, 'Design Industriel Durable', 'Ca existait pas pour la P2022 ça');

INSERT INTO students (id, first_name, last_name, birthdate, major_id) VALUES (1, 'Paul', 'Harrohide', '2002-06-15', 1);
INSERT INTO students (id, first_name, last_name, birthdate, major_id) VALUES (2, 'Jean', 'Bonbeur', '2001-08-21', 1);
INSERT INTO students (id, first_name, last_name, birthdate, major_id) VALUES (3, 'Alain', 'Térieur', '2000-01-11', 1);

INSERT INTO courses (id, name, hours) VALUES (1, 'Spanish', 30);
INSERT INTO courses (id, name, hours) VALUES (2, 'German', 30);
INSERT INTO courses (id, name, hours) VALUES (3, 'Internet of Things', 30);
INSERT INTO courses (id, name, hours) VALUES (4, 'Thermodynamic', 30);
INSERT INTO courses (id, name, hours) VALUES (5, 'Anatomy', 30);
INSERT INTO courses (id, name, hours) VALUES (6, 'Maths', 30);
INSERT INTO courses (id, name, hours) VALUES (7, 'Java', 30);
INSERT INTO courses (id, name, hours) VALUES (8, 'Lean Management', 30);
INSERT INTO student_course (id, student_id, course_id) VALUES (1, 1, 7);


INSERT INTO users (id, nom, roles, prenom, email, password_mdp, score) VALUES (1, 'Java', 'autist','remy',' etst@test','password',0);
INSERT INTO questions (id,question, reponse, choices, hint)
VALUES
    (1, 'Quelle est la capitale de la France?', 'Paris', 'Londres,Paris,Berlin,Madrid', 'Célèbre pour la Tour Eiffel'),
    (2, 'Qui a écrit "Roméo et Juliette"?', 'William Shakespeare', 'Jane Austen,Charles Dickens,William Shakespeare,Léon Tolstoï', 'Un célèbre dramaturge'),
    (3, 'Quel est l''organe producteur d''énergie de la cellule?', 'Mitochondrie', 'Noyau,Mitochondrie,Appareil de Golgi,Lysosome', 'Produit de l''ATP'),
    (4, 'En quelle année la Seconde Guerre mondiale a-t-elle pris fin?', '1945', '1918,1939,1945,1955', 'L''année des bombardements atomiques'),
    (5, 'Quel est le symbole chimique de l''eau?', 'H2O', 'HO,H2O,CO2,CH4', 'Une molécule composée de deux atomes d''hydrogène et d''un atome d''oxygène'),
    (6, 'Qui a peint la Joconde?', 'Léonard de Vinci', 'Vincent van Gogh,Pablo Picasso,Léonard de Vinci,Claude Monet', 'Un polymathe italien'),
    (7, 'Quelle est la plus grande planète de notre système solaire?', 'Jupiter', 'Mars,Vénus,Saturne,Jupiter', 'Possède un point rouge proéminent'),
    (8, 'Quelle est la racine carrée de 64?', '8', '6,8,10,12', 'Un carré parfait'),
    (9, 'Qui a développé la théorie de la relativité?', 'Albert Einstein', 'Isaac Newton,Nikola Tesla,Albert Einstein,Stephen Hawking', 'Équation célèbre : E=mc^2'),
    (10, 'Quelle est la formule chimique du sel de table?', 'NaCl', 'KCl,NaCl,NaHCO3,Na2CO3', 'Communément utilisé en cuisine'),
    (11, 'Quelle planète est connue sous le nom de la Planète Rouge?', 'Mars', 'Vénus,Terre,Mars,Jupiter', 'Nom donné d''après le dieu romain de la guerre'),
    (12, 'Qui est considéré comme le "Père de l''Informatique"?', 'Charles Babbage', 'Alan Turing,Ada Lovelace,John von Neumann,Charles Babbage', 'Conçu la Machine Analytique'),
    (13, 'Quel est le mammifère le plus grand?', 'Girafe', 'Éléphant,Girafe,Hippopotame,Rhinocéros', 'Possède un long cou et de longues jambes'),
    (14, 'Quel est le symbole chimique de l''or?', 'Au', 'Ag,Au,Fe,Cu', 'Très apprécié et utilisé en bijouterie'),
    (15, 'Quel élément a le numéro atomique 1?', 'Hydrogène', 'Oxygène,Hydrogène,Carbone,Azote', 'L''élément le plus léger'),
    (16, 'Qui a été la première personne à marcher sur la lune?', 'Neil Armstrong', 'Buzz Aldrin,Michael Collins,Neil Armstrong,Youri Gagarine', 'Célèbre citation : "C''est un petit pas pour [un] homme, mais un bond de géant pour l''humanité."'),
    (17, 'Quel est le plus grand océan sur Terre?', 'Océan Pacifique', 'Océan Atlantique,Océan Indien,Océan Arctique,Océan Pacifique', 'Couvre plus de surface que tous les continents réunis'),
    (18, 'Qui a peint le plafond de la Chapelle Sixtine?', 'Michel-Ange', 'Léonard de Vinci,Raphaël,Donatello,Michel-Ange', 'A créé des fresques célèbres'),
    (19, 'Quel est le symbole chimique du dioxyde de carbone?', 'CO2', 'CO,CO2,O2,N2', 'Produit lors de la respiration et de la combustion'),
    (20, 'Qui a été la première femme à remporter un prix Nobel?', 'Marie Curie', 'Rosalind Franklin,Marie Curie,Dorothy Crowfoot Hodgkin,Gerty Cori', 'Récompensée pour la physique en 1903 et la chimie en 1911');

INSERT INTO quizz (titre, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10,image)
VALUES ('Mon super quizz', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null);
INSERT INTO quizz (titre, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, image)
VALUES ('Autre quizz', 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, null);

 CREATE SEQUENCE ma_secance;
 ALTER SEQUENCE ma_secance RESTART 10000 increment by 50;