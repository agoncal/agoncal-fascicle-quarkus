#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:3.0.0.Alpha3:create \
    -DplatformVersion=3.0.0.Alpha3 \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=first-look \
    -DprojectVersion=3.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.firstlook.AuthorResource" \
    -Dpath="authors"

