#!/bin/bash

for VAR in 1 2 3 4 5
do

    echo "[$(date +%Y%m%d_%H%M%S)] 当前循环中 VAR 的值为：$VAR"
    sleep 1

done

#https://mp.weixin.qq.com/s/ulB4DE4S8bElcJLS9kug1A  参考

#!/bin/bash

for VAR in $( seq 1 5 )
do

    echo "[$(date +%Y%m%d_%H%M%S)] 当前循环中 VAR 的值为：$VAR"
    sleep 1

done


#!/bin/bash

for VAR in {1..5}
do

    echo "[$(date +%Y%m%d_%H%M%S)] 当前循环中 VAR 的值为：$VAR"
    sleep 1

done

#!/bin/bash

for VAR in zhangsan lisi wangwu
do

    JSON_DATA='{"name":"'"${VAR}"'","group":"test-001"}'
    echo "[$(date +%Y%m%d_%H%M%S)] 数据为 '$JSON_DATA'"
    sleep 1

done

#!/bin/bash

for VAR in $( ls /root/*.txt )
do

    NEW_VAR="${VAR}.bak"
    echo "[$(date +%Y%m%d_%H%M%S)] $VAR 文件将备份为 $NEW_VAR"
    cp $VAR $NEW_VAR
    sleep 1

done

#!/bin/bash

VAR=1
while [ $VAR -le 5 ]
do

    echo "VAR: $VAR"
    ((VAR++))

done


#!/bin/bash

while true
do

    ping -c 1 -W 2 example.com >/dev/null 2>&1
    if [ $? -ne 0 ] ; then

        echo "[ $(date +%Y%m%d_%H%M%S) ] 到 example.com 的网络不通！"

    fi
    sleep 1

done


#!/bin/bash

INPUT_FILE=/root/ip.txt

while read NOW_LINE
do

    echo "当前行为：$NOW_LINE"
    eval $(echo "$NOW_LINE" |awk '{printf("KEY_IP=%s; KEY_TIME=%s",$1,$2)}')
    NEW_TIME=$( date -d @${KEY_TIME} "+%Y-%m-%d %H:%M:%S" )
    echo "将时间戳转换为标准时间后行为：[$NEW_TIME] $KEY_IP"
    sleep 1

done < $INPUT_FILE

#!/bin/bash

USER_LIST="张三 zhangsan@example.com
李四 lisi@example.com
王五 wangwu@example.com"

echo "$USER_LIST" | while read NOW_LINE
do

    eval $(echo "$NOW_LINE" |awk '{printf("KEY_USER=%s; KEY_MAIL=%s",$1,$2)}')
    echo "即将给用户 ${KEY_USER} 的邮箱 ${KEY_MAIL} 发送邮件。"
    sleep 1

done

#!/bin/bash

VAR=0
until [ $VAR -eq 8 ]
do

    read -p "请输入您猜测的数字：" VAR
    sleep 1

done


#!/bin/bash

PROCESS_NAME="$1"

until pgrep -x "$PROCESS_NAME" > /dev/null
do

    echo "进程 $PROCESS_NAME 未运行。请等待此进程启动！"
    sleep 1

done


#!/bin/bash

for i in {1..10}; do
    if [ $i -eq 5 ]; then
        break
    fi
    echo $i
done


#!/bin/bash

for i in {1..10}; do
    if [ $i -eq 5 ]; then
        continue
    fi
    echo $i
done
