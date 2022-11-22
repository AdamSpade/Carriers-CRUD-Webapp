package com.example.springboot.service;

import com.example.springboot.model.Carrier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarrierService {
    List<Carrier> getAllCarriers();
    void saveCarrier(Carrier carrier);
    Carrier getCarrierById(long id);
    void deleteCarrierById(long id);
    Page<Carrier> findPaginated(int pageNo, int pageSize);
}
