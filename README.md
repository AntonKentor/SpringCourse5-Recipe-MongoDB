# Spring-boot Recipe application
## Creating my first web application as part of the Spring course on udemy.
### Test Circle CI 2.0

Run with -DskipTests since sure-fire tests fails. Sure-fireplugin must be fixed.

## Notes

Before running liquibase the first time in your local environment, the database and user has to be created.

In management studio run the following sql:s


CREATE DATABASE [RECIPE_DB] COLLATE SQL_Scandinavian_CP850_CS_AS;
GO
use [RECIPE_DB]

if not exists(select * from sys.server_principals where name = 'recipe_user')
BEGIN
CREATE LOGIN recipe_user WITH PASSWORD = 'cV6VrWdh!',CHECK_POLICY = OFF
END

if not exists(select * from sys.database_principals where name = 'recipe_user')
BEGIN
   CREATE USER recipe_user FOR LOGIN recipe_user
END

GO
ALTER ROLE [db_owner] ADD MEMBER [recipe_user]
GO