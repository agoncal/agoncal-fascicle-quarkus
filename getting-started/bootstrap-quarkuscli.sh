#!/usr/bin/env bash
# tag::adocSnippet[]
quarkus create app org.agoncal.fascicle.quarkus:getting-started:3.0.0-SNAPSHOT \
    --stream io.quarkus.platform:3.0 \
    --name "Artist" \
    --package-name "org.agoncal.fascicle.quarkus.gettingstarted" \
    --extensions="resteasy-jsonb" \
    --maven
# end::adocSnippet[]
