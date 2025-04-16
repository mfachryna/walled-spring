package id.co.bsi.walled.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String mobilePhone;
    private String imageUrl;
}
