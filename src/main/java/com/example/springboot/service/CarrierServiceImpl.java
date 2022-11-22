package com.example.springboot.service;

import com.example.springboot.model.Carrier;
import com.example.springboot.repository.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrierServiceImpl implements CarrierService {

    @Autowired
    private CarrierRepository carrierRepository;

    @Override
    public List<Carrier> getAllCarriers() {
        return carrierRepository.findAll();
    }

    @Override
    public void saveCarrier(Carrier carrier) {
        this.carrierRepository.save(carrier);
    }

    @Override
    public Carrier getCarrierById(long id) {
        Optional<Carrier> optionalCarrier = carrierRepository.findById(id);
        Carrier carrier = null;
        if(optionalCarrier.isPresent()) {
            carrier = optionalCarrier.get();
        } else {
            throw new RuntimeException("Carrier not found for id :: " + id);
        }
        return carrier;
    }

    @Override
    public void deleteCarrierById(long id) {
        this.carrierRepository.deleteById(id);

    }

    @Override
    public Page<Carrier> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return this.carrierRepository.findAll(pageable);
    }
}
