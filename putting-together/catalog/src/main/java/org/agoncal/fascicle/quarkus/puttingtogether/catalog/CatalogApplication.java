// tag::adocApplication[]
package org.agoncal.fascicle.quarkus.puttingtogether.catalog;

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
    info = @Info(title = "Catalog API",
        description = "This API allows CRUD operations on book",
        version = "1.0",
        contact = @Contact(name = "AGoncal", url = "https://twitter.com/agoncal")),
    servers = {
        @Server(url = "http://localhost:8082")
    },
    externalDocs = @ExternalDocumentation(url = "https://github.com/agoncal/agoncal-fascicle-quarkus", description = "All the fascicle code"),
    tags = {
        @Tag(name = "api", description = "Public that can be used by anybody"),
        @Tag(name = "catelog", description = "Anybody interested in a book catalog")
    }
)
public class CatalogApplication extends Application {
}
// end::adocApplication[]
