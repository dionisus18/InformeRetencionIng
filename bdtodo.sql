--
-- File generated with SQLiteStudio v3.1.1 on jue. jun. 28 00:52:01 2018
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Area
DROP TABLE IF EXISTS Area;

CREATE TABLE Area (
    idArea INTEGER      PRIMARY KEY AUTOINCREMENT
                        NOT NULL,
    Nombre VARCHAR (45) NOT NULL
                        UNIQUE
);

INSERT INTO Area (
                     idArea,
                     Nombre
                 )
                 VALUES (
                     1,
                     'pepapig'
                 );

INSERT INTO Area (
                     idArea,
                     Nombre
                 )
                 VALUES (
                     2,
                     'PEPAPIG'
                 );

INSERT INTO Area (
                     idArea,
                     Nombre
                 )
                 VALUES (
                     3,
                     'INFORMÁTICA Y TELEFECOMUNICACIONES'
                 );


-- Table: Asignatura
DROP TABLE IF EXISTS Asignatura;

CREATE TABLE Asignatura (
    idAsignatura INT          NOT NULL,
    Codigo       VARCHAR (45),
    PRIMARY KEY (
        idAsignatura
    )
);


-- Table: Carrera
DROP TABLE IF EXISTS Carrera;

CREATE TABLE Carrera (
    idCarrera   INTEGER       PRIMARY KEY AUTOINCREMENT
                              NOT NULL,
    nombre      VARCHAR (255) NOT NULL,
    codigo      VARCHAR (255) NOT NULL,
    Area_idArea INTEGER       NOT NULL,
    CONSTRAINT codigo_unico UNIQUE (
        codigo
    ),
    FOREIGN KEY (
        Area_idArea
    )
    REFERENCES Area (idArea) ON DELETE NO ACTION
                             ON UPDATE CASCADE
);

INSERT INTO Carrera (
                        idCarrera,
                        nombre,
                        codigo,
                        Area_idArea
                    )
                    VALUES (
                        1,
                        'Ingeniería en Informática',
                        'T60-60',
                        1
                    );


-- Table: Carreras_Sede
DROP TABLE IF EXISTS Carreras_Sede;

CREATE TABLE Carreras_Sede (
    idCarreras_Sede   INTEGER PRIMARY KEY AUTOINCREMENT
                              NOT NULL,
    Sede_idSede       INTEGER NOT NULL,
    Carrera_idCarrera INTEGER NOT NULL,
    CONSTRAINT fk_Carreras_Sede_Sede1 FOREIGN KEY (
        Sede_idSede
    )
    REFERENCES Sede (idSede) ON DELETE NO ACTION
                             ON UPDATE NO ACTION,
    CONSTRAINT fk_Carreras_Sede_Carrera1 FOREIGN KEY (
        Carrera_idCarrera
    )
    REFERENCES Carrera (idCarrera) ON DELETE NO ACTION
                                   ON UPDATE CASCADE
);

INSERT INTO Carreras_Sede (
                              idCarreras_Sede,
                              Sede_idSede,
                              Carrera_idCarrera
                          )
                          VALUES (
                              1,
                              4,
                              1
                          );


-- Table: Carreras_Tipo_Sede
DROP TABLE IF EXISTS Carreras_Tipo_Sede;

CREATE TABLE Carreras_Tipo_Sede (
    idCarreras_Tipo_Sede      INTEGER PRIMARY KEY AUTOINCREMENT
                                      NOT NULL,
    Carrera_idCarrera         INTEGER NOT NULL,
    Institucion_idInstitucion INTEGER NOT NULL,
    CONSTRAINT fk_Carreras_Tipo_Sede_Carrera1 FOREIGN KEY (
        Carrera_idCarrera
    )
    REFERENCES Carrera (idCarrera) ON DELETE CASCADE
                                   ON UPDATE CASCADE,
    CONSTRAINT fk_Carreras_Tipo_Sede_Institucion1 FOREIGN KEY (
        Institucion_idInstitucion
    )
    REFERENCES Institucion (idInstitucion) ON DELETE CASCADE
                                           ON UPDATE CASCADE
);

INSERT INTO Carreras_Tipo_Sede (
                                   idCarreras_Tipo_Sede,
                                   Carrera_idCarrera,
                                   Institucion_idInstitucion
                               )
                               VALUES (
                                   1,
                                   1,
                                   1
                               );


-- Table: Comuna
DROP TABLE IF EXISTS Comuna;

CREATE TABLE Comuna (
    idComuna              SMALLINT      NOT NULL,
    Nombre                VARCHAR (255) NOT NULL,
    Provincia_idProvincia SMALLINT      NOT NULL,
    PRIMARY KEY (
        idComuna
    ),
    FOREIGN KEY (
        Provincia_idProvincia
    )
    REFERENCES Provincia (idProvincia) ON DELETE NO ACTION
                                       ON UPDATE CASCADE
);

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       1,
                       'Arica',
                       1
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       2,
                       'Camarones',
                       1
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       3,
                       'Putre',
                       2
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       4,
                       'General Lagos',
                       2
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       5,
                       'Iquique',
                       3
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       6,
                       'Alto Hospicio',
                       3
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       7,
                       'Pozo Almonte',
                       4
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       8,
                       'Camiña',
                       4
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       9,
                       'Colchane',
                       4
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       10,
                       'Huara',
                       4
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       11,
                       'Pica',
                       4
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       12,
                       'Antofagasta',
                       5
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       13,
                       'Mejillones',
                       5
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       14,
                       'Sierra Gorda',
                       5
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       15,
                       'Taltal',
                       5
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       16,
                       'Calama',
                       6
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       17,
                       'Ollagüe',
                       6
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       18,
                       'San Pedro de Atacama',
                       6
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       19,
                       'Tocopilla',
                       7
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       20,
                       'María Elena',
                       7
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       21,
                       'Copiapó',
                       8
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       22,
                       'Caldera',
                       8
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       23,
                       'Tierra Amarilla',
                       8
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       24,
                       'Chañaral',
                       9
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       25,
                       'Diego de Almagro',
                       9
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       26,
                       'Vallenar',
                       10
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       27,
                       'Alto del Carmen',
                       10
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       28,
                       'Freirina',
                       10
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       29,
                       'Huasco',
                       10
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       30,
                       'La Serena',
                       11
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       31,
                       'Coquimbo',
                       11
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       32,
                       'Andacollo',
                       11
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       33,
                       'La Higuera',
                       11
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       34,
                       'Paiguano',
                       11
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       35,
                       'Vicuña',
                       11
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       36,
                       'Illapel',
                       12
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       37,
                       'Canela',
                       12
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       38,
                       'Los Vilos',
                       12
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       39,
                       'Salamanca',
                       12
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       40,
                       'Ovalle',
                       13
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       41,
                       'Combarbalá',
                       13
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       42,
                       'Monte Patria',
                       13
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       43,
                       'Punitaqui',
                       13
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       44,
                       'Río Huertado',
                       13
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       45,
                       'Valparaíso',
                       14
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       46,
                       'Casablanca',
                       14
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       47,
                       'Concón',
                       14
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       48,
                       'Juan Fernández',
                       14
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       49,
                       'Puchuncaví',
                       14
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       50,
                       'Quintero',
                       14
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       51,
                       'Viña del Mar',
                       14
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       52,
                       'Isla de Pascua',
                       15
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       53,
                       'Los Andes',
                       16
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       54,
                       'Calle Larga',
                       16
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       55,
                       'Rinconada',
                       16
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       56,
                       'San Esteban',
                       16
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       57,
                       'La Ligua',
                       17
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       58,
                       'Cabildo',
                       17
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       59,
                       'Papudo',
                       17
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       60,
                       'Petorca',
                       17
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       61,
                       'Zapallar',
                       17
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       62,
                       'Quillota',
                       18
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       63,
                       'Calera',
                       18
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       64,
                       'Hijuelas',
                       18
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       65,
                       'La Cruz',
                       18
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       66,
                       'Nogales',
                       18
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       67,
                       'San Antonio',
                       19
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       68,
                       'Algarrobo',
                       19
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       69,
                       'Cartagena',
                       19
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       70,
                       'El Quisco',
                       19
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       71,
                       'El Tabo',
                       19
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       72,
                       'Santo Domingo',
                       19
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       73,
                       'San Felipe',
                       20
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       74,
                       'Catemu',
                       20
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       75,
                       'Llaillay',
                       20
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       76,
                       'Panquehue',
                       20
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       77,
                       'Putaendo',
                       20
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       78,
                       'Santa María',
                       20
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       79,
                       'Limache',
                       21
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       80,
                       'Quipue',
                       21
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       81,
                       'Villa Alemana',
                       21
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       82,
                       'Olmué',
                       21
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       83,
                       'Rancagua',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       84,
                       'Codegua',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       85,
                       'Coinco',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       86,
                       'Coltauco',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       87,
                       'Doñihue',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       88,
                       'Graneros',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       89,
                       'Las Cabras',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       90,
                       'Machalí',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       91,
                       'Malloa',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       92,
                       'Mostazal',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       93,
                       'Olivar',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       94,
                       'Peumo',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       95,
                       'Pichidegua',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       96,
                       'Quinta de Tilcoco',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       97,
                       'Rengo',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       98,
                       'Requínoa',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       99,
                       'San Vicente',
                       22
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       100,
                       'Pichilemu',
                       23
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       101,
                       'La Estrella',
                       23
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       102,
                       'Litueche',
                       23
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       103,
                       'Marchihue',
                       23
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       104,
                       'Navidad',
                       23
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       105,
                       'Paredones',
                       23
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       106,
                       'San Fernando',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       107,
                       'Chépica',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       108,
                       'Chimbarongo',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       109,
                       'Lolol',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       110,
                       'Nancagua',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       111,
                       'Palmilla',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       112,
                       'Peralillo',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       113,
                       'Placilla',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       114,
                       'Pumanque',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       115,
                       'Santa Cruz',
                       24
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       116,
                       'Talca',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       117,
                       'Constitución',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       118,
                       'Curepto',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       119,
                       'Empredado',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       120,
                       'Maule',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       121,
                       'Pelarco',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       122,
                       'Pencachue',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       123,
                       'Río Claro',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       124,
                       'San Clemente',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       125,
                       'San Rafael',
                       25
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       126,
                       'Cauquenes',
                       26
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       127,
                       'Chanco',
                       26
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       128,
                       'Pelluhue',
                       26
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       129,
                       'Curicó',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       130,
                       'Hualañe',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       131,
                       'Licantén',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       132,
                       'Molina',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       133,
                       'Rauco',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       134,
                       'Romeral',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       135,
                       'Sagrada Familia',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       136,
                       'Teno',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       137,
                       'Vichuquén',
                       27
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       138,
                       'Linares',
                       28
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       139,
                       'Colbún',
                       28
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       140,
                       'Longaví',
                       28
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       141,
                       'Parral',
                       28
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       142,
                       'Retiro',
                       28
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       143,
                       'San Javier',
                       28
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       144,
                       'Villa Alegre',
                       28
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       145,
                       'Yerbas Buenas',
                       28
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       146,
                       'Concepción',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       147,
                       'Coronel',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       148,
                       'Chiguayante',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       149,
                       'Florida',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       150,
                       'Hualqui',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       151,
                       'Lota',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       152,
                       'Penco',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       153,
                       'San Pedro de la Paz',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       154,
                       'Santa Juana',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       155,
                       'Talcahuano',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       156,
                       'Tomé',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       157,
                       'Hualpén',
                       29
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       158,
                       'Lebu',
                       30
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       159,
                       'Arauco',
                       30
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       160,
                       'Cañete',
                       30
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       161,
                       'Contulmo',
                       30
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       162,
                       'Curanilahue',
                       30
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       163,
                       'Los Alamos',
                       30
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       164,
                       'Tirúa',
                       30
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       165,
                       'Los Angeles',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       166,
                       'Antuco',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       167,
                       'Cabrero',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       168,
                       'Laja',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       169,
                       'Mulchén',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       170,
                       'Nacimiento',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       171,
                       'Negrete',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       172,
                       'Quilaco',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       173,
                       'Quilleco',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       174,
                       'San Rosendo',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       175,
                       'Santa Bárbara',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       176,
                       'Tucapel',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       177,
                       'Yumbel',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       178,
                       'Alto Biobío',
                       31
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       179,
                       'Chillán',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       180,
                       'Bulnes',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       181,
                       'Cobquecura',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       182,
                       'Coelemu',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       183,
                       'Coihueco',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       184,
                       'Chillán Viejo',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       185,
                       'El Carmen',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       186,
                       'Ninhue',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       187,
                       'Ñiquén',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       188,
                       'Pemuco',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       189,
                       'Pinto',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       190,
                       'Portezuelo',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       191,
                       'Quillón',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       192,
                       'Quirihue',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       193,
                       'Ránquil',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       194,
                       'San Carlos',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       195,
                       'San Fabián',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       196,
                       'San Ignacio',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       197,
                       'San Nicolás',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       198,
                       'Treguaco',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       199,
                       'Yungay',
                       32
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       200,
                       'Temuco',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       201,
                       'Carahue',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       202,
                       'Cunco',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       203,
                       'Curarrehue',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       204,
                       'Freire',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       205,
                       'Galvarino',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       206,
                       'Gorbea',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       207,
                       'Lautaro',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       208,
                       'Loncoche',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       209,
                       'Melipeuco',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       210,
                       'Nueva Imperial',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       211,
                       'Padre Las Casas',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       212,
                       'Perquenco',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       213,
                       'Pitrufquén',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       214,
                       'Pucón',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       215,
                       'Saavedra',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       216,
                       'Teodoro Schmidt',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       217,
                       'Toltén',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       218,
                       'Vilcún',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       219,
                       'Villarrica',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       220,
                       'Cholchol',
                       33
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       221,
                       'Angol',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       222,
                       'Collipulli',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       223,
                       'Curacautín',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       224,
                       'Ercilla',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       225,
                       'Lonquimay',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       226,
                       'Los Sauces',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       227,
                       'Lumaco',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       228,
                       'Purén',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       229,
                       'Renaico',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       230,
                       'Traiguén',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       231,
                       'Victoria',
                       34
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       232,
                       'Valdivia',
                       35
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       233,
                       'Corral',
                       35
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       234,
                       'Lanco',
                       35
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       235,
                       'Los Lagos',
                       35
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       236,
                       'Márfil',
                       35
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       237,
                       'Mariquina',
                       35
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       238,
                       'Paillaco',
                       35
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       239,
                       'Panguipulli',
                       35
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       240,
                       'La Unión',
                       36
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       241,
                       'Futrono',
                       36
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       242,
                       'Lago Ranco',
                       36
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       243,
                       'Río Bueno',
                       36
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       244,
                       'Puerto Montt',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       245,
                       'Calbuco',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       246,
                       'Cochamó',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       247,
                       'Fresia',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       248,
                       'Frutillar',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       249,
                       'Los Muermos',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       250,
                       'Llanquihue',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       251,
                       'Maullín',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       252,
                       'Puerto Varas',
                       37
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       253,
                       'Castro',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       254,
                       'Ancud',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       255,
                       'Chonchi',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       256,
                       'Curaco de Vélez',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       257,
                       'Dalcahue',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       258,
                       'Puqueldón',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       259,
                       'Queilén',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       260,
                       'Quellón',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       261,
                       'Quemchi',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       262,
                       'Quinchao',
                       38
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       263,
                       'Osorno',
                       39
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       264,
                       'Puerto Octay',
                       39
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       265,
                       'Purranque',
                       39
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       266,
                       'Puyehue',
                       39
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       267,
                       'Río Negro',
                       39
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       268,
                       'San Juan de la Costa',
                       39
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       269,
                       'San Pablo',
                       39
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       270,
                       'Chaitén',
                       40
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       271,
                       'Futaleufú',
                       40
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       272,
                       'Hualaihué',
                       40
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       273,
                       'Palena',
                       40
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       274,
                       'Coyhaique',
                       41
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       275,
                       'Lago Verde',
                       41
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       276,
                       'Aysén',
                       42
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       277,
                       'Cisnes',
                       42
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       278,
                       'Guaitecas',
                       42
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       279,
                       'Cochrane',
                       43
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       280,
                       'O''Higgins',
                       43
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       281,
                       'Tortel',
                       43
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       282,
                       'Chile Chico',
                       44
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       283,
                       'Río Ibáñez',
                       44
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       284,
                       'Punta Arenas',
                       45
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       285,
                       'Laguna Blanca',
                       45
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       286,
                       'Río Verde',
                       45
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       287,
                       'San Gregorio',
                       45
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       288,
                       'Cabo de Hornos (Ex-Navarino)',
                       46
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       289,
                       'Antártica',
                       46
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       290,
                       'Porvenir',
                       47
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       291,
                       'Primavera',
                       47
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       292,
                       'Timaukel',
                       47
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       293,
                       'Natales',
                       48
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       294,
                       'Torres del Paine',
                       48
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       295,
                       'Santiago',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       296,
                       'Cerrillos',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       297,
                       'Cerro Navia',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       298,
                       'Conchalí',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       299,
                       'El Bosque',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       300,
                       'Estación Central',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       301,
                       'Huechuraba',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       302,
                       'Independencia',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       303,
                       'La Cisterna',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       304,
                       'La Florida',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       305,
                       'La Granja',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       306,
                       'La Pintana',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       307,
                       'La Reina',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       308,
                       'Las Condes',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       309,
                       'Lo Barnechea',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       310,
                       'Lo Espejo',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       311,
                       'Lo Prado',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       312,
                       'Macul',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       313,
                       'Maipó',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       314,
                       'Ñuñoa',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       315,
                       'Pedro Aguirre Cerda',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       316,
                       'Peñalolén',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       317,
                       'Providencia',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       318,
                       'Pudahuel',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       319,
                       'Quilicura',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       320,
                       'Quinta Normal',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       321,
                       'Recoleta',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       322,
                       'Renca',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       323,
                       'San Joaquín',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       324,
                       'San Miguel',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       325,
                       'San Ramón',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       326,
                       'Vitacura',
                       49
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       327,
                       'Puente Alto',
                       50
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       328,
                       'Pirque',
                       50
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       329,
                       'San José de Maipo',
                       50
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       330,
                       'Colina',
                       51
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       331,
                       'Lampa',
                       51
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       332,
                       'Tiltil',
                       51
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       333,
                       'San Bernardo',
                       52
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       334,
                       'Buin',
                       52
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       335,
                       'Calera de Tango',
                       52
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       336,
                       'Paine',
                       52
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       337,
                       'Melipilla',
                       53
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       338,
                       'Alhué',
                       53
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       339,
                       'Curacaví',
                       53
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       340,
                       'María Pinto',
                       53
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       341,
                       'San Pedro',
                       53
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       342,
                       'Talagante',
                       54
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       343,
                       'El Monte',
                       54
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       344,
                       'Isla de Maipo',
                       54
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       345,
                       'Padre Hurtado',
                       54
                   );

