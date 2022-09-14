package com.pbsys.posrentalspublisher.services;


import com.pbsys.posrentalspublisher.models.RentalModel;
import com.pbsys.posrentalspublisher.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public Collection<RentalModel> findAll() {
        return rentalRepository.findAll();
    }

    public Collection<RentalModel> findByCustomerId(Integer customerId) {
        return rentalRepository.findByCustomerId(customerId);
    }

    public Collection<RentalModel> findByInventoryId(Integer inventoryId) {
        return rentalRepository.findByInventoryId(inventoryId);
    }

    public Collection<RentalModel>findByRentalDate(Date rentalDate){
        return rentalRepository.findByRentalDate(rentalDate);
    }
}
