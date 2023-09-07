#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:3.2.0.Final:create \
    -DplatformVersion=3.2.0.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=bug \
    -Dextensions="validator"
# end::adocSnippet[]
