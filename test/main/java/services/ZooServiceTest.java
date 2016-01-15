package services;


import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;


public class ZooServiceTest {
    ZooService service;
    @Before
    public void setUp () {
        service = new ZooService();
    }

    @Test
    public void testZooServiceEmpty () {
        UUID uuid = UUID.randomUUID();
        assertEquals(0, service.numberZoos());
        assertNull(service.getZoo(uuid));
    }

    @Test
    public void testZooServiceCreate () {
        UUID uuid = service.createZoo("testZoo");

        assertEquals(1, service.numberZoos());
        assertNotNull(service.getZoo(uuid));
    }
}
