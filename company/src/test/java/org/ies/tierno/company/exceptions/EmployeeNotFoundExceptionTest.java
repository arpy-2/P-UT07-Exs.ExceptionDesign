package org.ies.tierno.company.exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeNotFoundExceptionTest {

    @Test
    public void testExceptionCreation() {
        EmployeeNotFoundException exception = new EmployeeNotFoundException("12345678X");

        assertEquals("12345678X", exception.getNif());
        assertEquals("12345678X", exception.getMessage());
    }
}
