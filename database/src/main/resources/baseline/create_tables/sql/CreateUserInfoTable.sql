SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user_info](
  [user_name] [varchar](50) NOT NULL,
  [password] [varchar](255) NOT NULL,
  [firstname] [varchar](100) NOT NULL,
  [last_name] [varchar](100) NOT NULL,
  [role] [varchar](15) NOT NULL,
  [country] [varchar](255) NOT NULL,
  [enabled] [bit] NOT NULL,
  PRIMARY KEY CLUSTERED
    (
      [user_name] ASC
    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
