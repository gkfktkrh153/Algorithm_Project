select ID, NAME, HOST_ID
from PLACES
where HOST_ID in (SELECT HOST_ID
                  FROM PLACES
                  GROUP BY HOST_ID
                  HAVING COUNT(HOST_ID) >= 2)
order by ID;