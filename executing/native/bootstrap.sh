#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:3.2.0.Final:create \
    -DplatformVersion=3.2.0.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.executing \
    -DprojectArtifactId=native \
    -DprojectVersion=3.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.test.nativemode.ArtistResource" \
    -Dpath="artists"

