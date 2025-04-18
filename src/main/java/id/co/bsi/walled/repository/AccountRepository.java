package id.co.bsi.walled.repository;

import id.co.bsi.walled.model.Account;
import id.co.bsi.walled.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
