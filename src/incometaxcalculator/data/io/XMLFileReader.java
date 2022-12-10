package incometaxcalculator.data.io;

public class XMLFileReader extends FileReader {

  protected int getReceiptId(String[] values) {
    int receiptId;
    if (values[0].equals("<ReceiptID>")) {
      receiptId = Integer.parseInt(values[1].trim());
      return receiptId;
    }
    return -1;
  }

  protected String getValues(String[] values) {
    String valueReversed[] = new StringBuilder(values[1]).reverse().toString().trim().split(" ", 2);
    return new StringBuilder(valueReversed[1]).reverse().toString();
  }
}
