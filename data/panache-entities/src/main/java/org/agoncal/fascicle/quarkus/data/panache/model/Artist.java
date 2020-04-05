package org.agoncal.fascicle.quarkus.data.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@MappedSuperclass
public class Artist extends PanacheEntity {

  @Column(name = "first_name", length = 50)
  public String firstName;

  @Column(name = "last_name", length = 50)
  public String lastName;

  @Column(length = 5000)
  public String bio;

  @Column(name = "date_of_birth")
  @Temporal(TemporalType.DATE)
  public Date dateOfBirth;

  @Transient
  public Integer age;

  // ======================================
  // =     Lifecycle Callback Methods     =
  // ======================================

  @PostLoad
  @PostPersist
  @PostUpdate
  public void calculateAge() {
    if (dateOfBirth == null) {
      age = null;
      return;
    }

    Calendar birth = new GregorianCalendar();
    birth.setTime(dateOfBirth);
    Calendar now = new GregorianCalendar();
    now.setTime(new Date());
    int adjust = 0;
    if (now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
      adjust = -1;
    }
    age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
  }
}
