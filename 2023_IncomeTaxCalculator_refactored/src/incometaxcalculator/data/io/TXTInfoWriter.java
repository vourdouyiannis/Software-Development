package incometaxcalculator.data.io;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.data.management.Receipt;

public class TXTInfoWriter extends InfoWriter{
  public String getFileType(){
    return "_INFO.txt";
  }

  public String[] taxpayerDataToString(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();

    String[] data = {"Name: " + manager.getTaxpayerName(taxRegistrationNumber), "AFM: " + taxRegistrationNumber,
            "Status: " + manager.getTaxpayerStatus(taxRegistrationNumber), "Income: " + manager.getTaxpayerIncome(taxRegistrationNumber),
            "", "Receipts:", ""};
    return data;
  }

  public String[] receiptDataToString(Receipt receipt) {
    String[] data = {"Receipt ID: " + getReceiptId(receipt), "Date: " + getReceiptIssueDate(receipt),
            "Kind: " + getReceiptKind(receipt), "Amount: " + getReceiptAmount(receipt),
            "Company: " + getCompanyName(receipt), "Country: " + getCompanyCountry(receipt), "City: " + getCompanyCity(receipt),
            "Street: " + getCompanyStreet(receipt), "Number: " + getCompanyNumber(receipt), ""};
    return data;
  }
}