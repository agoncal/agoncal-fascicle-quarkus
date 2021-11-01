#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:2.4.0.Final:create \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.putting-together \
    -DprojectArtifactId=rest-book \
    -DclassName="org.agoncal.fascicle.quarkus.book.BookResource" \
    -Dpath="/api/books" \
    -Dextensions="resteasy-jsonb, rest-client, smallrye-fault-tolerance, smallrye-metrics"
# end::adocSnippet[]
