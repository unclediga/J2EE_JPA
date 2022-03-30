
package ru.unclediga.book.jpa.ch06.ex24;

import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SingularAttribute;


//@Generated("EclipseLink")
// I did it Myself :(
@StaticMetamodel(Customer24.class)
public class Customer24_ {
  public static volatile SingularAttribute<Customer24, Long> id;
  public static volatile SingularAttribute<Customer24, String> firstName;
  public static volatile SingularAttribute<Customer24, String> lastName;
  public static volatile SingularAttribute<Customer24, Integer> age;
  public static volatile SingularAttribute<Customer24, String> email;
  public static volatile SingularAttribute<Customer24, Address24> address;
}