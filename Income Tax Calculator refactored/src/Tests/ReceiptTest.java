package Tests;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReceiptTest {

    @Test
    public void createReceiptTest()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException {
        int receiptId = 1;
        String issueDate= "30/02/2022";
        float amount = 1000.40f;
        String kind = "Basic";
        String companyName = "uoi";
        String country="Greece";
        String city= "Ioannina";
        String street= "Dodonhs";
        int number= 0;
        int taxRegistrationNumber= 111111111;
        String taxRegistrationNumberTxtFile = taxRegistrationNumber + "_INFO.txt";

        TaxpayerManager tmanager = new TaxpayerManager();

        tmanager.loadTaxpayer(taxRegistrationNumberTxtFile);
        tmanager.createReceipt(receiptId,  issueDate,  amount,  kind, companyName,  country,  city,  street,  number, taxRegistrationNumber);

        assertTrue(tmanager.containsReceipt(receiptId));
    } //end method

    @Test
    public void removeReceiptTest()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException {
        int receiptId = 2;
        String issueDate= "30/02/2022";
        float amount = 1000.40f;
        String kind = "Basic";
        String companyName = "uoi";
        String country="Greece";
        String city= "Ioannina";
        String street= "Dodonhs";
        int number= 0;
        int taxRegistrationNumber= 111111111;
        String taxRegistrationNumberTxtFile = taxRegistrationNumber + "_INFO.txt";

        TaxpayerManager tmanager = new TaxpayerManager();

        tmanager.loadTaxpayer(taxRegistrationNumberTxtFile);
        tmanager.createReceipt(receiptId,  issueDate,  amount,  kind, companyName,  country,  city,  street,  number, taxRegistrationNumber);
        tmanager.removeReceipt(receiptId);

        assertFalse(tmanager.containsReceipt(receiptId));
    } //end method

    @Test
    public void updateTxtFilesTest()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        int receiptId = 4;
        String issueDate= "30/02/2022";
        float amount = 1000.40f;
        String kind = "Basic";
        String companyName = "uoi";
        String country="Greece";
        String city= "Ioannina";
        String street= "Dodonhs";
        int number= 0;
        int taxRegistrationNumber= 111111111;
        String taxRegistrationNumberTxtFile = taxRegistrationNumber + "_INFO.txt";
        String expectedResult = "Name: Apostolos Zarras\r\n"
                + "AFM: 111111111\r\n"
                + "Status: Married Filing Jointly\r\n"
                + "Income: 22000.0\r\n"
                + "\r\n"
                + "Receipts:\r\n"
                + "\r\n"
                + "Receipt ID: 4\r\n"
                + "Date: 30/2/2022\r\n"
                + "Kind: Basic\r\n"
                + "Amount: 1000.4\r\n"
                + "Company: uoi\r\n"
                + "Country: Greece\r\n"
                + "City: Ioannina\r\n"
                + "Street: Dodonhs\r\n"
                + "Number: 0\r\n"
                + "\r\n";

        TaxpayerManager tmanager = new TaxpayerManager();

        tmanager.loadTaxpayer(taxRegistrationNumberTxtFile);
        tmanager.addReceipt(receiptId,  issueDate,  amount,  kind, companyName,  country,  city,  street,  number, taxRegistrationNumber);

        Path fileName = Path.of(taxRegistrationNumberTxtFile);
        String actualResult = Files.readString(fileName);

        tmanager.removeReceipt(receiptId);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateXmlFilesTest()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        int receiptId = 5;
        String issueDate= "30/02/2022";
        float amount = 1000.40f;
        String kind = "Basic";
        String companyName = "uoi";
        String country="Greece";
        String city= "Ioannina";
        String street= "Dodonhs";
        int number= 0;
        int taxRegistrationNumber= 111111111;
        String taxRegistrationNumberXmlFile = taxRegistrationNumber + "_INFO.xml";
        String expectedResult = "<Name> Apostolos Zarras </Name>\r\n" +
                "<AFM> 111111111 </AFM>\r\n" +
                "<Status> Married Filing Jointly </Status>\r\n" +
                "<Income> 22000.0 </Income>\r\n" +
                "\r\n" +
                "<Receipts>\r\n" +
                "\r\n" +
                "<ReceiptID> 5 </ReceiptID>\r\n" +
                "<Date> 30/2/2022 </Date>\r\n" +
                "<Kind> Basic </Kind>\r\n" +
                "<Amount> 1000.4 </Amount>\r\n" +
                "<Company> uoi </Company>\r\n" +
                "<Country> Greece </Country>\r\n" +
                "<City> Ioannina </City>\r\n" +
                "<Street> Dodonhs </Street>\r\n" +
                "<Number> 0 </Number>\r\n" +
                "\r\n";

        TaxpayerManager tmanager = new TaxpayerManager();

        tmanager.loadTaxpayer(taxRegistrationNumberXmlFile);
        tmanager.addReceipt(receiptId,  issueDate,  amount,  kind, companyName,  country,  city,  street,  number, taxRegistrationNumber);


        Path fileName = Path.of(taxRegistrationNumberXmlFile);
        String actualResult = Files.readString(fileName);
        tmanager.removeReceipt(receiptId);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void saveLogTxtFilesTest()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        int receiptId = 6;
        String issueDate= "30/02/2022";
        float amount = 1000.40f;
        String kind = "Basic";
        String companyName = "uoi";
        String country="Greece";
        String city= "Ioannina";
        String street= "Dodonhs";
        int number= 0;
        int taxRegistrationNumber= 111111111;
        String taxRegistrationNumberTxtFile = taxRegistrationNumber + "_INFO.txt";
        String taxRegistrationNumberLogFile = taxRegistrationNumber + "_LOG.txt";
        String expectedResult = "Name: Apostolos Zarras\r\n" +
                "AFM: 111111111\r\n" +
                "Income: 22000.0\r\n" +
                "Basic Tax: 1177.0\r\n" +
                "Tax Increase: 94.16\r\n" +
                "Total Tax: 1271.16\r\n" +
                "TotalReceiptsGathered: 1\r\n" +
                "Entertainment: 0.0\r\n" +
                "Basic: 1000.4\r\n" +
                "Travel: 0.0\r\n" +
                "Health: 0.0\r\n" +
                "Other: 0.0\r\n";

        TaxpayerManager tmanager = new TaxpayerManager();

        tmanager.loadTaxpayer(taxRegistrationNumberTxtFile);
        tmanager.addReceipt(receiptId,  issueDate,  amount,  kind, companyName,  country,  city,  street,  number, taxRegistrationNumber);
        tmanager.saveLogFile(taxRegistrationNumber, "txt");

        Path fileName = Path.of(taxRegistrationNumberLogFile);
        String actualResult = Files.readString(fileName);
        tmanager.removeReceipt(receiptId);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void saveLogXmlFilesTest()
            throws WrongReceiptKindException, WrongFileFormatException, IOException, WrongFileEndingException,
            WrongTaxpayerStatusException, WrongReceiptDateException, ReceiptAlreadyExistsException {
        int receiptId = 7;
        String issueDate= "30/02/2022";
        float amount = 1000.40f;
        String kind = "Basic";
        String companyName = "uoi";
        String country="Greece";
        String city= "Ioannina";
        String street= "Dodonhs";
        int number= 0;
        int taxRegistrationNumber= 111111111;
        String taxRegistrationNumberXmlFile = taxRegistrationNumber + "_INFO.xml";
        String taxRegistrationNumberLogFile = taxRegistrationNumber + "_LOG.xml";
        String expectedResult = "<Name> Apostolos Zarras </Name>\r\n" +
                "<AFM> 111111111 </AFM>\r\n" +
                "<Income> 22000.0 </Income>\r\n" +
                "<BasicTax> 1177.0 </BasicTax>\r\n" +
                "<TaxIncrease> 94.16 </TaxIncrease>\r\n" +
                "<TotalTax> 1271.16 </TotalTax>\r\n" +
                "<Receipts> 1 </Receipts>\r\n" +
                "<Entertainment> 0.0 </Entertainment>\r\n" +
                "<Basic> 1000.4 </Basic>\r\n" +
                "<Travel> 0.0 </Travel>\r\n" +
                "<Health> 0.0 </Health>\r\n" +
                "<Other> 0.0 </Other>\r\n";

        TaxpayerManager tmanager = new TaxpayerManager();

        tmanager.loadTaxpayer(taxRegistrationNumberXmlFile);
        tmanager.addReceipt(receiptId,  issueDate,  amount,  kind, companyName,  country,  city,  street,  number, taxRegistrationNumber);
        tmanager.saveLogFile(taxRegistrationNumber, "xml");

        Path fileName = Path.of(taxRegistrationNumberLogFile);
        String actualResult = Files.readString(fileName);
        tmanager.removeReceipt(receiptId);

        assertEquals(expectedResult, actualResult);
    }
}
