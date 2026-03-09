package org.ies.tierno.edificio.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.ies.tierno.edificio.exception.ApartmentNotFoundException;
import org.ies.tierno.edificio.model.Apartment;
import org.ies.tierno.edificio.model.Owner;
import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
public class BuildingApp {
    private String address;
    private String municipality;
    private int postalCode;
    private List<Apartment> apartments;

    public void showApartments() {
        if (apartments.isEmpty()) {
            log.info("No hay apartamentos en el edificio");
            return;
        }

        log.info("Lista de apartamentos");
        for (Apartment apt : apartments) {
            log.info("Planta {} - Puerta {} - {} propietarios", apt.getFloor(), apt.getDoor(), apt.getOwners().size());
        }
    }

    public Apartment getApartment(int floor, String door) throws ApartmentNotFoundException {
        for (Apartment apt : apartments) {
            if (apt.getFloor() == floor && apt.getDoor().equalsIgnoreCase(door)) {
                return apt;
            }
        }
        throw new ApartmentNotFoundException(floor, door);
    }

    public List<Owner> getOwners(int floor, String door) throws ApartmentNotFoundException {
        return getApartment(floor, door).getOwners();
    }
}