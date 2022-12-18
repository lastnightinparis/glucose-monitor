--liquibase formatted sql

--changeset Kirill:insertUsers
--preconditions onFail:CONTINUE onError:CONTINUE
INSERT INTO enduser VALUES ('61641758-31d6-4676-85c6-b24a9bd558f9', 'admin', '$2a$10$RM8LVLW2bQ1kT6YLfEsVTuV8qfRpHkqS/FFNCGxWx3WuCd0CCQ0oa', 'ADMIN');
INSERT INTO diary VALUES ('a7de0df3-845b-4f90-8a45-70c4c85d1cf9', '61641758-31d6-4676-85c6-b24a9bd558f9');
INSERT INTO meal VALUES ('db65a741-90e9-4c3a-bbe3-122b2504ac12', '2011-05-16 15:36:38');
INSERT INTO product VALUES ('13d1727d-fec8-4f19-be4b-71bd013b6f5e', 'banana');
INSERT INTO meal_product VALUES ('db65a741-90e9-4c3a-bbe3-122b2504ac12', '13d1727d-fec8-4f19-be4b-71bd013b6f5e');
INSERT INTO diaryentry VALUES ('2a3ac61a-be0f-404c-844c-dab952dc4b67', 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 'db65a741-90e9-4c3a-bbe3-122b2504ac12', 2.5, '2011-05-16 15:36:38');