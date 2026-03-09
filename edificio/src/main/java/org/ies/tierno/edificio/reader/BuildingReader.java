package org.ies.tierno.edificio.reader;

import org.ies.tierno.edificio.model.Apartment;
import org.ies.tierno.edificio.model.Building;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildingReader {
    private final Scanner scanner;
    private final ApartmentReader apartmentReader;

    public BuildingReader(Scanner scanner) {
        this.scanner = scanner;
        this.apartmentReader = new ApartmentReader(scanner);
    }

    public Building read() {
        System.out.println("Datos del edificio - ");

        System.out.print("Dirección: ");
        String address = scanner.nextLine();

        System.out.print("Municipio: ");
        String municipality = scanner.nextLine();

        int postalCode = 0;
        while (true) {
            try {
                System.out.print("Código Postal: ");
                postalCode = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Código postal inválido");
            }
        }

        List<Apartment> apartments = new ArrayList<>();
        System.out.print("Número de apartamentos: ");
        try {
            int numApartments = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numApartments; i++) {
                System.out.println("\n--- Apartamento " + (i + 1) + " ---");
                apartments.add(apartmentReader.read());
            }
        } catch (NumberFormatException e) {
            System.out.println("Número inválido, 0 apartamentos");
        }

        return new Building(address, municipality, postalCode, apartments);
    }
}