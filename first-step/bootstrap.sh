#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:2.13.3.Final:create \
    -DplatformVersion=2.13.3.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=first-step \
    -DprojectVersion=3.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.firststep.AuthorResource" \
    -Dpath="authors"

