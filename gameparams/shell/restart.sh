#!/usr/bin/env bash
docker exec -d gameparams bash -c "./opt/gameparams/stop.sh && ./opt/gameparams/start.sh && ./opt/gameparams/stop.sh && ./opt/gameparams/start.sh"