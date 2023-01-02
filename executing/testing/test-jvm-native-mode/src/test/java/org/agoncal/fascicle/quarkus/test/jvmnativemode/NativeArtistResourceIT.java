package org.agoncal.fascicle.quarkus.test.jvmnativemode;

import io.quarkus.test.junit.QuarkusIntegrationTest;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// @formatter:off
// tag::adocSnippet[]
@QuarkusIntegrationTest
public class NativeArtistResourceIT extends ArtistResourceTest {

    // Execute the same tests but in native mode.
}
// end::adocSnippet[]
