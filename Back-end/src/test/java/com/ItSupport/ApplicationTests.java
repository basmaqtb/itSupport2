package com.ItSupport;

import com.ItSupport.DTO.EquipementDTO;
import com.ItSupport.Dao.EquipementRepository;
import com.ItSupport.Mappers.EquipementMapper;
import com.ItSupport.Models.Enums.EtatEquipement;
import com.ItSupport.Models.Equipement;
import com.ItSupport.Services.EquipementService;
import com.ItSupport.exception.EquipmentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipementServiceTest {

    @InjectMocks
    private EquipementService equipementService;

    @Mock
    private EquipementRepository equipementRepository;

    @Mock
    private EquipementMapper equipementMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateEquipment() {
        EquipementDTO equipmentDto = new EquipementDTO();
        Equipement equipment = new Equipement();
        when(equipementMapper.toEntity(equipmentDto)).thenReturn(equipment);
        when(equipementRepository.save(equipment)).thenReturn(equipment);

        Equipement createdEquipment = equipementService.createEquipment(equipmentDto);

        assertNotNull(createdEquipment);
        assertEquals(EtatEquipement.Disponible, createdEquipment.getEtat());
        verify(equipementRepository, times(1)).save(equipment);
    }

    @Test
    void testGetAllEquipments() {
        Equipement equipment1 = new Equipement();
        Equipement equipment2 = new Equipement();
        when(equipementRepository.findAll()).thenReturn(List.of(equipment1, equipment2));

        List<Equipement> equipments = equipementService.getAllEquipments();

        assertNotNull(equipments);
        assertEquals(2, equipments.size());
    }

    @Test
    void testGetEquipmentById() {
        Long id = 1L;
        Equipement equipment = new Equipement();
        when(equipementRepository.findById(id)).thenReturn(Optional.of(equipment));

        Equipement foundEquipment = equipementService.getEquipmentById(id);

        assertNotNull(foundEquipment);
        assertEquals(equipment, foundEquipment);
    }

    @Test
    void testDeleteEquipment() {
        Long id = 1L;
        Equipement equipment = new Equipement();
        when(equipementRepository.findById(id)).thenReturn(Optional.of(equipment));

        equipementService.deleteEquipment(id);

        verify(equipementRepository, times(1)).delete(equipment);
    }

    @Test
    void testAssignEquipmentToClient() {
        Long equipmentId = 1L;
        Long clientId = 1L;
        Equipement equipment = new Equipement();
        when(equipementRepository.findById(equipmentId)).thenReturn(Optional.of(equipment));
        when(equipementRepository.save(equipment)).thenReturn(equipment);

        Equipement assignedEquipment = equipementService.assignEquipmentToClient(equipmentId, clientId);

        assertNotNull(assignedEquipment);
        assertEquals(EtatEquipement.Disponible, assignedEquipment.getEtat());
        verify(equipementRepository, times(1)).save(equipment);
    }
}
