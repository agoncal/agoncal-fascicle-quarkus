#!/bin/bash

TOPICS=$(kafka-topics --zookeeper localhost:2181 --list )

for T in $TOPICS
do
  if [ "$T" != "__consumer_offsets" ]; then
    kafka-topics --zookeeper localhost:2181 --delete --topic $T
  fi
done
