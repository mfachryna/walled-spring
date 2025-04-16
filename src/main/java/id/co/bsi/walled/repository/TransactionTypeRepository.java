package id.co.bsi.walled.repository;

import id.co.bsi.walled.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
    @Query(value = "SELECT * FROM transaction_type WHERE title=? LIMIT 1",nativeQuery = true)
    public TransactionType findByTitle(String title);
}
