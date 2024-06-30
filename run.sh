PID_FILE="$(pwd)/api-server.pid"
JAVA_HOME=/usr/lib/jvm/java-21/
JVM_OPTIONS="-Xms512M -Xmx1G -XX:+UseParallelGC"
JAR_FILE="RoomOccupancyApplication.jar"

SPRING_CONF_DIR="-Dspring.config.additional-location=$(pwd)/conf/ "
SPRING_ACTIVE_PROFILE="-Dspring.profiles.active=dev "
SPRING_OPTIONS="$SPRING_CONF_DIR$SPRING_ACTIVE_PROFILE"

case "$1" in
start)
  nohup $JAVA_HOME/bin/java $SPRING_OPTIONS  $JVM_OPTIONS -jar $JAR_FILE > run.out 2>&1  &
  echo "$!" > $PID_FILE
  echo STARTED
  ;;
stop)
  if [ -f $PID_FILE ]; then
    kill `cat $PID_FILE`
    echo STOPPED
    rm $PID_FILE
    rm "$(pwd)/run.out"
  else
    echo "It seems the process isn't running."
  fi
  ;;
esac
