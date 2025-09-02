/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here

    private void welcomeToCodingNomads(){
        System.out.println("Welcome, please register here:");
    }

    private void registration(){
        System.out.println("Register your first name and last name:");
    }

    private void courseSelection(){
        System.out.println("Select the subjects that you would wish to take:");
    }

    private void completionDate(){
        System.out.println("Date of completion has been set to six months.");
    }

}
