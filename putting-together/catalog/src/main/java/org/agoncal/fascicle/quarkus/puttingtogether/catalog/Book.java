/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.agoncal.fascicle.quarkus.puttingtogether.catalog;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;

@Entity
@Schema(description = "Book representation")
public class Book extends PanacheEntity {

  // ======================================
  // =             Attributes             =
  // ======================================

  public String isbn;
  public String title;
  public String author;
  public Integer year;
  public String genre;

  // ======================================
  // =   Constructors, getters, setters   =
  // ======================================

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public Book title(String title) {
    this.title = title;
    return this;
  }

  public Book author(String author) {
    this.author = author;
    return this;
  }

  public Book year(Integer year) {
    this.year = year;
    return this;
  }

  public Book genre(String genre) {
    this.genre = genre;
    return this;
  }

  // ======================================
  // =   Methods hash, equals, toString   =
  // ======================================

  @Override
  public String toString() {
    return "Book{" +
      "isbn='" + isbn + '\'' +
      ", title='" + title + '\'' +
      ", author='" + author + '\'' +
      ", year=" + year +
      ", genre='" + genre + '\'' +
      ", id=" + id +
      '}';
  }
}
