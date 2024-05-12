INSERT INTO majors (id, name, description) VALUES (1, 'Ingéniérie du Numérique', 'Ouaiiis du code partout');
INSERT INTO majors (id, name, description) VALUES (2, 'Structure & Matériaux', 'Beaucoup de béton et des poutres (snif elle a été renomée)');
INSERT INTO majors (id, name, description) VALUES (3, 'Aéronautique & Espace', 'Vive le vent');
INSERT INTO majors (id, name, description) VALUES (4, 'Data Engineering', 'Trop cool plein de données à ordonner');
INSERT INTO majors (id, name, description) VALUES (5, 'Energie & Environnement', 'On est full green');
INSERT INTO majors (id, name, description) VALUES (6, 'Engineering Management', 'Des managers de qualité');
INSERT INTO majors (id, name, description) VALUES (7, 'Ingénierie & Santé', 'On connait tous les os et tous les muscles du corps humain');
INSERT INTO majors (id, name, description) VALUES (8, 'Ingénierie & Architecture durable', 'Objectif 0 carbon');

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
INSERT INTO questions (question, reponse) VALUES
                                              ('Quel est la capitale de la France ?', 'Paris'),
                                              ('Quel est le plus grand océan du monde ?', 'Océan Pacifique'),
                                              ('Qui a peint La Joconde ?', 'Leonardo da Vinci'),
                                              ('Quel est l''élément chimique avec le symbole H ?', 'Hydrogène'),
                                              ('Quel est le plus grand désert du monde ?', 'Antarctique'),
                                              ('Combien de continents y a-t-il sur la Terre ?', '7'),
                                              ('Quelle est la devise de l''Union européenne ?', 'Unie dans la diversité'),
                                              ('Qui a écrit ''Romeo et Juliette'' ?', 'William Shakespeare'),
                                              ('Quel est le plus grand mammifère terrestre ?', 'Éléphant'),
                                              ('Qui a inventé la théorie de la relativité ?', 'Albert Einstein'),
                                              ('Quel est le plus haut sommet du monde ?', 'Mont Everest'),
                                              ('Qui a composé la 9ème symphonie ?', 'Ludwig van Beethoven'),
                                              ('Quel est le plus long fleuve du monde ?', 'Fleuve Nil'),
                                              ('Qui a fondé Microsoft ?', 'Bill Gates'),
                                              ('Quel est le plus grand pays du monde en superficie ?', 'Russie'),
                                              ('Quel est l''élément chimique avec le symbole Au ?', 'Or'),
                                              ('Quel est le plus grand lac du monde en superficie ?', 'Mer Caspienne'),
                                              ('Qui a peint ''Les Tournesols'' ?', 'Vincent van Gogh'),
                                              ('Quelle est la plus grande planète du système solaire ?', 'Jupiter'),
                                              ('Qui a écrit ''Le Petit Prince'' ?', 'Antoine de Saint-Exupéry');

INSERT INTO quizz (titre, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, image)
VALUES ('Mon super quizz', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null);
INSERT INTO quizz (titre, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10,image)
VALUES ('Autre quizz', 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, null);

 CREATE SEQUENCE ma_secance;
 ALTER SEQUENCE ma_secance RESTART 10000 increment by 50;