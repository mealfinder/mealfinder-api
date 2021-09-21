--
-- Struct of meals table
--

DROP TABLE IF EXISTS "meals" CASCADE;
CREATE TABLE meals (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(60) NOT NULL,
  area VARCHAR(60) NOT NULL,
  instructions TEXT NOT NULL,
  thumb VARCHAR(255) NOT NULL,
  youtube VARCHAR(255),
  source VARCHAR(255)
);


