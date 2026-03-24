package com.gal.cabservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import com.gal.cabservice.entity.Cab;
import com.gal.cabservice.repo.CabRepo;
import com.gal.cabservice.service.CabServiceImplementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CabServiceTest {

@Mock
private CabRepo cabRepo;

@InjectMocks
private CabServiceImplementation cabService;

private Cab cab;

@BeforeEach
void setUp() {
    cab = new Cab();
    cab.setId(1L);
    cab.setCabName("Swift");
    cab.setCabStatus(true);
}

@Test
void testAddCab() {
    when(cabRepo.save(any(Cab.class))).thenReturn(cab);

    cabService.addCab(cab);

    verify(cabRepo, times(1)).save(cab);
}

@Test
void testGetAllCabs() {
    List<Cab> cabList = Arrays.asList(cab);

    when(cabRepo.findAll()).thenReturn(cabList);

    List<Cab> result = cabService.getAllCabs();

    assertEquals(1, result.size());
    verify(cabRepo, times(1)).findAll();
}

@Test
void testGetCabById() {
    when(cabRepo.findById(1L)).thenReturn(Optional.of(cab));

    Optional<Cab> result = cabService.getById(1L);

    assertTrue(result.isPresent());
    assertEquals("Swift", result.get().getCabName());
}



}
