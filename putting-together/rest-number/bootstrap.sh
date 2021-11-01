#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:2.4.0.Final:create \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.putting-together \
    -DprojectArtifactId=rest-number \
    -DclassName="org.agoncal.fascicle.quarkus.number.NumberResource" \
    -Dpath="/api/numbers" \
    -Dextensions="resteasy-jsonb, smallrye-openapi, smallrye-health"
# end::adocSnippet[]
