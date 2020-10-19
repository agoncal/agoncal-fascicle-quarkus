package org.agoncal.fascicle.quarkus.http.jsonb.dflt;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class Vinyl {

  public String title;
  public String artist;
  public String musicCompany;


  public Vinyl title(String title) {
    this.title = title;
    return this;
  }

  public Vinyl artist(String artist) {
    this.artist = artist;
    return this;
  }

  public Vinyl musicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
    return this;
  }
}
