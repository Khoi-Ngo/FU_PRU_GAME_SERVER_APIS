package pru.demo.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class PrnInfoDto {
    private String description;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private String email;
}
