#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:3.2.0.Final:create \
    -DplatformVersion=3.2.0.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=first-look \
    -DprojectVersion=3.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.firstlook.AuthorResource" \
    -Dpath="authors"

