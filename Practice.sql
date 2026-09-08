mysql> USE DATABASES;
ERROR 1049 (42000): Unknown database 'databases'
mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| college            |
| company            |
| information_schema |
| log_sentinel       |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
7 rows in set (0.01 sec)

mysql> USE log_sentinel;
Database changed
mysql> SHOW TABLES;
+------------------------+
| Tables_in_log_sentinel |
+------------------------+
| incidents              |
| logs                   |
| tickets                |
| users                  |
+------------------------+
4 rows in set (0.00 sec)

mysql> SELECT * FROM incidents;
+----+----------------------------+--------------------------------------------------------+----------+-----------------------------+
| id | created_at                 | description                                            | status   | title                       |
+----+----------------------------+--------------------------------------------------------+----------+-----------------------------+
|  1 | 2026-09-06 00:00:34.470745 | Payment service is unable to connect to MySQL database | RESOLVED | Database Connection Failure |
+----+----------------------------+--------------------------------------------------------+----------+-----------------------------+
1 row in set (0.01 sec)

mysql> SELECT * FROM logs;
+----+-------+----------------------------+-----------------+----------------------------+
| id | level | message                    | source          | timestamp                  |
+----+-------+----------------------------+-----------------+----------------------------+
|  5 | ERROR | Database connection failed | Payment-Service | 2026-08-30 15:29:19.150194 |
+----+-------+----------------------------+-----------------+----------------------------+
1 row in set (0.00 sec)



mysql> SELECT *  FROM tickets;
Empty set (0.00 sec)

mysql> SELECT * FROM users;
+----+---------------------+--------------------------------------------------------------+------+-----------+
| id | email               | password                                                     | role | username  |
+----+---------------------+--------------------------------------------------------------+------+-----------+
|  1 | abdullah@gmail.com  | it are me hide this password                                 | USER | abdullah  |
|  2 | abdullah2@gmail.com | it are me hide this password                                 | USER | abdullah2 |
+----+---------------------+--------------------------------------------------------------+------+-----------+
2 rows in set (0.00 sec)

mysql>