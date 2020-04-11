package org.agoncal.fascicle.quarkus.core.cdi.qualifiers;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public interface NumberGenerator {

  // ======================================
  // =          Business methods          =
  // ======================================

  String generateNumber();
}
