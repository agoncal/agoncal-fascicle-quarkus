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

@ApplicationPath("/")
@OpenAPIDefinition(
    info = @Info(title = "Number API",
        description = "This API allows to generate ISBN numbers",
        version = "1.0",
        contact = @Contact(name = "AGoncal", url = "https://github.com/quarkusio")),
    servers = {
        @Server(url = "http://localhost:8083")
    },
    externalDocs = @ExternalDocumentation(url = "https://github.com/quarkusio/quarkus-workshops", description = "All the Quarkus workshops"),
    tags = {
        @Tag(name = "api", description = "Public that can be used by anybody"),
        @Tag(name = "heroes", description = "Anybody interested in heroes")
    }
)
public class GeneratorApplication extends Application {
}
// end::adocApplication[]
