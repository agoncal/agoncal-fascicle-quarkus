#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:3.17.6:create \
    -DplatformVersion=3.17.6 \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=getting-started \
    -DprojectVersion=3.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.gettingstarted.ArtistResource" \
    -Dpath="/artists" \
    -Dextensions="resteasy-jsonb"
# end::adocSnippet[]
