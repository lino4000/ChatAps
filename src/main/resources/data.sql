INSERT INTO "ROLES" ("ID", "TITLE", "DESC") VALUES ('1', 'Auxiliar', 'Cargo auxiliar do Inspetor');
INSERT INTO "ROLES" ("ID", "TITLE", "DESC") VALUES ('2', 'Inspetor', 'Cargo responsável por inspecionar fábricas');
INSERT INTO "ROLES" ("ID", "TITLE", "DESC") VALUES ('3', 'Coordenador', 'Cargo responsável por coordenar equipes de inspeção');

INSERT INTO "USERS" ("ID", "USERNAME", "PASSWORD", "ROLE_ID", "IS_LOGGED", "IS_ACTIVE") VALUES ('1', 'jsilva', '$argon2id$v=19$m=1048576,t=4,p=8$9xobHM9qtN7/euzJvZFs2Q$Zm18pwzh60Ows6aZsKj5QETifYQ6UmVbF0l6yZyq4Fw', 1, '0', '1');
INSERT INTO "USERS" ("ID", "USERNAME", "PASSWORD", "ROLE_ID", "IS_LOGGED", "IS_ACTIVE") VALUES ('2', 'rmoraes', '$argon2id$v=19$m=1048576,t=4,p=8$MJNQrVZqKj2ZsxwUrF8wqg$N9rKGvxELx59CV/V0xvaM22iGbixyHf1CPJiLmGPHRs', 2, '0', '1');
INSERT INTO "USERS" ("ID", "USERNAME", "PASSWORD", "ROLE_ID", "IS_LOGGED", "IS_ACTIVE") VALUES ('3', 'mpaiva', '$argon2id$v=19$m=65536,t=10,p=1$noyba1LXdhw+2XlnHjLelQ$49KRgjmFXlU8+0BxZwCpWIaPzv3gohvQ9iyQTDKwmrs', 3, '0', '1');
