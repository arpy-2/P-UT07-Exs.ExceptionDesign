package org.ies.tierno.edificio.reader;

import org.ies.tierno.edificio.model.Owner;
import java.util.Scanner;

public class OwnerReader {
    private final Scanner scanner;

    public OwnerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Owner read() {
        System.out.println("Propietario - ");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Apellidos: ");
        String lastName = scanner.nextLine();
        return new Owner(name, lastName);
    }
}