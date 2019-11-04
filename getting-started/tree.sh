#!/usr/bin/env bash
TREE_COMMAND="tree --noreport --dirsfirst -I 'target|tree.sh|tree.txt|getting-started.iml|bootstrap.sh'"
eval "$TREE_COMMAND" > tree.txt
