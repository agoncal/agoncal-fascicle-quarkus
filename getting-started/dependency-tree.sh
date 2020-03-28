#!/usr/bin/env bash
COMMAND="mvn dependency:tree"
eval "$COMMAND" > dependency-tree.txt
