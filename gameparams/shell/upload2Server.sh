#!/usr/bin/env bash

#scp -r -c 3des-cbc ../target/gameparams-1.0.jar root@120.27.130.193:/opt/docker-gameparams/gameparams/gameparams.jar
#scp -r -c 3des-cbc start.sh root@120.27.130.193:/opt/docker-gameparams/gameparams/.
#scp -r -c 3des-cbc debug.sh root@120.27.130.193:/opt/docker-gameparams/gameparams/.
#scp -r -c 3des-cbc stop.sh root@120.27.130.193:/opt/docker-gameparams/gameparams/.
#scp -r -c 3des-cbc dockerrun.sh root@120.27.130.193:/opt/docker-gameparams/.
#scp -r -c 3des-cbc restart.sh root@120.27.130.193:/opt/docker-gameparams/.
#scp -r -c 3des-cbc application.properties root@120.27.130.193:/opt/docker-gameparams/gameparams/.

scp -r -c 3des-cbc ../target/gameparams-1.0.jar root@47.94.234.28:/opt/docker-gameparams/gameparams/gameparams.jar
scp -r -c 3des-cbc start.sh root@47.94.234.28:/opt/docker-gameparams/gameparams/.
scp -r -c 3des-cbc debug.sh root@47.94.234.28:/opt/docker-gameparams/gameparams/.
scp -r -c 3des-cbc stop.sh root@47.94.234.28:/opt/docker-gameparams/gameparams/.
scp -r -c 3des-cbc dockerrun.sh root@47.94.234.28:/opt/docker-gameparams/.
scp -r -c 3des-cbc restart.sh root@47.94.234.28:/opt/docker-gameparams/.
scp -r -c 3des-cbc application.properties root@47.94.234.28:/opt/docker-gameparams/gameparams/.

