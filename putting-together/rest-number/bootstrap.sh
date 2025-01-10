#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:3.17.6:create \
    -DplatformVersion=3.17.6 \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.putting-together \
    -DprojectArtifactId=rest-number \
    -DprojectVersion=3.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.number.NumberResource" \
    -Dpath="/api/numbers" \
    -Dextensions="resteasy-jsonb, smallrye-openapi, smallrye-health"
# end::adocSnippet[]
