#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:1.8.1.Final:create \
     -DprojectGroupId=org.agoncal.fascicle.quarkus.putting-together \
     -DprojectArtifactId=rest-number \
     -DprojectVersion=1.0-SNAPSHOT \
     -DclassName="org.agoncal.fascicle.quarkus.number.NumberResource" \
     -Dpath="/api/numbers" \
     -Dextensions="resteasy-jsonb, smallrye-openapi, smallrye-health, docker"
# end::adocSnippet[]
