--liquibase formatted sql
--changeset Priyang:GetRandomMeme runOnChange:true endDelimiter:GO

DROP PROCEDURE IF EXISTS GetRandomMeme;
GO
CREATE PROCEDURE GetRandomMeme()
BEGIN
   /*declare lowerBound INT;  
   set lowerBound  = (PageNumber - 1) * PageSize;*/
	
    SELECT 
        A.file_name AS 'fileName',
        B.guid AS 'userGuid',
        CONCAT(B.first_name, ' ', B.last_name) AS 'userName'
    FROM
        Meme A
            INNER JOIN
        `User` B ON A.user_id = B.id
    where A.id = 1;

    select 'abc' as yo;
    
END GO