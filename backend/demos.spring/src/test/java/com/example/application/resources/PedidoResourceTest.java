package com.example.application.resources;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import com.example.application.dtos.PaymentEditDTO;
import com.example.application.dtos.PedidoEditDTO;
import com.example.domains.contracts.services.PedidosService;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;
@SpringBootTest
//@AutoConfigureMockMvc
class PedidoResourceTest {
    List<PedidoEditDTO> listado;
    @BeforeEach
    void setUp() throws Exception {
    	
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date result = date.parse("2022-07-04T12:08:56.235-0700");
        listado = new ArrayList<PedidoEditDTO>();
        listado.add(new PedidoEditDTO(1, result, 1, 1, null, 1,
                List.of(new PaymentEditDTO(1, 1, new java.math.BigDecimal("0.99"), result))));
        listado.add(new PedidoEditDTO(2, result, 1, 1, null, 1,
                List.of(new PaymentEditDTO(2, 1, new java.math.BigDecimal("1.99"), result))));
    }
    public static class IoCTestConfig {
        @Bean
        PedidosService getServicio() {
            return mock(PedidosService.class);
        }
        @Bean
        PedidosResource getRest() {
            return new PedidosResource();
        }
    }
    @Nested
    // @ContextConfiguration(classes = IoCTestConfig.class)
    @MockBean(PedidosService.class)
    class PruebasUnitarias {
        @Autowired
        PedidosService srv;
        @Autowired
        PedidosResource rest;
        @Test
        void testMock() {
            assertNotNull(srv);
            assertNotNull(rest);
        }
        @Test
        void testGetAll() {
            when(srv.getByProjection(PedidoEditDTO.class)).thenReturn(listado);
            var rslt = rest.getAll();
            assertNotNull(rslt);
            // assertEquals(2, rslt.size());
        }
        @Test
        void testGetOne() throws NotFoundException {
            when(srv.getOne(1)).thenReturn(PedidoEditDTO.from(listado.get(0)));
            var rslt = rest.getOneEdit(1, "edit");
            assertNotNull(rslt);
            assertEquals(1, rslt.getRentalId());
        }
        @Test
        void testGetOneNotFound() throws NotFoundException {
            when(srv.getOne(1)).thenThrow(NotFoundException.class);
            assertThrows(NotFoundException.class, () -> rest.getOneDetails(1, "details"));
        }
        @Test
        void testCreate() throws NotFoundException, DuplicateKeyException, InvalidDataException {
            when(srv.add(any())).thenReturn(PedidoEditDTO.from(listado.get(0)));
            var rslt = rest.create(listado.get(0));
            assertNotNull(rslt);
            assertEquals(HttpStatus.CREATED, rslt.getStatusCode());
        }
        @Test
        void testCreateDuplicateKey() throws NotFoundException, DuplicateKeyException, InvalidDataException {
            when(srv.add(any())).thenThrow(DuplicateKeyException.class);
            assertThrows(DuplicateKeyException.class, () -> rest.create(listado.get(0)));
        }
        @Test
        void testCreateInvalidData() throws NotFoundException, DuplicateKeyException, InvalidDataException {
            when(srv.add(any())).thenThrow(InvalidDataException.class);
            assertThrows(InvalidDataException.class, () -> rest.create(listado.get(0)));
        }
//        @Test
//        void testUpdate() throws NotFoundException, InvalidDataException {
//            when(srv.change(any())).thenReturn(PedidoEditDTO.from(listado.get(0)));
//            System.out.println(listado.toString());
//            rest.update(1, listado.get(0));
//            
//            verify(srv).change(PedidoEditDTO.from(listado.get(0)));
//        }
        @Test
        void testUpdateInvalidId() throws NotFoundException, InvalidDataException {
            assertThrows(InvalidDataException.class, () -> rest.update(0, listado.get(0)));
        }
        @Test
        void testUpdateInvalidData() throws NotFoundException, InvalidDataException {        	
            var result = new Date();
			assertThrows(InvalidDataException.class, () -> rest.update(50, new PedidoEditDTO(1, result, 1, 1, null, 1,
                    List.of(new PaymentEditDTO(1, 1, new java.math.BigDecimal("0.01"), result)))));
        }
        @Test
        void testDelete() throws NotFoundException, InvalidDataException {
            doNothing().when(srv).deleteById(any());
            rest.delete(1);
            verify(srv).deleteById(1);
        }
    }
}