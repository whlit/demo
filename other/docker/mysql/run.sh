#!/bin/bash
docker run -d --name dev_mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql:5.7
