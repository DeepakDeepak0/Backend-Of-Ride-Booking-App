package com.codeWithMe.Uber.Uber.repositories;

import com.codeWithMe.Uber.Uber.entities.Driver;
import com.codeWithMe.Uber.Uber.entities.Ride;
import com.codeWithMe.Uber.Uber.entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    Page<Ride> findByRider(Rider rider, Pageable pageRequest);

    Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
}
