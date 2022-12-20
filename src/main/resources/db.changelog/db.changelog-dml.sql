--liquibase formatted sql

--changeset Kirill:insertUsers
--preconditions onFail:HALT onError:HALT
INSERT INTO enduser VALUES ('61641758-31d6-4676-85c6-b24a9bd558f9', 'admin', '$2a$10$RM8LVLW2bQ1kT6YLfEsVTuV8qfRpHkqS/FFNCGxWx3WuCd0CCQ0oa', 'ADMIN');
INSERT INTO diary VALUES ('a7de0df3-845b-4f90-8a45-70c4c85d1cf9', '61641758-31d6-4676-85c6-b24a9bd558f9');
INSERT INTO meal VALUES ('db65a741-90e9-4c3a-bbe3-122b2504ac12', '2011-05-16 15:36:38');
INSERT INTO meal VALUES ('4b4d9c8c-9c5a-4014-9eef-b164df614d0f', '2011-05-17 15:36:38');
INSERT INTO meal VALUES ('8527c85f-6607-49bf-8122-b07b59cac0ff', '2011-05-18 15:36:38');
INSERT INTO meal VALUES ('42c52d28-6781-4ce8-b47a-cb76f9ddd00f', '2011-05-19 15:36:38');
INSERT INTO meal VALUES ('5ca9bd07-bc84-42f5-8a4f-96f7258348dc', '2011-05-20 15:36:38');
INSERT INTO diaryentry VALUES ('2a3ac61a-be0f-404c-844c-dab952dc4b67', 'db65a741-90e9-4c3a-bbe3-122b2504ac12', 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 3.3, '2011-05-16 15:36:38');
INSERT INTO diaryentry VALUES ('17677373-a50b-47a5-a954-d08880f9a022', '4b4d9c8c-9c5a-4014-9eef-b164df614d0f', 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 3.5, '2011-05-17 15:36:38');
INSERT INTO diaryentry VALUES ('57e658fa-291e-4747-a999-bb84ebd2e67b', '8527c85f-6607-49bf-8122-b07b59cac0ff', 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 7.3, '2011-05-18 15:36:38');
INSERT INTO diaryentry VALUES ('56a02cb6-c662-4a0c-a869-cd2b80d593b1', '42c52d28-6781-4ce8-b47a-cb76f9ddd00f', 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 5.5, '2011-05-19 15:36:38');
INSERT INTO diaryentry VALUES ('5d104259-7739-4e3f-a3b6-72b98bbf7a31', '5ca9bd07-bc84-42f5-8a4f-96f7258348dc', 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 4.5, '2011-05-20 15:36:38');
INSERT INTO diaryentry VALUES ('9c5315c7-89fe-419d-bc8f-43aa1ec914f3', null, 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 3.4, '2011-05-21 15:36:38');
INSERT INTO diaryentry VALUES ('5b05f1c9-06f8-45bf-9ee3-a611c68092b5', null, 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 3.2, '2011-05-22 15:36:38');
INSERT INTO diaryentry VALUES ('8778ca61-f33a-412a-beb6-ee6c4400c91b', null, 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 3.5, '2011-05-23 15:36:38');
INSERT INTO diaryentry VALUES ('37dfc813-29cb-44b4-906f-defd987fac96', null, 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 3.2, '2011-05-24 15:36:38');
INSERT INTO diaryentry VALUES ('2460f6a8-d970-4e7c-bf0d-611ff05d8cb3', null, 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 3.6, '2011-05-25 15:36:38');
INSERT INTO diaryentry VALUES ('3b5f96f5-c2a4-4807-897c-aaf43678057c', null, 'a7de0df3-845b-4f90-8a45-70c4c85d1cf9', 3.7, '2011-05-26 15:36:38');
INSERT INTO product VALUES ('13d1727d-fec8-4f19-be4b-71bd013b6f5e', 'banana');
INSERT INTO product VALUES ('f5a2c0c0-b343-4720-8ee9-e9f11865fb44', 'apple');
INSERT INTO product VALUES ('016d2a03-5f02-4e4a-acd3-923d7959519d', 'ice cream');
INSERT INTO product VALUES ('0d78e036-1ed2-4217-b7cc-954c976a2578', 'potato');
INSERT INTO product VALUES ('b0f3c79c-cf8b-4809-8d8c-e547383ad5b6', 'chicken');
INSERT INTO meal_product VALUES ('db65a741-90e9-4c3a-bbe3-122b2504ac12', '13d1727d-fec8-4f19-be4b-71bd013b6f5e');
INSERT INTO meal_product VALUES ('4b4d9c8c-9c5a-4014-9eef-b164df614d0f', 'f5a2c0c0-b343-4720-8ee9-e9f11865fb44');
INSERT INTO meal_product VALUES ('8527c85f-6607-49bf-8122-b07b59cac0ff', '016d2a03-5f02-4e4a-acd3-923d7959519d');
INSERT INTO meal_product VALUES ('42c52d28-6781-4ce8-b47a-cb76f9ddd00f', '0d78e036-1ed2-4217-b7cc-954c976a2578');
INSERT INTO meal_product VALUES ('5ca9bd07-bc84-42f5-8a4f-96f7258348dc', 'b0f3c79c-cf8b-4809-8d8c-e547383ad5b6');