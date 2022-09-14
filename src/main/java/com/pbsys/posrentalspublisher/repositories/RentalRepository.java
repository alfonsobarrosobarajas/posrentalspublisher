package com.pbsys.posrentalspublisher.repositories;


import com.pbsys.posrentalspublisher.models.RentalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

public interface RentalRepository extends JpaRepository<RentalModel, Integer> {

    Collection<RentalModel> findByCustomerId(Integer customerId);

    Collection<RentalModel> findByInventoryId(Integer inventoryId);

    Collection<RentalModel> findByRentalDate(Date rentalDate);

}
