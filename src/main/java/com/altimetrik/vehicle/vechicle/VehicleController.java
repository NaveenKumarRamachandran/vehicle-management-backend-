package com.altimetrik.vehicle.vechicle;



import com.altimetrik.vehicle.vechicle.entites.Vehicle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE,
        RequestMethod.PUT})
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;


    public VehicleController(final VehicleService vehicleServiceIn) {
        this.vehicleService = vehicleServiceIn;
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @GetMapping()
    public Vehicle getVehicle(@RequestParam(name = "id") String id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("all")
    public List<Vehicle> getAllVehicle(@RequestParam(name = "key", required = false) String key) {
        return vehicleService.getAllVehicles(key);
    }

    @PutMapping()
    public void updateVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping()
    public void deleteMapping(@RequestParam(name = "id") String id) {
        vehicleService.deleteVehicle(id);
    }
}
