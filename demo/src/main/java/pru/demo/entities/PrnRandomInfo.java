package pru.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrnRandomInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String customerName;
    private String phoneNumber;
    private boolean isScanned = false;

    public PrnRandomInfo(String description, String customerName, String phoneNumber) {
        this.description = description;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }    

}
