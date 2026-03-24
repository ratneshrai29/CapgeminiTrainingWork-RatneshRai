package com.gal.cabservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gal.cabservice.entity.Cab;

@Repository
public interface CabRepo extends JpaRepository<Cab, Long>{

}