INSERT INTO Comuna (
                       idComuna,
                       Nombre,
                       Provincia_idProvincia
                   )
                   VALUES (
                       346,
                       'Peñaflor',
                       54
                   );


-- Table: Institucion
DROP TABLE IF EXISTS Institucion;

CREATE TABLE Institucion (
    idInstitucion INTEGER       PRIMARY KEY AUTOINCREMENT
                                NOT NULL,
    nombre        VARCHAR (255) NOT NULL
);

INSERT INTO Institucion (
                            idInstitucion,
                            nombre
                        )
                        VALUES (
                            1,
                            'Universidad Tecnológica de Chile INACAP'
                        );

INSERT INTO Institucion (
                            idInstitucion,
                            nombre
                        )
                        VALUES (
                            2,
                            'Universidad Tecnológica de Chile INACAP'
                        );


-- Table: Jornada
DROP TABLE IF EXISTS Jornada;

CREATE TABLE Jornada (
    idJornada    TINYINT       NOT NULL,
    nombre       VARCHAR (255) NOT NULL,
    horaComienzo TIME,
    horaTermino  TIME,
    PRIMARY KEY (
        idJornada
    )
);


-- Table: Provincia
DROP TABLE IF EXISTS Provincia;

CREATE TABLE Provincia (
    idProvincia     SMALLINT      NOT NULL,
    Nombre          VARCHAR (255) NOT NULL,
    Region_idRegion TINYINT       NOT NULL,
    PRIMARY KEY (
        idProvincia
    ),
    FOREIGN KEY (
        Region_idRegion
    )
    REFERENCES Region (idRegion) ON DELETE NO ACTION
                                 ON UPDATE CASCADE
);

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          1,
                          'Arica',
                          1
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          2,
                          'Parinacota',
                          1
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          3,
                          'Iquique',
                          2
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          4,
                          'Tamarugal',
                          2
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          5,
                          'Antofagasta',
                          3
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          6,
                          'El Loa',
                          3
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          7,
                          'Tocopilla',
                          3
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          8,
                          'Copiapó',
                          4
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          9,
                          'Chañaral',
                          4
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          10,
                          'Huasco',
                          4
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          11,
                          'Elqui',
                          5
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          12,
                          'Choapa',
                          5
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          13,
                          'Limarí',
                          5
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          14,
                          'Valparaíso',
                          6
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          15,
                          'Isla de Pascua',
                          6
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          16,
                          'Los Andes',
                          6
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          17,
                          'Petorca',
                          6
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          18,
                          'Quillota',
                          6
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          19,
                          'San Antonio',
                          6
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          20,
                          'San Felipe de Aconcagua',
                          6
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          21,
                          'Marga Marga',
                          6
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          22,
                          'Cachapoal',
                          7
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          23,
                          'Cardenal Caro',
                          7
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          24,
                          'Colchagua',
                          7
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          25,
                          'Talca',
                          8
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          26,
                          'Cauquenes',
                          8
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          27,
                          'Curicó',
                          8
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          28,
                          'Linares',
                          8
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          29,
                          'Concepción',
                          9
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          30,
                          'Arauco',
                          9
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          31,
                          'Biobío',
                          9
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          32,
                          'Ñuble',
                          9
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          33,
                          'Cautín',
                          10
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          34,
                          'Malleco',
                          10
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          35,
                          'Valdivia',
                          11
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          36,
                          'Ranco',
                          11
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          37,
                          'Llanquihue',
                          12
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          38,
                          'Chiloé',
                          12
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          39,
                          'Osorno',
                          12
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          40,
                          'Palena',
                          12
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          41,
                          'Coyhaique',
                          13
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          42,
                          'Aysén',
                          13
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          43,
                          'Capitán Prat',
                          13
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          44,
                          'General Carrera',
                          13
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          45,
                          'Magallanes',
                          14
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          46,
                          'Antártica Chilena',
                          14
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          47,
                          'Tierra del Fuego',
                          14
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          48,
                          'Ultima Esperanza',
                          14
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          49,
                          'Santiago',
                          15
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          50,
                          'CORDILLERA',
                          15
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          51,
                          'Chacabuco',
                          15
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          52,
                          'Maipo',
                          15
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          53,
                          'Melipilla',
                          15
                      );

