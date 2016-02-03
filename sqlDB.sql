
CREATE TABLE `Nations`
 (
  `Nation_id`       int          NOT NULL AUTO_INCREMENT,
  `Nation_name`     VARCHAR(30)  NOT NULL,
  `Nation_picture`  VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Nation_id`)
);

CREATE TABLE `Leagues`
 (
  `League_id`       int          NOT NULL AUTO_INCREMENT,
  `League_name`     VARCHAR(30)  NOT NULL,
  `League_picture`  VARCHAR(100) NOT NULL,
  PRIMARY KEY (`League_id`)
);

CREATE TABLE `Clubs`
 (
  `Club_id`             int          NOT NULL AUTO_INCREMENT,
  `Club_league_id`      int          NOT NULL,
  `Club_name`           VARCHAR(30)  NOT NULL,
  `Club_picture`        VARCHAR(100) NOT NULL,
  PRIMARY KEY (`club_id`)
);
ALTER TABLE Clubs ADD FOREIGN KEY (Club_league_id) REFERENCES Leagues (League_id);

CREATE TABLE `Users`
 (
  `User_id`         int          NOT NULL AUTO_INCREMENT,
  `User_username`   VARCHAR(30)  NOT NULL,
  `User_password`   CHAR(32)  NOT NULL,
  `User_type`       int          NOT NULL DEFAULT '2',
  PRIMARY KEY (`User_id`),
  UNIQUE KEY `User_username` ( `User_username` )
);

CREATE TABLE `Players`
 (
  `player_id`          int          NOT NULL AUTO_INCREMENT,
  `Player_nation_id`   int          NOT NULL,
  `Player_club_id`     int          ,
  `Player_name`        VARCHAR(30)  NOT NULL,
  `Player_birthday`    DATE         ,
  `Player_picture`     VARCHAR(100) ,
  `Player_position`    VARCHAR(30)  ,
  `Player_height`      int          ,
  `Player_number`      int          ,
  `Player_foot` enum('Left','Right','Both') NOT NULL,
  PRIMARY KEY (`Player_id`)
);
ALTER TABLE Players ADD FOREIGN KEY (Player_nation_id) REFERENCES Nations (Nation_id);
ALTER TABLE Players ADD FOREIGN KEY (Player_club_id)   REFERENCES Clubs   (Club_id);

CREATE TABLE `Comments`
 (
  `Comment_id`           int          NOT NULL AUTO_INCREMENT,
  `Comment_user_id`      int          NOT NULL,
  `Comment_player_id`    int          NOT NULL,
  `Comment_txt`          TEXT         NOT NULL,
  `Comment_date`         DATE         NOT NULL,
  PRIMARY KEY (`Comment_id`)
);
ALTER TABLE Comments ADD FOREIGN KEY (Comment_user_id)    REFERENCES Users   (User_id);
ALTER TABLE Comments ADD FOREIGN KEY (Comment_player_id)  REFERENCES Players (Player_id);