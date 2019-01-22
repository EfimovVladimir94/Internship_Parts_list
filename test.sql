USE test;

DROP TABLE IF EXISTS part;
CREATE TABLE part
(
  ID     INT                  NOT NULL AUTO_INCREMENT,
  PARTS   VARCHAR(100)         NOT NULL,
  NEED TINYINT(1) DEFAULT 0 NOT NULL,
  QUANTITY INT(4)               NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO part (PARTS, NEED, QUANTITY)
VALUES
           ('какая-то ... навязанная разрабом', 1, 14),
           ('материнская плата', 1, 2),
           ('блок питания', 1, 3),
           ('клавиатура', 0, 4),
           ('оперативная память', 1, 4),
           ('звуковая карта', 0, 7),
           ('mouse', 0, 9),
           ('card reader', 0, 4),
           ('моник', 0, 6),
           ('подсветка корпуса', 0, 4),
           ('CD привод', 0, 7),
           ('коробка', 1, 3),
           ('DVD привод', 0, 1),
           ('TV тюнер', 0, 8),
           ('куллер', 1, 5),
           ('видеокарта', 0, 3),
           ('blu-ray привод', 0, 2),
           ('джойстик', 0, 6),
           ('балон с сжатым воздухом', 0, 6),
           ('коврик', 0, 4),
           ('процессор', 1, 4),
           ('геймпад', 0, 1);