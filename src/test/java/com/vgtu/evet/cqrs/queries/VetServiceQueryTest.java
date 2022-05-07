package com.vgtu.evet.cqrs.queries;

import com.vgtu.evet.entities.vetServices.VetService;
import com.vgtu.evet.repository.VetServiceRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class VetServiceQueryTest {

    private static final String SERVICE_NAME_1 = "General check up";
    private static final String SERVICE_NAME_2 = "Dental check up";

    private VetService vetService1;
    private VetService vetService2;

    private List<VetService> vetServiceList;

    @MockBean
    private VetServiceRepository vetServiceRepository;

    @Autowired
    private VetServiceQuery vetServiceQuery;

    @BeforeEach
    void setUp() {
        vetService1 = VetService.builder().id(1).name(SERVICE_NAME_1).build();
        vetService2 = VetService.builder().id(2).name(SERVICE_NAME_2).build();

        vetServiceList = new ArrayList<>();
        vetServiceList.add(vetService1);
        vetServiceList.add(vetService2);

        Mockito.when(vetServiceRepository.findAll()).thenReturn(vetServiceList);
    }


    @Test
    void checkGetServices() {
        Assert.assertEquals(List.of(vetService1, vetService2),
                vetServiceQuery.getVetServices());
    }

}
