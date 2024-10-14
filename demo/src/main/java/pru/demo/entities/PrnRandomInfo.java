package pru.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrnRandomInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private String email;
    private boolean isScanned = false;

    public PrnRandomInfo(String description, String firstName, String lastName, String phoneNumber, String address,
            Date dateOfBirth, String email) {
        this.description = description;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

}
