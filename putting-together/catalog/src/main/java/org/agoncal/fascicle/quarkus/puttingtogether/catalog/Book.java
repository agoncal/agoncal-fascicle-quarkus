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

  public String author;
  public String title;
  public Integer year;
  public String genre;
  public String isbn;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book() {
  }

  public Book(final String author, final String title, final Integer year, final String genre, final String isbn) {
    this.author = author;
    this.title = title;
    this.year = year;
    this.genre = genre;
    this.isbn = isbn;
  }

  // ======================================
  // =   Methods hash, equals, toString   =
  // ======================================

  @Override
  public String toString() {
    return "Book{" +
      "id=" + id +
      ", author='" + author + '\'' +
      ", title='" + title + '\'' +
      ", year=" + year +
      ", genre='" + genre + '\'' +
      ", isbn='" + isbn + '\'' +
      '}';
  }
}
