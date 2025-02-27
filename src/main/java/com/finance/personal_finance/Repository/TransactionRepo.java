package com.finance.personal_finance.Repository;

import com.finance.personal_finance.Models.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TransactionRepo extends JpaRepository<TransactionModel, Long> {

    @Query(value = "select amount, category, dot, trans_id, notes, u.name FROM transaction_model t JOIN user_model u ON t.user_id=u.id", nativeQuery = true)
    public List<Map<String,String>> fetchAllTransaction();

    @Query(value = "select amount, category, dot, trans_id, notes, u.name FROM transaction_model t JOIN user_model u ON t.user_id=u.id where t.user_id = ?1", nativeQuery = true)
    public List<Map<String,String>> fetchMyTransaction(int id);


}
