#!/bin/bash
cd "$(dirname ${BASH_SOURCE[0]})"

nohup java -server -Xms6g -Xmx6g -Dfile.encoding=UTF-8 -XX:+UseG1GC -XX:InitiatingHeapOccupancyPercent=70 -jar mpos-0.0.1-SNAPSHOT.jar -Dthin.root=. -Dspring.config.location=./config/ 1>/dev/null 2>&1 &