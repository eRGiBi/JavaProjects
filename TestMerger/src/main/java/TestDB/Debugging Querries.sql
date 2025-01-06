USE TestDB;
GO

SELECT * 
FROM sys.tables
WHERE name = 'Scholars';
GO

SELECT name, type_desc
FROM sys.server_principals

SELECT name FROM sys.master_files WHERE database_id = DB_ID('TestDB')
GO

SELECT name
FROM sys.server_principals
WHERE name = 'NT Service\SSISScaleOutMaster160';

EXEC xp_readerrorlog 0, 1, N'Login failed';

