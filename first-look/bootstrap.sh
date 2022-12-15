#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:3.0.0.Alpha2:create \
    -DplatformVersion=3.0.0.Alpha2 \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=first-look \
    -DprojectVersion=3.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.firststep.AuthorResource" \
    -Dpath="authors"

