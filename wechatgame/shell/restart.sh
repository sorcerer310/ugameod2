#!/usr/bin/env bash
docker exec -d wechatgame bash -c "./opt/wechatgame/stop.sh && ./opt/wechatgame/start.sh && ./opt/wechatgame/stop.sh && ./opt/wechatgame/start.sh"