package incometaxcalculator.data.io;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public class XMLInfoWriter extends InfoWriter {
  public String getFileType(){
    return "_INFO.xml";
  }

  public String[] taxpayerDataToString(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();

    String[] data = {"<Name> " + manager.getTaxpayerName(taxRegistrationNumber) + " </Name>", "<AFM> " + taxRegistrationNumber + " </AFM>",
            "<Status> " + manager.getTaxpayerStatus(taxRegistrationNumber) + " </Status>", "<Income> " + manager.getTaxpayerIncome(taxRegistrationNumber) + " </Income>",
            "", "<Receipts>", ""};
    return data;
  }

  public String[] receiptDataToString(Receipt receipt) {
    String[] data = {"<ReceiptID> " + getReceiptId(receipt) + " </ReceiptID>", "<Date> " + getReceiptIssueDate(receipt) + " </Date>",
            "<Kind> " + getReceiptKind(receipt) + " </Kind>", "<Amount> " + getReceiptAmount(receipt) + " </Amount>",
            "<Company> " + getCompanyName(receipt) + " </Company>", "<Country> " + getCompanyCountry(receipt) + " </Country>",
            "<City> " + getCompanyCity(receipt) + " </City>", "<Street> " + getCompanyStreet(receipt) + " </Street>",
            "<Number> " + getCompanyNumber(receipt) + " </Number>", ""};
    return data;
  }
}