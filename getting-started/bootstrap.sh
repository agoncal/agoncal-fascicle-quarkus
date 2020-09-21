#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:1.7.1.Final:create \
     -DprojectGroupId=org.agoncal.fascicle.quarkus.testing \
     -DprojectArtifactId=test-jvm-native-mode \
     -DprojectVersion=1.0-SNAPSHOT \
     -DclassName="org.agoncal.fascicle.quarkus.test.jvmnativemode.ArtistResource" \
     -Dpath="/artists" \
     -Dextensions="resteasy-jsonb"
# end::adocSnippet[]
