USE TestDB;
SELECT name
FROM sys.database_principals
WHERE name = 'main';


USE TestDB;

CREATE USER main FOR LOGIN main;

GRANT CONNECT TO main;
ALTER ROLE db_owner ADD MEMBER main;
GRANT SELECT, INSERT, UPDATE, DELETE ON DATABASE::TestDB TO main;
ALTER LOGIN main WITH DEFAULT_DATABASE = TestDB;


