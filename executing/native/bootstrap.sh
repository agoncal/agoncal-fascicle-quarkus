#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:3.0.0.Alpha3:create \
    -DplatformVersion=3.0.0.Alpha3 \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.executing \
    -DprojectArtifactId=native \
    -DprojectVersion=3.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.test.nativemode.ArtistResource" \
    -Dpath="artists"

