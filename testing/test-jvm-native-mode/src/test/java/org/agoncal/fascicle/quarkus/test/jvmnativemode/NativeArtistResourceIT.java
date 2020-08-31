package org.agoncal.fascicle.quarkus.test.jvmnativemode;

import io.quarkus.test.junit.NativeImageTest;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// @formatter:off
// tag::adocSnippet[]
@NativeImageTest
public class NativeArtistResourceIT extends ArtistResourceTest {

    // Execute the same tests but in native mode.
}
// end::adocSnippet[]
