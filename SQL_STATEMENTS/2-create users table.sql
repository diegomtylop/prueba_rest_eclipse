use feedback;


CREATE TABLE usuarios (
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(30) NOT NULL,
        profession VARCHAR(30),
        PRIMARY KEY (ID)
    );

INSERT INTO usuarios values (default, 'Carol Denvers', 'Píloto' );
INSERT INTO usuarios values (default, 'Clark Kent', 'Periodista' );
INSERT INTO usuarios values (default, 'Peter Parker', 'Periodista' );
INSERT INTO usuarios values (default, 'Bruce Wayne', 'Empresario' );
INSERT INTO usuarios values (default, 'Tony Stark', 'Empresario' );
INSERT INTO usuarios values (default, 'Natasha romanoff', 'Asistente' );

