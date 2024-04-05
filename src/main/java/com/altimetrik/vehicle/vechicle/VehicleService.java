package com.altimetrik.vehicle.vechicle;



import com.altimetrik.vehicle.vechicle.entites.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;


    public Vehicle createVehicle(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    @Transactional
    public List<Vehicle> getAllVehicles(String key) {
        if(key != null) {
            key = "%"+key+"%";
            return vehicleRepository.findAllVehicle(key);
        } else {
            return vehicleRepository.findAll();
        }
    }

    public Vehicle getVehicleById(String id) {
        return vehicleRepository.findById(id).orElse(null);
    }
    @Transactional
    public void updateVehicle(Vehicle vehicle) {
        vehicleRepository.updateVehicle(vehicle.getId(), vehicle.getMake(), vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getVin());
    }

    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);
    }
}
