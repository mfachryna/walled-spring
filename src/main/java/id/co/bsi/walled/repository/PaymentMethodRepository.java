package id.co.bsi.walled.repository;

import id.co.bsi.walled.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository <PaymentMethod,Integer> {
}
