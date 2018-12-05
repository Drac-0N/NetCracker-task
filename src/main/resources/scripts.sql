CREATE TABLE public.Group
(
    ID_Group SERIAL PRIMARY KEY NOT NULL,
    Name VARCHAR(255),
    Faculty VARCHAR(255)
);
COMMENT ON TABLE public.Groups IS 'Таблица с группами';

CREATE TABLE public.Disciplines
(
    ID_Discipline SERIAL PRIMARY KEY NOT NULL,
    Discipline VARCHAR(255)
);
COMMENT ON TABLE public.Disciplines IS 'таблица предметов';

CREATE TABLE public.Discipline_Group
(
    ID int PRIMARY KEY NOT NULL,
    ID_Discipline int NOT NULL,
    ID_Group int NOT NULL
);
COMMENT ON TABLE public.Disciplines IS 'таблица связи предмета с группой';

ALTER TABLE public.Discipline_Group ADD CONSTRAINT Group_id_constraint UNIQUE (ID_Group);
ALTER TABLE public.Discipline_Group ADD CONSTRAINT Discipline_id_constraint UNIQUE (ID_Discipline);

ALTER TABLE Groups
    ADD CONSTRAINT gr_id_fk_constraint
FOREIGN KEY (ID_Group) REFERENCES Discipline_Group (ID_Group)
ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE Disciplines
    ADD CONSTRAINT dis_id_fk_constraint
FOREIGN KEY (ID_Discipline) REFERENCES Discipline_Group (ID_Discipline)
ON UPDATE CASCADE ON DELETE CASCADE;