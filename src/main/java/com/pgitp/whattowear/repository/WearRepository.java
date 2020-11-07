package com.pgitp.whattowear.repository;

import com.pgitp.whattowear.drools.models.Equipment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WearRepository extends ReactiveCrudRepository<Equipment, String> {
}
