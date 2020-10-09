package org.agoncal.fascicle.quarkus.number;

import io.quarkus.test.junit.NativeImageTest;

// tag::adocSnippet[]
@NativeImageTest
public class NativeNumberResourceIT extends NumberResourceTest {

    // Execute the same tests but in native mode.
}
// end::adocSnippet[]
