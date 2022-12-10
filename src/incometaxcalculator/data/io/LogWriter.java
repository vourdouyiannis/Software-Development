package incometaxcalculator.data.io;

import incometaxcalculator.data.management.TaxpayerManager;

import java.io.IOException;
import java.io.PrintWriter;

public abstract class LogWriter implements FileWriter{
    public abstract String getFileType();
    public abstract String[] dataToString(int taxRegistrationNumber);

    public void generateFile(int taxRegistrationNumber) throws IOException {
        TaxpayerManager manager = new TaxpayerManager();
        String [] fileData = dataToString(taxRegistrationNumber);

        PrintWriter outputStream = new PrintWriter(new java.io.FileWriter(taxRegistrationNumber + getFileType()));

        for (int row=0; row < fileData.length; row++) {
            if(row == 4) {
                if (manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0) {
                    outputStream.println(fileData[row]);
                    row++;
                } else {
                    outputStream.println(fileData[row + 1]);
                    row++;
                }
            }
            else {
                outputStream.println(fileData[row]);
            }
        }
        outputStream.close();
    }
}
