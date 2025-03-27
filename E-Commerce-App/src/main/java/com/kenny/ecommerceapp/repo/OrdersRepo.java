package com.kenny.ecommerceapp.repo;

import com.kenny.ecommerceapp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders,Long> {
}