INSERT INTO Provincia (
                          idProvincia,
                          Nombre,
                          Region_idRegion
                      )
                      VALUES (
                          54,
                          'Talagante',
                          15
                      );


-- Table: Region
DROP TABLE IF EXISTS Region;

CREATE TABLE Region (
    idRegion INTEGER       PRIMARY KEY AUTOINCREMENT
                           NOT NULL,
    Nombre   VARCHAR (255) NOT NULL
);

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       1,
                       'ARICA Y PARINACOTA'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       2,
                       'TARAPACÁ'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       3,
                       'ANTOFAGASTA'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       4,
                       'ATACAMA'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       5,
                       'COQUIMBO'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       6,
                       'VALPARAÍSO'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       7,
                       'DEL LIBERTADOR GRAL. BERNARDO O''HIGGINS'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       8,
                       'DEL MAULE'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       9,
                       'DEL BIOBÍO'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       10,
                       'DE LA ARAUCANÍA'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       11,
                       'DE LOS RÍOS'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       12,
                       'DE LOS LAGOS'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       13,
                       'AYSÉN DEL GRAL. CARLOS IBAÑEZ DEL CAMPO'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       14,
                       'MAGALLANES Y DE LA ANTÁRTICA CHILENA'
                   );

INSERT INTO Region (
                       idRegion,
                       Nombre
                   )
                   VALUES (
                       15,
                       'METROPOLITANA DE SANTIAGO'
                   );


