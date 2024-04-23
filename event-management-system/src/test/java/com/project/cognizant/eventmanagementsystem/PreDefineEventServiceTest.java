package com.project.cognizant.eventmanagementsystem;

import com.project.cognizant.eventmanagementsystem.Model.Cake;
import com.project.cognizant.eventmanagementsystem.Repository.CakeRepository;
import com.project.cognizant.eventmanagementsystem.Services.PreDefineEventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PreDefineEventServiceTest {

    @InjectMocks
    PreDefineEventService preDefineEventService;
    @Mock
    CakeRepository cakeRepository;

    @Test
    public void findCakeByIdTest(){
        //mock
        int cakeId = 1;
        Cake mockCake = new Cake();
        when(cakeRepository.findById(cakeId)).thenReturn(Optional.of(mockCake));

        //use
        Cake result = preDefineEventService.findCakeById(cakeId);
        assertNotNull(result);
        assertEquals(mockCake, result);
    }

    @Test
    public void addCakeTest(){
        Cake mockCake = new Cake();
        mockCake.setCakeName("blue berry cake");
        mockCake.setCakePrice(200);
        when(cakeRepository.save(mockCake)).thenReturn(mockCake);
        Cake cake =preDefineEventService.addCake(mockCake);
        assertNotNull(cake);
        assertEquals(mockCake,cake);
    }


}
