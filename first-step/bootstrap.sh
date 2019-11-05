#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:0.28.1:create \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=first-step \
    -DclassName="org.agoncal.fascicle.quarkus.firststep.AuthorResource" \
    -Dpath="authors"

