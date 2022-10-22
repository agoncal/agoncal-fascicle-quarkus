#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:2.13.3.Final:create \
    -DplatformVersion=2.13.3.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.putting-together \
    -DprojectArtifactId=rest-book \
    -DprojectVersion=2.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.book.BookResource" \
    -Dpath="/api/books" \
    -Dextensions="resteasy-jsonb, rest-client, smallrye-fault-tolerance, smallrye-metrics"
# end::adocSnippet[]
