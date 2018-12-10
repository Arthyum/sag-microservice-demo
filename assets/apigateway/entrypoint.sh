#!/bin/sh

## start microgateway
cd $MICROGATEWAY_HOME
nohup ./microgateway.sh start -p $MICROGATEWAY_PORT -a $MICROGATEWAY_HOME/api_archive.zip -lv TRACE &

# back to root, as it seems it's the only path from which the startContainer.sh works
cd /

export JAVA_EXEC="$JAVA_HOME/bin/java"
export JAVA_MIN_MEM="128M"
export JAVA_MAX_MEM="512M"

# then start microservice container
/bin/sh $SAG_HOME/IntegrationServer/bin/startContainer.sh