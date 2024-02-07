package com.aca.springdata.jpaProject.repos;

import org.springframework.data.repository.CrudRepository;

import com.aca.springdata.jpaProject.entities.OrderHistory;

public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Long> {

}
