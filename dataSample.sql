DELETE FROM players;
DELETE FROM nations;
DELETE FROM clubs;
DELETE FROM leagues;

ALTER TABLE players AUTO_INCREMENT = 1;
ALTER TABLE nations AUTO_INCREMENT = 1;
ALTER TABLE clubs AUTO_INCREMENT = 1;
ALTER TABLE leagues AUTO_INCREMENT = 1;

INSERT INTO leagues (`League_name`, `League_picture`) VALUES ('Barclays PL', 'Barclays-PL.png');
INSERT INTO leagues (`League_name`, `League_picture`) VALUES ('Liga BBVA', 'Liga-BBVA.png');
INSERT INTO leagues (`League_name`, `League_picture`) VALUES ('Serie A', 'Serie-A.png');
INSERT INTO leagues (`League_name`, `League_picture`) VALUES ('Bundesliga', 'Bundesliga.png');



INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('Spain', 'Spain.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('Brazil', 'Brazil.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('France', 'France.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('Argentina', 'Argentina.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('Germany', 'Germany.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('Italy', 'Italy.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('England', 'England.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('Portugal', 'Portugal.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('Netherlands', 'Netherlands.png');
INSERT INTO nations (`Nation_name`, `Nation_picture`) VALUES ('Belgium', 'Belgium.png');



INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (1, 'Chelsea', 'Chelsea.png');
INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (1, 'Manchester City', 'Manchester-City.png');
INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (1, 'Arsenal', 'Arsenal.png');

INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (2, 'Real Madrid', 'Real-Madrid.png');
INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (2, 'FC Barcelona', 'FC-Barcelona.png');
INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (2, 'Atlético Madrid', 'Atlético-Madrid.png');

INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (3, 'Juventus', 'Juventus.png');
INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (3, 'Napoli', 'Napoli.png');
INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (3, 'Roma', 'Roma.png');

INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (4, 'FC Bayern', 'FC-Bayern.png');
INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (4, 'Borussia Dortmund', 'Borussia-Dortmund.png');
INSERT INTO clubs (`Club_league_id`, `Club_name`, `Club_picture`) VALUES (4, 'VfL Wolfsburg', 'VfL-Wolfsburg.png');



INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (10, 1, 'Eden Hazard', '2016-02-08', 'Eden-Hazard.png', 'Attacker', 173, 10, 'Right');
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (4, 2, 'Sergio Agüero', '2016-02-08', 'Sergio-Agüero.png', 'Attacker', 172, 12, 'Right');
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (1, 2, 'David Silva', '2016-02-08', 'David-Silva.png', 'Midfielder', 170, 16, 'Left');
	
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (4, 5, 'Lionel Messi', '2016-02-08', 'Lionel-Messi.png', 'Attacker', 170, 10, 'Left');
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (8, 4, 'Cristiano Ronaldo', '2016-02-08', 'Cristiano-Ronaldo.png', 'Attacker', 185, 7, 'Right');
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (2, 5, 'Neymar', '2016-02-08', 'Neymar.png', 'Attacker', 174, 11, 'Both');
	
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (3, 7, 'Paul Pogba', '2016-02-08', 'Paul-Pogba.png', 'Midfielder', 188, 10, 'Right');
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (8, 7, 'Giorgio Chiellini', '2016-02-08', 'Giorgio-Chiellini.png', 'Defender', 186, 3, 'Left');
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (6, 8, 'Gonzalo Higuaín', '2016-02-08', 'Gonzalo-Higuaín.png', 'Attacker', 184, 9, 'Right');
	
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (9, 10, 'Arjen Robben', '2016-02-08', 'Arjen-Robben.png', 'Attacker', 180, 11, 'Left');
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (5, 10, 'Philipp Lahm', '2016-02-08', 'Philipp-Lahm.png', 'Defender', 170, 2, 'Right');
INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`) 
	VALUES (3, 10, 'Franck Ribéry', '2016-02-08', 'Franck-Ribéry.png', 'Attacker', 170, 7, 'Left');