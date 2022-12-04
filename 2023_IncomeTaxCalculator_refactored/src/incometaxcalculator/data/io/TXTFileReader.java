package incometaxcalculator.data.io;

public class TXTFileReader extends FileReader {

  protected int getReceiptId(String[] values) {
    int receiptId;
    if (values[0].equals("Receipt")) {
      if (values[1].equals("ID:")) {
        receiptId = Integer.parseInt(values[2].trim());
        return receiptId;
      }
    }
    return -1;
  }

  protected String getValues(String[] values) {
    values[1] = values[1].trim();
    return values[1];
  }
}