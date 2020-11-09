#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:1.9.0.Final:create \
    -DplatformVersion=1.9.0.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=getting-started \
    -DprojectVersion=1.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.gettingstarted.ArtistResource" \
    -Dpath="/artists" \
    -Dextensions="resteasy-jsonb"
# end::adocSnippet[]
