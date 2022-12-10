package incometaxcalculator.data.io;

import incometaxcalculator.data.management.TaxpayerManager;

public class XMLLogWriter extends LogWriter {

  private static final short ENTERTAINMENT = 0;
  private static final short BASIC = 1;
  private static final short TRAVEL = 2;
  private static final short HEALTH = 3;
  private static final short OTHER = 4;

  public String getFileType() { return "_LOG.xml"; }

  public String[] dataToString(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();

    String[] data = {"<Name> " + manager.getTaxpayerName(taxRegistrationNumber) + " </Name>", "<AFM> " + taxRegistrationNumber + " </AFM>",
            "<Income> " + manager.getTaxpayerIncome(taxRegistrationNumber) + " </Income>", "<BasicTax> " + manager.getTaxpayerBasicTax(taxRegistrationNumber) + " </BasicTax>",
            "<TaxIncrease> " + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + " </TaxIncrease>", "<TaxDecrease> " + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + " </TaxDecrease>",
            "<TotalTax> " + manager.getTaxpayerTotalTax(taxRegistrationNumber) + " </TotalTax>", "<Receipts> " + manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber) + " </Receipts>",
            "<Entertainment> " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT) + " </Entertainment>", "<Basic> " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC) + " </Basic>",
            "<Travel> " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL) + " </Travel>", "<Health> " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH) + " </Health>",
            "<Other> " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER) + " </Other>"};
    return data;
  }
}
