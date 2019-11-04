#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:0.27.0:create \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=getting-started \
    -DclassName="org.agoncal.fascicle.quarkus.gettingstarted.ArtistResource" \
    -Dpath="artists" \
    -Dextensions="resteasy-jsonb"
