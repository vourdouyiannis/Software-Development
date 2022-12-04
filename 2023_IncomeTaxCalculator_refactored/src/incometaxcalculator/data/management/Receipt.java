package incometaxcalculator.data.management;

import incometaxcalculator.exceptions.WrongReceiptDateException;

public class Receipt {

  private final int id;
  private final Date issueDate;
  private final float amount;
  private final String kind;
  private final Company company;

  public Receipt(int id, String issueDate, float amount, String kind, Company company)
      throws WrongReceiptDateException {
    this.id = id;
    this.issueDate = createDate(issueDate);
    this.amount = amount;
    this.kind = kind;
    this.company = company;
  }

  private Date createDate(String issueDate) throws WrongReceiptDateException {
    String token[] = issueDate.split("/");
    if (token.length != 3) {
      throw new WrongReceiptDateException();
    }
    int day = Integer.parseInt(token[0]);
    int month = Integer.parseInt(token[1]);
    int year = Integer.parseInt(token[2]);
    return new Date(day, month, year);
  }

  public int getId() {
    return id;
  }

  public String getIssueDate() {
    return issueDate.toString();
  }

  public float getAmount() {
    return amount;
  }

  public String getKind() {
    return kind;
  }

  public Company getCompany() {
    return company;
  }

  public String toString() { // Used for printing the receipt when you double-click on a receipt
    String receiptData = "\nReceipt ID: " + this.id + "\n" + "Date: " + this.issueDate.toString() + "\n" +
            "Kind: " + this.kind + "\n" + "Amount: " + this.amount + "\n" + "Company: " + this.company.getName() +
            "\n" + "Country: " + this.company.getCountry() + "\n" + "City: " + this.company.getCity() + "\n" +
            "Street: " + this.company.getStreet() + "\n" + "Number: " + this.company.getNumber();
    return receiptData;
  }//end of method
}