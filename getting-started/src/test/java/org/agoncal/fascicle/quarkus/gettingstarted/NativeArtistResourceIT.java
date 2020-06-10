package org.agoncal.fascicle.quarkus.gettingstarted;

import io.quarkus.test.junit.NativeImageTest;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// tag::adocSnippet[]
@NativeImageTest
public class NativeArtistResourceIT extends ArtistResourceTest {

    // Execute the same tests but in native mode.
}
// end::adocSnippet[]
