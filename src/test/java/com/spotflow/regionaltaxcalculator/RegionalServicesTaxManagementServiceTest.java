package com.spotflow.regionaltaxcalculator;

import com.spotflow.regionaltaxcalculator.data.dto.request.CalculateTaxRequest;
import com.spotflow.regionaltaxcalculator.data.dto.response.CalculateTaxResponse;
import com.spotflow.regionaltaxcalculator.data.repository.RegionRepository;
import com.spotflow.regionaltaxcalculator.data.repository.ServicesRepository;
import com.spotflow.regionaltaxcalculator.service.RegionalServiceTaxManagementService;
import com.spotflow.regionaltaxcalculator.util.RegionalTaxCalculatorException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RegionalServicesTaxManagementServiceTest {
    @Autowired
    private RegionalServiceTaxManagementService regionalServiceTaxManagementService;

    @Autowired
    private RegionRepository regionRepository;


    @Autowired
    private ServicesRepository servicesRepository;

    private CalculateTaxRequest calculateTaxRequest = new CalculateTaxRequest();

    @Test
    public void testThatDataExistsInTheServicesRepository() {
        assertFalse(servicesRepository.findAll().isEmpty());
    }
    @Test
    public void testThatDataExistInTheRegionRepository() {
        assertFalse(regionRepository.findAll().isEmpty());
    }

    @Test
    public void testThatTaxCanBeCalculatedBasedOnTheSelectedRegion() {
        calculateTaxRequest.setServiceCode(5888);
        assertEquals("$630.5",regionalServiceTaxManagementService.calculateTax(calculateTaxRequest,1L).getTotalPrice());
    }
 @Test
    public void testThatTaxCanBeCalculatedBasedOnTheSelectedRegionAndAllResponseFieldIsCorrect() {
        calculateTaxRequest.setServiceCode(5888);
        CalculateTaxResponse calculateTaxResponse = regionalServiceTaxManagementService.calculateTax(calculateTaxRequest,1L);
        assertEquals("$630.5",calculateTaxResponse.getTotalPrice());
        assertEquals("$0.5", calculateTaxResponse.getImportDuty());
        assertEquals("$30.0",calculateTaxResponse.getGovernmentTax());
        assertEquals("$600.0",calculateTaxResponse.getServicePrice());
    }
    @Test
    public void testThatTotalPriceOfTheSameServiceAfterTaxCalculationDiffersFromRegionToRegion() {
        calculateTaxRequest.setServiceCode(5888);
        String totalPriceOne = regionalServiceTaxManagementService.calculateTax(calculateTaxRequest,1L).getTotalPrice();
        String totalPriceTwo = regionalServiceTaxManagementService.calculateTax(calculateTaxRequest,3L).getTotalPrice();
        assertNotEquals(totalPriceOne,totalPriceTwo);
    }
 @Test
    public void testThatExceptionIsThrownWhenAnEmptyRequestIsGivenToCalculateTax() {
        calculateTaxRequest = null;
       assertThrows(RegionalTaxCalculatorException.class, () -> regionalServiceTaxManagementService.calculateTax(calculateTaxRequest,1L));
    }
@Test
    public void testThatExceptionIsThrownWhenAnInvalidRegionIdIsGivenToCalculateTax() {
        calculateTaxRequest.setServiceCode(5888);
       assertThrows(RegionalTaxCalculatorException.class, () -> regionalServiceTaxManagementService.calculateTax(calculateTaxRequest,22L));
    }
@Test
    public void testThatExceptionIsThrownWhenAnInvalidOrNonExistingServiceCodeIsGivenCalculateTax() {
        calculateTaxRequest.setServiceCode(588856788);
       assertThrows(RegionalTaxCalculatorException.class, () -> regionalServiceTaxManagementService.calculateTax(calculateTaxRequest,22L));
    }

}
