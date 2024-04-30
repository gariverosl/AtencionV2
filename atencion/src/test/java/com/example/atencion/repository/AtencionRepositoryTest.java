package com.example.atencion.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.atencion.model.Atencion;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AtencionRepositoryTest {

    @Autowired
    private AtencionRepository atencionRepository;
    
    @Test
    public void insertAtencionTest(){


        Atencion atenciontest = new Atencion();
        //atenciontest.setId(1);
        atenciontest.setFecha("01-10-2012");
        atenciontest.setCausa("test1");
        atenciontest.setNombreDoc("Dr.F");


        Atencion result = atencionRepository.save(atenciontest);

        assertNotNull(result.getId());
        assertEquals("Dr.F", result.getNombreDoc());
        assertEquals("test1", result.getCausa());
        assertEquals("01-10-2012", result.getFecha());

    }

}
