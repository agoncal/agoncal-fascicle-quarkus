#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:2.4.0.Final:create \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=first-step \
    -DclassName="org.agoncal.fascicle.quarkus.firststep.AuthorResource" \
    -Dpath="authors"

