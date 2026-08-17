# Write your MySQL query statement below

-- ANCHORS
-- ^       start
-- $       end

-- CHARACTERS
-- .       any one character
-- [abc]   a OR b OR c
-- [^abc]  anything except a/b/c
-- [a-z]   lowercase
-- [A-Z]   uppercase
-- [0-9]   digit

-- QUANTIFIERS
-- +       1 or more
-- *       0 or more
-- ?       0 or 1
-- {n}     exactly n
-- {n,m}   n to m

-- LOGIC
-- |       OR

-- COMMON
-- ^[0-9]+$          only digits
-- ^[A-Za-z]+$       only letters
-- ^[A-Za-z0-9]+$    only alphanumeric
-- ^[0-9]{4}$        exactly 4 digits


# the 'c' means case sensitive, 'i' means case insensitive
SELECT * FROM Users WHERE REGEXP_LIKE(mail,'^[A-Za-z][A-Za-z0-9._-]*@leetcode[.]com$','c');