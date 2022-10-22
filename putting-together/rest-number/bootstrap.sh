#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:2.13.3.Final:create \
    -DplatformVersion=2.13.3.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.putting-together \
    -DprojectArtifactId=rest-number \
    -DprojectVersion=2.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.number.NumberResource" \
    -Dpath="/api/numbers" \
    -Dextensions="resteasy-jsonb, smallrye-openapi, smallrye-health"
# end::adocSnippet[]
