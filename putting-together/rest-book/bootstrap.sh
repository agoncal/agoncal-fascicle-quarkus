#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:1.9.0.Final:create \
    -DplatformVersion=1.9.0.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.putting-together \
    -DprojectArtifactId=rest-book \
    -DprojectVersion=1.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.book.BookResource" \
    -Dpath="/api/books" \
    -Dextensions="resteasy-jsonb, rest-client, smallrye-fault-tolerance, smallrye-metrics"
# end::adocSnippet[]
