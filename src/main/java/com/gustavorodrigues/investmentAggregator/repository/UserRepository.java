package com.gustavorodrigues.investmentAggregator.repository;

import com.gustavorodrigues.investmentAggregator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
