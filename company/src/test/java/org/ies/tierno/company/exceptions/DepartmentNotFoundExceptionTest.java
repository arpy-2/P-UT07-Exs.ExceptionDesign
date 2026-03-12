package org.ies.tierno.company.exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

public class DepartmentNotFoundExceptionTest {

    @Test
    public void testExceptionCreation() {
        DepartmentNotFoundException exception = new DepartmentNotFoundException("Ventas");

        assertEquals("Ventas", exception.getDepartmentName());
    }
}