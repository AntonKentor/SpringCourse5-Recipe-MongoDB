SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[recipe](
  [id] [bigint] IDENTITY(1,1) NOT NULL,
  [cook_time] [int] NULL,
  [description] [varchar](255) NULL,
  [difficulty] [varchar](255) NULL,
  [directions] [varchar](max) NULL,
  [image] [varbinary](max) NULL,
  [prep_time] [int] NULL,
  [servings] [int] NULL,
  [source] [varchar](255) NULL,
  [url] [varchar](255) NULL,
  [notes_id] [bigint] NULL,
  PRIMARY KEY CLUSTERED
    (
      [id] ASC
    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO