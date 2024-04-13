DROP TABLE IF EXISTS "vol_habilidad";
DROP TABLE IF EXISTS "ranking";
DROP TABLE IF EXISTS "tarea_habilidad";
DROP TABLE IF EXISTS "tarea";
DROP TABLE IF EXISTS "estado_tarea";
DROP TABLE IF EXISTS "eme_habilidad";
DROP TABLE IF EXISTS "emergencia";
DROP TABLE IF EXISTS "habilidad";
DROP TABLE IF EXISTS "institucion";
DROP TABLE IF EXISTS "voluntario";


CREATE TABLE "voluntario" (
  "id_voluntario" SERIAL PRIMARY KEY,
  "nombre" varchar,
  "edad" int,
  "direccion" varchar,
  "genero" varchar,
  "email" varchar,
  "telefono" varchar
);

CREATE TABLE "vol_habilidad" (
  "id_vol_habilidad" SERIAL PRIMARY KEY,
  "id_voluntario" bigint,
  "id_habilidad" bigint,
  "nivel_proficiencia" int
);

CREATE TABLE "tarea" (
  "id_tarea" SERIAL PRIMARY KEY,
  "descripcion" varchar,
  "id_emergencia" bigint,
  "completada" int
);

CREATE TABLE "tarea_habilidad" (
  "id_tarea_habilidad" SERIAL PRIMARY KEY,
  "id_tarea" bigint,
  "id_habilidad" bigint
);

CREATE TABLE "ranking" (
  "id_ranking" SERIAL PRIMARY KEY,
  "id_voluntario" bigint,
  "id_tarea" bigint,
  "puntuacion" int
);

CREATE TABLE "institucion" (
  "id_institucion" SERIAL PRIMARY KEY,
  "nombre" varchar,
  "email" varchar,
  "telefono" varchar,
  "ubicacion" varchar
);

CREATE TABLE "habilidad" (
  "id_habilidad" SERIAL PRIMARY KEY,
  "nombre" varchar,
  "descripcion" varchar,
  "certificacion_requerida" int
);

CREATE TABLE "estado_tarea" (
  "id_estado_tarea" SERIAL PRIMARY KEY,
  "descripcion" varchar,
  "id_tarea" bigint
);

CREATE TABLE "emergencia" (
  "id_emergencia" SERIAL PRIMARY KEY,
  "nombre" varchar,
  "descripcion" varchar,
  "fecha_inicio" Date,
  "fecha_fin" Date,
  "id_institucion" bigint
);

CREATE TABLE "eme_habilidad" (
  "id_eme_habilidad" SERIAL PRIMARY KEY,
  "id_emergencia" bigint,
  "id_habilidad" bigint
);

ALTER TABLE "ranking" ADD FOREIGN KEY ("id_voluntario") REFERENCES "voluntario" ("id_voluntario");

ALTER TABLE "ranking" ADD FOREIGN KEY ("id_tarea") REFERENCES "tarea" ("id_tarea");

ALTER TABLE "vol_habilidad" ADD FOREIGN KEY ("id_voluntario") REFERENCES "voluntario" ("id_voluntario");

ALTER TABLE "vol_habilidad" ADD FOREIGN KEY ("id_habilidad") REFERENCES "habilidad" ("id_habilidad");

ALTER TABLE "eme_habilidad" ADD FOREIGN KEY ("id_habilidad") REFERENCES "habilidad" ("id_habilidad");

ALTER TABLE "eme_habilidad" ADD FOREIGN KEY ("id_emergencia") REFERENCES "emergencia" ("id_emergencia");

ALTER TABLE "tarea_habilidad" ADD FOREIGN KEY ("id_tarea") REFERENCES "tarea" ("id_tarea");

ALTER TABLE "tarea_habilidad" ADD FOREIGN KEY ("id_habilidad") REFERENCES "habilidad" ("id_habilidad");

ALTER TABLE "estado_tarea" ADD FOREIGN KEY ("id_tarea") REFERENCES "tarea" ("id_tarea");

ALTER TABLE "emergencia" ADD FOREIGN KEY ("id_institucion") REFERENCES "institucion" ("id_institucion");

ALTER TABLE "tarea" ADD FOREIGN KEY ("id_emergencia") REFERENCES "emergencia" ("id_emergencia");
