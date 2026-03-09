package org.ies.tierno.edificio.exception;

import lombok.Data;

@Data
public class ApartmentNotFoundException extends Exception {
    private final int planta;
    private final String puerta;

    public ApartmentNotFoundException(int planta, String puerta) {
        super("No se encontró el apartamento en planta " + planta + " puerta " + puerta);
        this.planta = planta;
        this.puerta = puerta;
    }
}
