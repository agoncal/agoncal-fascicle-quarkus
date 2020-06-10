package org.agoncal.fascicle.quarkus.advanced.command;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.io.File;
import java.util.stream.Stream;

// tag::adocSnippet[]
@QuarkusMain
public class LsCommand implements QuarkusApplication {

  @Override
  public int run(String... args) throws Exception {
    Stream.of(new File(".").listFiles())
      .filter(file -> !file.isDirectory())
      .map(File::getName)
      .forEach(System.out::println);
    return 0;
  }
}
// end::adocSnippet[]
