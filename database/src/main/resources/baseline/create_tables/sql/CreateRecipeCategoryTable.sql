SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[recipe_category](
  [recipe_id] [bigint] NOT NULL,
  [category_id] [bigint] NOT NULL,
  PRIMARY KEY CLUSTERED
    (
      [recipe_id] ASC,
      [category_id] ASC
    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO