package org.agoncal.fascicle.quarkus.test.jvmnativemode;

import io.quarkus.test.junit.NativeImageTest;

// @formatter:off
// tag::adocSnippet[]
@NativeImageTest
public class NativeArtistResourceIT extends ArtistResourceTest {

    // Execute the same tests but in native mode.
}
// end::adocSnippet[]
