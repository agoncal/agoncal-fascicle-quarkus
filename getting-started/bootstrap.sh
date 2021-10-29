#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:2.4.0.Final:create \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=getting-started \
    -DclassName="org.agoncal.fascicle.quarkus.gettingstarted.ArtistResource" \
    -Dpath="/artists" \
    -Dextensions="resteasy-jsonb"
# end::adocSnippet[]
