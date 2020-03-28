// tag::adocApplication[]
package org.agoncal.fascicle.quarkus.puttingtogether.generator;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
@OpenAPIDefinition(
    info = @Info(title = "Number API",
        description = "This API allows to generate ISBN numbers",
        version = "1.0",
        contact = @Contact(name = "AGoncal", url = "https://twitter.com/agoncal")),
    servers = {
        @Server(url = "http://localhost:8083")
    },
    externalDocs = @ExternalDocumentation(url = "https://github.com/agoncal/agoncal-fascicle-quarkus", description = "All the fascicle code"),
    tags = {
        @Tag(name = "api", description = "Public API that can be used by anybody"),
        @Tag(name = "generator", description = "Anybody interested in generating numbers")
    }
)
public class GeneratorApplication extends Application {
}
// end::adocApplication[]
