package org.agoncal.fascicle.quarkus.test.nativemode;

import io.quarkus.test.junit.QuarkusIntegrationTest;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// @formatter:off
// tag::adocSnippet[]
@QuarkusIntegrationTest
public class ArtistResourceIT extends ArtistResourceTest {

    // Execute the same tests but in packaged mode.
}
// end::adocSnippet[]
