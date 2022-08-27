package com.HWSpring.GoItDevHW8.manufacturer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturer() {
        return manufacturerRepository.findAll();
    }

    public void createManufacturer(String name) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerName(name);

        manufacturerRepository.save(manufacturer);
    }

    public Manufacturer getByUUID(UUID uuid) {
        return manufacturerRepository.getReferenceById(uuid);
    }

    public void delete(String delete) {
        manufacturerRepository.deleteById(UUID.fromString(delete));
    }

    public void update(UUID uuid, String updateName) {
        Manufacturer manufacturer = getByUUID(uuid);
        manufacturer.setManufacturerName(updateName);

        manufacturerRepository.save(manufacturer);
    }
}

