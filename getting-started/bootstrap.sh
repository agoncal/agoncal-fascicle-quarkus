#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:1.6.0.Final:create \
     -DprojectGroupId=org.agoncal.fascicle.quarkus \
     -DprojectArtifactId=getting-started \
     -DprojectVersion=1.0 \
     -DclassName="org.agoncal.fascicle.quarkus.gettingstarted.ArtistResource" \
     -Dpath="/artists" \
     -Dextensions="resteasy-jsonb"
# end::adocSnippet[]
