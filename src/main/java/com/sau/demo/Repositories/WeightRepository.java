package com.sau.demo.Repositories;

import com.sau.demo.Models.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Integer> {
}
