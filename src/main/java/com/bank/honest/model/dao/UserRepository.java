package com.bank.honest.model.dao;

import com.bank.honest.model.entity.CustomUser;
import com.bank.honest.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM CustomUser u WHERE u.phone = :phone")
    boolean existsByPhone(@Param("phone") String phone);

    @Query("SELECT u FROM CustomUser u where u.phone = :phone")
    CustomUser findByPhone(@Param("phone") String phone);
}