-- Table: Regiones_Zona
DROP TABLE IF EXISTS Regiones_Zona;

CREATE TABLE Regiones_Zona (
    idRegiones_Zona INTEGER PRIMARY KEY AUTOINCREMENT
                            NOT NULL,
    Zona_idZona     INTEGER NOT NULL,
    Sede_idSede     INTEGER NOT NULL,
    CONSTRAINT fk_Regiones_Zona_Zona1 FOREIGN KEY (
        Zona_idZona
    )
    REFERENCES Zona (idZona) ON DELETE NO ACTION
                             ON UPDATE NO ACTION,
    CONSTRAINT fk_Regiones_Zona_Sede1 FOREIGN KEY (
        Sede_idSede
    )
    REFERENCES Sede (idSede) ON DELETE NO ACTION
                             ON UPDATE NO ACTION
);

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              1,
                              1,
                              1
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              2,
                              1,
                              2
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              3,
                              1,
                              3
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              4,
                              1,
                              4
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              5,
                              1,
                              5
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              6,
                              1,
                              6
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              7,
                              1,
                              7
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              8,
                              2,
                              8
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              9,
                              2,
                              9
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              10,
                              2,
                              10
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              11,
                              2,
                              11
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              12,
                              2,
                              12
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              13,
                              2,
                              13
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              14,
                              2,
                              14
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              15,
                              3,
                              15
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              16,
                              3,
                              16
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              17,
                              3,
                              17
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              18,
                              3,
                              18
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              19,
                              3,
                              19
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              20,
                              3,
                              20
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              21,
                              3,
                              21
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              22,
                              3,
                              22
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              23,
                              3,
                              23
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              24,
                              3,
                              24
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              25,
                              3,
                              25
                          );

