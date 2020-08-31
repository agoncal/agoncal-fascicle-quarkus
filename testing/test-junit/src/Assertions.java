// @formatter:off
// tag::adocSnippet[]
public class Assertions {

  void assertTrue(boolean condition) { }
  void assertFalse(boolean condition) { }

  void assertNull(Object actual) { }
  void assertNotNull(Object actual) { }

  void assertEquals(Object expected, Object actual) { }
  void assertNotEquals(Object unexpected, Object actual) { }

  void assertArrayEquals(Object[] expected, Object[] actual) { }
  void assertLinesMatch(List<String> expectedLines, List<String> actualLines) { }

  void assertSame(Object expected, Object actual) { }
  void assertNotSame(Object unexpected, Object actual) { }
  void assertAll(Collection<Executable> executables) { }
  void assertTimeout(Duration timeout, Executable executable) { }

  <T extends Throwable> T assertThrows(Class<T> expectedType, Executable exec) { }
}
// end::adocSnippet[]
