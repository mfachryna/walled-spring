package id.co.bsi.walled.service;

import id.co.bsi.walled.model.PaymentMethod;
import id.co.bsi.walled.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethod> getAllMethods(){
        return this.paymentMethodRepository.findAll();
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod.getMethod() == null || paymentMethod.getMethod().isEmpty()) {
            throw new RuntimeException("Payment method name cannot be null or empty");
        }

        return this.paymentMethodRepository.save(paymentMethod);
    }
}