INSERT INTO Regiones_Zona (
                              idRegiones_Zona,
                              Zona_idZona,
                              Sede_idSede
                          )
                          VALUES (
                              26,
                              3,
                              26
                          );


-- Table: Retencion
DROP TABLE IF EXISTS Retencion;

CREATE TABLE Retencion (
    idRetencion INTEGER PRIMARY KEY AUTOINCREMENT
                        NOT NULL,
    porcentaje  FLOAT   NOT NULL
);


-- Table: Retencion_Anual
DROP TABLE IF EXISTS Retencion_Anual;

CREATE TABLE Retencion_Anual (
    idRetencion_Anual     INTEGER PRIMARY KEY AUTOINCREMENT
                                  NOT NULL,
    Retencion_idRetencion INTEGER NOT NULL,
    Sede_idSede           INTEGER NOT NULL,
    CONSTRAINT fk_Retencion_Anual_Retencion1 FOREIGN KEY (
        Retencion_idRetencion
    )
    REFERENCES Retencion (idRetencion) ON DELETE NO ACTION
                                       ON UPDATE NO ACTION,
    CONSTRAINT fk_Retencion_Anual_Sede1 FOREIGN KEY (
        Sede_idSede
    )
    REFERENCES Sede (idSede) ON DELETE CASCADE
                             ON UPDATE CASCADE
);


