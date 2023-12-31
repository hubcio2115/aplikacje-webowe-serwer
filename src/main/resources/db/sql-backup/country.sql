-- -------------------------------------------------------------
-- TablePlus 5.6.8(524)
--
-- https://tableplus.com/
--
-- Database: postgres
-- Generation Time: 2023-12-20 18:09:17.3020
-- -------------------------------------------------------------


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."country" (
    "formation_year" int4,
    "is_in_europe" bool,
    "gdp" int8,
    "id" int8 NOT NULL,
    "ruler_id" int8,
    "name" varchar(255),
    CONSTRAINT "fkikfewwmlfwytx12q1t80xgrkt" FOREIGN KEY ("ruler_id") REFERENCES "public"."ruler"("id"),
    PRIMARY KEY ("id")
);

INSERT INTO "public"."country" ("formation_year", "is_in_europe", "gdp", "id", "ruler_id", "name") VALUES
(1919, 'f', NULL, 1, 1, 'Afghanistan'),
(1912, 't', NULL, 2, 2, 'Albania'),
(1962, 'f', NULL, 3, 3, 'Algeria'),
(1278, 't', NULL, 4, 4, 'Andorra'),
(1975, 'f', NULL, 5, 5, 'Angola'),
(1981, 'f', NULL, 6, 6, 'Antigua and Barbuda'),
(1816, 'f', NULL, 7, 7, 'Argentina'),
(1991, 't', NULL, 8, 8, 'Armenia'),
(1901, 'f', NULL, 9, 9, 'Australia'),
(1955, 't', NULL, 10, 10, 'Austria'),
(1991, 't', NULL, 11, 11, 'Azerbaijan'),
(1973, 'f', NULL, 12, 12, 'Bahamas'),
(1971, 'f', NULL, 13, 13, 'Bahrain'),
(1971, 'f', NULL, 14, 14, 'Bangladesh'),
(1966, 'f', NULL, 15, 15, 'Barbados'),
(1991, 't', NULL, 16, 16, 'Belarus'),
(1830, 't', NULL, 17, 17, 'Belgium'),
(1981, 'f', NULL, 18, 18, 'Belize'),
(1960, 'f', NULL, 19, 19, 'Benin'),
(1907, 't', NULL, 20, 20, 'Bhutan'),
(1825, 'f', NULL, 21, 21, 'Bolivia'),
(1992, 't', NULL, 22, 22, 'Bosnia and Herzegovina'),
(1966, 'f', NULL, 23, 23, 'Botswana'),
(1822, 'f', NULL, 24, 24, 'Brazil'),
(1984, 'f', NULL, 25, 25, 'Brunei'),
(1908, 't', NULL, 26, 26, 'Bulgaria'),
(1960, 'f', NULL, 27, 27, 'Burkina Faso'),
(1962, 'f', NULL, 28, 28, 'Burundi'),
(1975, 'f', NULL, 29, 29, 'Cabo Verde'),
(1953, 'f', NULL, 30, 30, 'Cambodia'),
(1960, 'f', NULL, 31, 31, 'Cameroon'),
(1867, 'f', NULL, 32, 32, 'Canada'),
(1960, 'f', NULL, 33, 33, 'Central African Republic'),
(1960, 'f', NULL, 34, 34, 'Chad'),
(1818, 'f', NULL, 35, 35, 'Chile'),
(221, 'f', NULL, 36, 36, 'China'),
(1810, 'f', NULL, 37, 37, 'Colombia'),
(1975, 'f', NULL, 38, 38, 'Comoros'),
(1960, 'f', NULL, 39, 39, 'Congo (Congo-Brazzaville)'),
(1821, 'f', NULL, 40, 40, 'Costa Rica'),
(1991, 't', NULL, 41, 41, 'Croatia'),
(1902, 'f', NULL, 42, 42, 'Cuba'),
(1960, 't', NULL, 43, 43, 'Cyprus'),
(1993, 't', NULL, 44, 44, 'Czechia (Czech Republic)'),
(800, 't', NULL, 45, 45, 'Denmark'),
(1977, 'f', NULL, 46, 46, 'Djibouti'),
(1978, 'f', NULL, 47, 47, 'Dominica'),
(1844, 'f', NULL, 48, 48, 'Dominican Republic'),
(1830, 'f', NULL, 49, 49, 'Ecuador'),
(1922, 'f', NULL, 50, 50, 'Egypt'),
(1821, 'f', NULL, 51, 51, 'El Salvador'),
(1968, 'f', NULL, 52, 52, 'Equatorial Guinea'),
(1993, 'f', NULL, 53, 53, 'Eritrea'),
(1918, 't', NULL, 54, 54, 'Estonia'),
(1968, 't', NULL, 55, 55, 'Eswatini (fmr. "Swaziland")'),
(980, 'f', NULL, 56, 56, 'Ethiopia'),
(1970, 'f', NULL, 57, 57, 'Fiji'),
(1917, 't', NULL, 58, 58, 'Finland'),
(843, 't', NULL, 59, 59, 'France'),
(1960, 'f', NULL, 60, 60, 'Gabon'),
(1965, 't', NULL, 61, 61, 'Gambia'),
(1991, 't', NULL, 62, 62, 'Georgia'),
(843, 't', NULL, 63, 63, 'Germany'),
(1957, 'f', NULL, 64, 64, 'Ghana'),
(1821, 't', NULL, 65, 65, 'Greece'),
(1974, 'f', NULL, 66, 66, 'Grenada'),
(1821, 'f', NULL, 67, 67, 'Guatemala'),
(1958, 'f', NULL, 68, 68, 'Guinea'),
(1973, 'f', NULL, 69, 69, 'Guinea-Bissau'),
(1966, 'f', NULL, 70, 70, 'Guyana'),
(1804, 'f', NULL, 71, 71, 'Haiti'),
(1929, 't', NULL, 72, 72, 'Holy See'),
(1821, 'f', NULL, 73, 73, 'Honduras'),
(1000, 't', NULL, 74, 74, 'Hungary'),
(930, 't', NULL, 75, 75, 'Iceland'),
(1947, 'f', NULL, 76, 76, 'India'),
(1945, 'f', NULL, 77, 77, 'Indonesia'),
(1979, 't', NULL, 78, 78, 'Iran'),
(1932, 'f', NULL, 79, 79, 'Iraq'),
(1922, 't', NULL, 80, 80, 'Ireland'),
(1948, 'f', NULL, 81, 81, 'Israel'),
(1861, 't', NULL, 82, 82, 'Italy'),
(1962, 'f', NULL, 83, 83, 'Jamaica'),
(660, 'f', NULL, 84, 84, 'Japan'),
(1946, 'f', NULL, 85, 85, 'Jordan'),
(1991, 't', NULL, 86, 86, 'Kazakhstan'),
(1963, 'f', NULL, 87, 87, 'Kenya'),
(1979, 'f', NULL, 88, 88, 'Kiribati'),
(1961, 'f', NULL, 89, 89, 'Kuwait'),
(1991, 't', NULL, 90, 90, 'Kyrgyzstan'),
(1949, 'f', NULL, 91, 91, 'Laos'),
(1918, 't', NULL, 92, 92, 'Latvia'),
(1943, 't', NULL, 93, 93, 'Lebanon'),
(1966, 'f', NULL, 94, 94, 'Lesotho'),
(1847, 'f', NULL, 95, 95, 'Liberia'),
(1951, 'f', NULL, 96, 96, 'Libya'),
(1719, 't', NULL, 97, 97, 'Liechtenstein'),
(1009, 't', NULL, 98, 98, 'Lithuania'),
(963, 't', NULL, 99, 99, 'Luxembourg'),
(1960, 'f', NULL, 100, 100, 'Madagascar');