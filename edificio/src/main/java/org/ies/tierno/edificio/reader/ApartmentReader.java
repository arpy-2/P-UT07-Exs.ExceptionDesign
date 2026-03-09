package org.ies.tierno.edificio.reader;

import org.ies.tierno.edificio.model.Apartment;
import org.ies.tierno.edificio.model.Owner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApartmentReader {
    private final Scanner scanner;
    private final OwnerReader ownerReader;

    public ApartmentReader(Scanner scanner) {
        this.scanner = scanner;
        this.ownerReader = new OwnerReader(scanner);
    }

    public Apartment read() {
        System.out.println("Nuevo Apartamento");

        int floor = 0;
        while (true) {
            try {
                System.out.print("Planta: ");
                floor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Número inválido");
            }
        }

        System.out.print("Puerta: ");
        String door = scanner.nextLine();

        List<Owner> owners = new ArrayList<>();
        System.out.print("Número de propietarios: ");
        try {
            int numOwners = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numOwners; i++) {
                owners.add(ownerReader.read());
            }
        } catch (NumberFormatException e) {
            System.out.println("Número inválido, hay 0 propietarios");
        }

        return new Apartment(floor, door, owners);
    }
}