-- Table: Retencion_Area
DROP TABLE IF EXISTS Retencion_Area;

CREATE TABLE Retencion_Area (
    idRetencion_Area      INTEGER PRIMARY KEY AUTOINCREMENT
                                  NOT NULL,
    Retencion_idRetencion INTEGER NOT NULL,
    Area_idArea           INTEGER NOT NULL,
    CONSTRAINT fk_Retencion_Area_Retencion1 FOREIGN KEY (
        Retencion_idRetencion
    )
    REFERENCES Retencion (idRetencion) ON DELETE NO ACTION
                                       ON UPDATE NO ACTION,
    CONSTRAINT fk_Retencion_Area_Area1 FOREIGN KEY (
        Area_idArea
    )
    REFERENCES Area (idArea) ON DELETE NO ACTION
                             ON UPDATE NO ACTION
);


-- Table: Retencion_Carrera
DROP TABLE IF EXISTS Retencion_Carrera;

CREATE TABLE Retencion_Carrera (
    idRetencion_Carrera           INTEGER PRIMARY KEY AUTOINCREMENT
                                          NOT NULL,
    Retencion_idRetencion         INTEGER NOT NULL,
    Carreras_Sede_idCarreras_Sede INTEGER NOT NULL,
    CONSTRAINT fk_Retencion_Carrera_Retencion1 FOREIGN KEY (
        Retencion_idRetencion
    )
    REFERENCES Retencion (idRetencion) ON DELETE CASCADE
                                       ON UPDATE CASCADE,
    CONSTRAINT fk_Retencion_Carrera_Carreras_Sede1 FOREIGN KEY (
        Carreras_Sede_idCarreras_Sede
    )
    REFERENCES Carreras_Sede (idCarreras_Sede) ON DELETE CASCADE
                                               ON UPDATE CASCADE
);


-- Table: Seccion
DROP TABLE IF EXISTS Seccion;

CREATE TABLE Seccion (
    idSeccion INT NOT NULL,
    PRIMARY KEY (
        idSeccion
    )
);


-- Table: Sede
DROP TABLE IF EXISTS Sede;

