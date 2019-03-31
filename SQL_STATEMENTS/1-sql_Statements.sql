create database feedback;
use feedback;

CREATE USER sqluser IDENTIFIED BY 'sqluserpw';

#grant usage on *.* to sqluser@localhost identified by 'sqluserpw';
#grant all privileges on feedback.* to sqluser@localhost;


CREATE TABLE comments (
        id INT NOT NULL AUTO_INCREMENT,
        MYUSER VARCHAR(30) NOT NULL,
        EMAIL VARCHAR(30),
        WEBPAGE VARCHAR(100) NOT NULL,
        DATUM DATE NOT NULL,
        SUMMARY VARCHAR(40) NOT NULL,
        COMMENTS VARCHAR(400) NOT NULL,
        PRIMARY KEY (ID)
    );

INSERT INTO comments values (default, 'bruce_wayne', 'bruce@wayneinc.com','https://www.wayneinc.com/', '2019-04-01 10:33:11', 'Resumen','Mi primer comentario' );