#!/usr/bin/env bash

#scp -r -c 3des-cbc ../target/wechatgame-1.0.jar root@120.27.130.193:/opt/docker-wechatgame/wechatgame/wechatgame.jar
#scp -r -c 3des-cbc start.sh root@120.27.130.193:/opt/docker-wechatgame/wechatgame/.
#scp -r -c 3des-cbc debug.sh root@120.27.130.193:/opt/docker-wechatgame/wechatgame/.
#scp -r -c 3des-cbc stop.sh root@120.27.130.193:/opt/docker-wechatgame/wechatgame/.
#scp -r -c 3des-cbc dockerrun.sh root@120.27.130.193:/opt/docker-wechatgame/.
#scp -r -c 3des-cbc restart.sh root@120.27.130.193:/opt/docker-wechatgame/.
#scp -r -c 3des-cbc application.properties root@120.27.130.193:/opt/docker-wechatgame/wechatgame/.

scp -r -c 3des-cbc ../target/wechatgame-1.0.jar root@47.94.234.28:/opt/docker-wechatgame/wechatgame/wechatgame.jar
scp -r -c 3des-cbc start.sh root@47.94.234.28:/opt/docker-wechatgame/wechatgame/.
scp -r -c 3des-cbc debug.sh root@47.94.234.28:/opt/docker-wechatgame/wechatgame/.
scp -r -c 3des-cbc stop.sh root@47.94.234.28:/opt/docker-wechatgame/wechatgame/.
scp -r -c 3des-cbc dockerrun.sh root@47.94.234.28:/opt/docker-wechatgame/.
scp -r -c 3des-cbc restart.sh root@47.94.234.28:/opt/docker-wechatgame/.
scp -r -c 3des-cbc application.properties root@47.94.234.28:/opt/docker-wechatgame/wechatgame/.


