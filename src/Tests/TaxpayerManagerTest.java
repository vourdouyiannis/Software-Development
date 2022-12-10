package Tests;

import incometaxcalculator.data.management.Taxpayer;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.*;
import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaxpayerManagerTest {

    @Test
    public void loadTaxpayerTest() {
        int taxRegistrationNumber = 111111111;
        String taxRegistrationNumberTxtFile = taxRegistrationNumber + "_INFO.txt";
        String taxRegistrationNumberXmlFile = taxRegistrationNumber + "_INFO.xml";
        TaxpayerManager taxpayerManager = new TaxpayerManager();
        Exception error = null;
        try{
            taxpayerManager.loadTaxpayer(taxRegistrationNumberTxtFile);
            taxpayerManager.loadTaxpayer(taxRegistrationNumberXmlFile);
        }
        catch (Exception e){
            error = e;
        }
        assertNull(error);
    } //end method

    @Test
    public void selectTaxpayerTestHappyScenario()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException {
        int taxRegistrationNumber= 111111111;
        String taxRegistrationNumberTxtFile = taxRegistrationNumber + "_INFO.txt";

        TaxpayerManager tmanager = new TaxpayerManager();
        tmanager.loadTaxpayer(taxRegistrationNumberTxtFile);

        Taxpayer selectedTaxpayer = tmanager.getTaxpayer(taxRegistrationNumber);
        assertEquals(taxRegistrationNumber, selectedTaxpayer.getTaxRegistrationNumber());
    } //end method

    @Test
    public void selectTaxpayerTestBadScenario()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException {
        int taxRegistrationNumber= 111111111;
        int taxRegistrationNumberThatDontExist = 101010101;
        String taxRegistrationNumberTxtFile = taxRegistrationNumber + "_INFO.txt";

        TaxpayerManager tmanager = new TaxpayerManager();
        tmanager.loadTaxpayer(taxRegistrationNumberTxtFile);

        Taxpayer selectedTaxpayer = tmanager.getTaxpayer(taxRegistrationNumberThatDontExist);
        assertNull(null, selectedTaxpayer);
    } //end method

    @Test
    public void deleteTaxpayerTest()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException {
        int taxRegistrationNumber= 111111111;
        String taxRegistrationNumberTxtFile = taxRegistrationNumber + "_INFO.txt";

        TaxpayerManager tmanager = new TaxpayerManager();
        tmanager.loadTaxpayer(taxRegistrationNumberTxtFile);
        assertTrue(tmanager.containsTaxpayer(taxRegistrationNumber));

        tmanager.containsTaxpayer(taxRegistrationNumber);
        tmanager.removeTaxpayer(taxRegistrationNumber);
        assertFalse(tmanager.containsTaxpayer(taxRegistrationNumber));
    } //end method
}//end class
