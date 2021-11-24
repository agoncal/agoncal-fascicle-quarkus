#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:2.5.0.Final:create \
    -DplatformVersion=2.5.0.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=first-step \
    -DprojectVersion=2.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.firststep.AuthorResource" \
    -Dpath="authors"

