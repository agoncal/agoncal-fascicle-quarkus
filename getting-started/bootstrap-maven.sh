#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:3.0.0.Alpha3:create \
    -DplatformVersion=3.0.0.Alpha3 \
    -DprojectGroupId=org.agoncal.fascicle.quarkus \
    -DprojectArtifactId=bug \
    -Dextensions="validator"
# end::adocSnippet[]
