#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:2.13.3.Final:create \
    -DplatformVersion=2.13.3.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=getting-started \
    -DprojectVersion=2.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.gettingstarted.ArtistResource" \
    -Dpath="/artists" \
    -Dextensions="resteasy-jsonb"
# end::adocSnippet[]
