# Write your MySQL query statement below
#DISTINCT KEYWORD GIVES DISTINCT VALUES
SELECT DISTINCT author_id AS id FROM Views WHERE author_id=viewer_id ORDER BY id;

#use this when you want other functions like count and all
-- select author_id as id from Views where author_id=viewer_id group by author_id ORDER BY author_id;