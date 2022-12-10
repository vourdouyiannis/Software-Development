package incometaxcalculator.data.io;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

public abstract class InfoWriter implements FileWriter {
    public abstract String getFileType();
    public abstract String[] taxpayerDataToString(int taxRegistrationNumber);
    public abstract String[] receiptDataToString(Receipt receipt);

    public void generateFile(int taxRegistrationNumber) throws IOException {
        String[] taxpayerData = taxpayerDataToString(taxRegistrationNumber);

        PrintWriter outputStream = new PrintWriter(
                new java.io.FileWriter(taxRegistrationNumber + getFileType()));

        for (String row : taxpayerData) {
            outputStream.println(row);
        }
        generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
        outputStream.close();
    }//end of method

    private void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {
        HashMap<Integer, Receipt> receiptsHashMap = getReceiptHashMap(taxRegistrationNumber);
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();

            String[] receiptsData = receiptDataToString(receipt);

            for (String row : receiptsData) {
                outputStream.println(row);
            }
        }
    }

    public HashMap<Integer, Receipt> getReceiptHashMap(int taxRegistrationNumber) {
        TaxpayerManager manager = new TaxpayerManager();
        return manager.getReceiptHashMap(taxRegistrationNumber);
    }

    public int getReceiptId(Receipt receipt) {
        return receipt.getId();
    }

    public String getReceiptIssueDate(Receipt receipt) {
        return receipt.getIssueDate();
    }

    public String getReceiptKind(Receipt receipt) {
        return receipt.getKind();
    }

    public float getReceiptAmount(Receipt receipt) {
        return receipt.getAmount();
    }

    public String getCompanyName(Receipt receipt) {
        return receipt.getCompany().getName();
    }

    public String getCompanyCountry(Receipt receipt) {
        return receipt.getCompany().getCountry();
    }

    public String getCompanyCity(Receipt receipt) {
        return receipt.getCompany().getCity();
    }

    public String getCompanyStreet(Receipt receipt) {
        return receipt.getCompany().getStreet();
    }

    public int getCompanyNumber(Receipt receipt) {
        return receipt.getCompany().getNumber();
    }
}
