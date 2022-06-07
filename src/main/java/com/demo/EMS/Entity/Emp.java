

package com.demo.EMS.Entity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Emp {


    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   @NotNull
    private String firstName;
   @NotNull
    private String lastName;
   @NotNull
   @Column(unique=true)
    private String email;

   public Emp(String firstName, String lastName, String email)
   {
       this.email=email;
       this.firstName=firstName;
       this.lastName=lastName;
   }
}