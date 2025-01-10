#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:3.17.6:create \
    -DplatformVersion=3.17.6 \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=bug \
    -Dextensions="validator"
# end::adocSnippet[]
