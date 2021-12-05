package com.brahma.order.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brahma.order.service.model.OrderMaster;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Long> {
}
