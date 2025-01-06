-- =============================================
USE master
GO

-- Drop the database if it already exists
IF  EXISTS (
	SELECT name 
		FROM sys.databases 
		WHERE name = 'TestDB'
)
BEGIN
	ALTER DATABASE TestDB SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE TestDB;
END
GO

CREATE DATABASE TestDB
GO

ALTER DATABASE TestDB
MODIFY FILE (NAME = TestDB, SIZE = 10MB, MAXSIZE = 100MB, FILEGROWTH = 10MB);
GO

USE TestDB;
GO

CREATE TABLE Scholars (
    ID NVARCHAR(320) PRIMARY KEY,
    --CreatedAt DATETIME DEFAULT GETDATE(),
	Theory1 FLOAT,
	Theory2 FLOAT,
	Theory3 FLOAT,
	Practice1 FLOAT,
	Practice2 FLOAT,
	Practice3 FLOAT,
	Result NVARCHAR(64)
);
GO


