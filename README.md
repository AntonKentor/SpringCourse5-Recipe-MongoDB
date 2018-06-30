# Spring-boot Recipe application
## Creating my first web application as part of the Spring course on udemy.
### Test Circle CI 2.0

Run with -DskipTests since sure-fire tests fails. Sure-fireplugin must be fixed.

## Notes

Before running liquibase the first time in your local environment, the database and user has to be created.

In management studio run the following sql:s

CREATE DATABASE [ANTONS_DB] COLLATE SQL_Scandinavian_CP850_CS_AS;
GO
use [ANTONS_DB]

if not exists(select * from sys.server_principals where name = 'mvdb')
BEGIN
CREATE LOGIN mvdb WITH PASSWORD = 'm87v60',CHECK_POLICY = OFF
END

if not exists(select * from sys.database_principals where name = 'mvdb')
BEGIN
   CREATE USER mvdb FOR LOGIN mvdb
END

GO
ALTER ROLE [db_owner] ADD MEMBER [mvdb]
GO