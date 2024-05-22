CREATE TABLE Stadium (
    Id SERIAL PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    "location" VARCHAR(255) NOT NULL
);

INSERT INTO Stadium ("name", "location") VALUES ('Allianz Arena', 'Munich, Bavaria, Germany');
INSERT INTO Stadium ("name", "location") VALUES ('Signal Iduna Park', 'Dortmund, North Rhine-Westphalia, Germany');
INSERT INTO Stadium ("name", "location") VALUES ('BayArena', 'Leverkusen, North Rhine-Westphalia, Germany');

CREATE TABLE Club (
    Id SERIAL PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    StadiumId INT REFERENCES Stadium,
    FoundedYear INT
);

INSERT INTO Club ("name", StadiumId, FoundedYear) VALUES ('FC Bayern Munich', 1, 1900);
INSERT INTO Club ("name", StadiumId, FoundedYear) VALUES ('Borussia Dortmund', 2, 1909);
INSERT INTO Club ("name", StadiumId, FoundedYear) VALUES ('Bayer 04 Leverkusen', 3, 1904);

CREATE TABLE Player (
    Id SERIAL PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    ClubId INT REFERENCES Club,
    Nationality VARCHAR(255)
);

INSERT INTO Player (FirstName, LastName, ClubId, Nationality) VALUES ('Florian', 'Wirtz', 3, 'German');
INSERT INTO Player (FirstName, LastName, ClubId, Nationality) VALUES ('Patrik', 'Schick', 3, 'Czech');

INSERT INTO Player (FirstName, LastName, ClubId, Nationality) VALUES ('Marco', 'Reus', 2, 'German');
INSERT INTO Player (FirstName, LastName, ClubId, Nationality) VALUES ('Marcel', 'Sabitzer', 2, 'Austrian');

INSERT INTO Player (FirstName, LastName, ClubId, Nationality) VALUES ('Harry', 'Kane', 1, 'English');
INSERT INTO Player (FirstName, LastName, ClubId, Nationality) VALUES ('Matthijs', 'de Ligt', 1, 'Dutch');