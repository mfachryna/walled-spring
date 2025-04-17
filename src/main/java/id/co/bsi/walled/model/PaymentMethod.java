package id.co.bsi.walled.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String method;
}
