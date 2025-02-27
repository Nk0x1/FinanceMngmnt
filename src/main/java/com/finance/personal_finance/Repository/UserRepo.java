package com.finance.personal_finance.Repository;

import com.finance.personal_finance.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserModel, Long> {

    @Query(value="Select id, name, email, doj, password from user_model where email=?1 and password=?2", nativeQuery = true)
    List<UserModel> validLogin(String email, String password);
}
