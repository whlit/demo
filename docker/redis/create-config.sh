#!/bin/bash

function createConfig() {
    echo "port 638$1
daemonize no
appendonly yes
cluster-enabled yes
cluster-config-file nodes638$1.conf
cluster-node-timeout 5000
cluster-announce-ip 172.24.160.1
cluster-announce-port 638$1
cluster-announce-bus-port 1638$1" > redis-cluster/redis-node-$1/redis.conf
}

nodes=6

for i in $(seq $nodes)
do
    mkdir -p redis-cluster/redis-node-$i
    createConfig $i
done