CREATE TABLE Sede (
    idSede          INT           NOT NULL,
    nombre          VARCHAR (255) NOT NULL,
    direccion       VARCHAR (255) NOT NULL,
    Comuna_idComuna SMALLINT      NOT NULL,
    PRIMARY KEY (
        idSede
    ),
    FOREIGN KEY (
        Comuna_idComuna
    )
    REFERENCES Comuna (idComuna) ON DELETE NO ACTION
                                 ON UPDATE CASCADE
);

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     1,
                     'INACAP Arica',
                     'Av. Santa María 2190',
                     1
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     2,
                     'INACAP Iquique',
                     'Av. La Tirana 4310',
                     5
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     3,
                     'INACAP Calama',
                     'Av. Granaderos 3250',
                     16
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     4,
                     'INACAP Antofagasta',
                     'Edmundo Pérez Zujovic 11.092',
                     12
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     5,
                     'INACAP Copiapó',
                     'Av. Circunvalación 281',
                     21
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     6,
                     'INACAP La Serena',
                     'Av. Fco. de Aguirre 0389',
                     30
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     7,
                     'INACAP Valparaíso',
                     'Av. España 2250',
                     45
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     8,
                     'INACAP Apoquindo',
                     'Apoquindo 7282 y Chesterton 7028',
                     308
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     9,
                     'INACAP Maipú',
                     'Av. Americo Vespucio #974, Maipú',
                     313
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     10,
                     'INACAP Renca',
                     'Bravo de Saravia 2980',
                     322
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     11,
                     'INACAP Santiago Centro',
                     'Almirante Barroso 76',
                     295
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     12,
                     'INACAP Santiago Sur',
                     'Av. Vicuña Mackenna 3864, Macul',
                     312
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     13,
                     'INACAP Pérez Rosales',
                     'Brown Norte 290',
                     314
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     14,
                     'INACAP Puente Alto',
                     'Av. Concha y Toro 2730, Puente Alto',
                     327
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     15,
                     'INACAP Rancagua',
                     'Av. Nelson Pereira 2519',
                     83
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     16,
                     'INACAP Curicó',
                     'Archipiélago Juan Fernández 2010, Curicó',
                     129
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     17,
                     'INACAP Talca',
                     'Av. San Miguel 3496',
                     116
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     18,
                     'INACAP Chillán',
                     'Carretera Longitudinal Sur Nº 441 ',
                     179
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     19,
                     'INACAP Concepción - Talcahuano',
                     'Autopista Concepción Talcahuano 7421',
                     146
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     20,
                     'INACAP Los Ángeles',
                     'Av. Ricardo Vicuña 825',
                     165
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     21,
                     'INACAP Temuco',
                     'Luis Durand 02150',
                     200
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     22,
                     'INACAP Valdivia',
                     'Av. Pedro Aguirre Cerda 2115, Las Ánimas.',
                     232
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     23,
                     'INACAP Osorno',
                     'Av. René Soriano 2382',
                     263
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     24,
                     'INACAP Puerto Montt',
                     'Av. Padre Harter 125',
                     244
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     25,
                     'INACAP Coyhaique',
                     'Las Violetas 171',
                     274
                 );

INSERT INTO Sede (
                     idSede,
                     nombre,
                     direccion,
                     Comuna_idComuna
                 )
                 VALUES (
                     26,
                     'INACAP Punta Arenas',
                     'Av. Bulnes Km. 4 Norte',
                     284
                 );


-- Table: Tipo_Sede
DROP TABLE IF EXISTS Tipo_Sede;

CREATE TABLE Tipo_Sede (
    idTipo_Sede               INTEGER PRIMARY KEY AUTOINCREMENT
                                      NOT NULL,
    Sede_idSede               INTEGER NOT NULL,
    Institucion_idInstitucion INTEGER NOT NULL,
    CONSTRAINT fk_Tipo_Sede_Sede1 FOREIGN KEY (
        Sede_idSede
    )
    REFERENCES Sede (idSede) ON DELETE NO ACTION
                             ON UPDATE NO ACTION,
    CONSTRAINT fk_Tipo_Sede_Institucion1 FOREIGN KEY (
        Institucion_idInstitucion
    )
    REFERENCES Institucion (idInstitucion) ON DELETE NO ACTION
                                           ON UPDATE CASCADE
);

INSERT INTO Tipo_Sede (
                          idTipo_Sede,
                          Sede_idSede,
                          Institucion_idInstitucion
                      )
                      VALUES (
                          1,
                          4,
                          1
                      );

INSERT INTO Tipo_Sede (
                          idTipo_Sede,
                          Sede_idSede,
                          Institucion_idInstitucion
                      )
                      VALUES (
                          2,
                          4,
                          1
                      );


-- Table: Zona
DROP TABLE IF EXISTS Zona;

CREATE TABLE Zona (
    idZona INTEGER       PRIMARY KEY AUTOINCREMENT
                         NOT NULL,
    nombre VARCHAR (255) NOT NULL
);

INSERT INTO Zona (
                     idZona,
                     nombre
                 )
                 VALUES (
                     1,
                     'Zona Norte'
                 );

INSERT INTO Zona (
                     idZona,
                     nombre
                 )
                 VALUES (
                     2,
                     'Regíon Metropolitana'
                 );

INSERT INTO Zona (
                     idZona,
                     nombre
                 )
                 VALUES (
                     3,
                     'Zona Sur'
                 );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
