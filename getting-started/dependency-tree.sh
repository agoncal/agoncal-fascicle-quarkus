#!/usr/bin/env bash

COMMAND="mvn quarkus-bootstrap:build-tree"
eval "$COMMAND" > dependency-tree.txt
