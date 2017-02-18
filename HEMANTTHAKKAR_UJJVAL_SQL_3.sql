-- 1. List each title name and their authors can you do it on a single line for multiple authors

SELECT TI.TITLE AS TITLENAME,
		STUFF(( SELECT '; ' + CONCAT(AU.AU_FNAME,' ', AU.AU_LNAME) AS [text()]
				FROM AUTHORS AU
				INNER JOIN TITLEAUTHOR TA
				ON TA.AU_ID = AU.AU_ID AND TI.TITLE_ID = TA.TITLE_ID
FOR XML PATH('')), 1, 1, '')
AS AUTHORS
FROM TITLES TI;

-- 2. List the titles in order of total sale. Totals sales is determined by reading the qty from sales and calculating the sales price based on the price of the book in the titles table

SELECT T.TITLE AS Titles , SUM(S.QTY*T.PRICE) AS 'Total Sales' 
FROM TITLES T JOIN SALES S
ON T.TITLE_ID=S.TITLE_ID
GROUP BY TITLE
ORDER BY 'Total Sales';

-- 3. Add the store name to the query above

SELECT T.TITLE AS Titles , SUM(SA.QTY*T.PRICE) AS 'Total Sales' , ST.STOR_NAME AS 'Store Name' 
FROM TITLES T JOIN SALES SA
ON T.TITLE_ID=SA.TITLE_ID
JOIN STORES ST ON ST.STOR_ID = SA.STOR_ID
GROUP BY TITLE, ST.STOR_NAME
ORDER BY 'Total Sales';

-- 4. List all the titles and list the royalty schedule

SELECT DISTINCT(T.TITLE),RO.HIRANGE,RO.LORANGE,RO.ROYALTY 
FROM TITLES T JOIN ROYSCHED RO ON T.TITLE_ID=RO.TITLE_ID;

-- 5. List the stores that have orders with more than one title on the order

SELECT SA.ORD_NUM,ST.STOR_NAME 
FROM SALES SA JOIN STORES ST ON SA.STOR_ID=ST.STOR_ID 
GROUP BY ST.STOR_NAME,SA.ORD_NUM 
HAVING COUNT(TITLE_ID)>1;

-- 6. Using the last position of the employee id to determine gender generate a count of the number of males and females

SELECT
COUNT(CASE WHEN EMP_ID LIKE '%M' THEN 'TRUE' END) AS 'NO_OF_MALES',
COUNT(CASE WHEN EMP_ID LIKE '%F' THEN 'TRUE' END) AS 'NO_OF_FEMALES'
FROM EMPLOYEE;

-- 7. Produce a report firstname, lastname and gender.  Show gender as Male or Female based on last position in the employee id

SELECT FNAME AS FIRSTNAME,LNAME AS LASTNAME,CASE WHEN EMP_ID LIKE '%F' THEN 'FEMALE' ELSE 'MALE' END AS GENDER
FROM EMPLOYEE;