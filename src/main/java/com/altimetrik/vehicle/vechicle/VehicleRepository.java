package com.altimetrik.vehicle.vechicle;


import com.altimetrik.vehicle.vechicle.entites.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {


    @Modifying
    @Query("UPDATE Vehicle v SET v.make = :make, v.model = :model, v.year = :year, v.vin = :vin WHERE v.id = :id")
    void updateVehicle(String id, String make, String model, int year, String vin);

    @Modifying
    @Query(nativeQuery = true, value = "SELECT * FROM vehicle_t v WHERE year LIKE ?1 OR make LIKE ?1 OR model LIKE ?1 OR vin LIKE ?1 ")
    List<Vehicle> findAllVehicle(String key);


}