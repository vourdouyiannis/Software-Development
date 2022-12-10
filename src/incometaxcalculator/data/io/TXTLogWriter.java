package incometaxcalculator.data.io;

import incometaxcalculator.data.management.TaxpayerManager;

public class TXTLogWriter extends LogWriter {

  private static final short ENTERTAINMENT = 0;
  private static final short BASIC = 1;
  private static final short TRAVEL = 2;
  private static final short HEALTH = 3;
  private static final short OTHER = 4;

  public String getFileType() { return "_LOG.txt"; }

  public String[] dataToString(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();

    String[] data = {"Name: " + manager.getTaxpayerName(taxRegistrationNumber), "AFM: " + taxRegistrationNumber,
            "Income: " + manager.getTaxpayerIncome(taxRegistrationNumber), "Basic Tax: " + manager.getTaxpayerBasicTax(taxRegistrationNumber),
            "Tax Increase: " + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber), "Tax Decrease: " + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber),
            "Total Tax: " + manager.getTaxpayerTotalTax(taxRegistrationNumber), "TotalReceiptsGathered: " + manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber),
            "Entertainment: " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT), "Basic: " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC),
            "Travel: " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL), "Health: " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH),
            "Other: " + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER)};
    return data;
  }

}
