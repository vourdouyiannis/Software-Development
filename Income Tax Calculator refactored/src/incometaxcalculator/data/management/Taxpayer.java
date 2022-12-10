package incometaxcalculator.data.management;

import java.util.*;

import incometaxcalculator.exceptions.WrongReceiptKindException;

public abstract class Taxpayer {
  protected final String fullname;
  protected final int taxRegistrationNumber;
  protected final float income;
  private int totalReceiptsGathered = 0;
  private HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);
  protected ArrayList<Float> incomeCategory = new ArrayList<>();
  protected ArrayList<Float> percentages = new ArrayList<>();
  protected ArrayList<Float> minimumTax = new ArrayList<>();

  private Map<String, Integer> receiptKinds = Map.ofEntries(
          Map.entry("Entertainment" , 0),
          Map.entry("Basic" , 1),
          Map.entry("Travel" , 2),
          Map.entry("Health" , 3),
          Map.entry("Other" , 4));

  private float amountPerReceiptsKind[] = new float[receiptKinds.size()];

  public double calculateBasicTax() {
    double basicTax;
    for(int i = 1; i < this.incomeCategory.size(); i++) {
      if(this.income < incomeCategory.get(i) ) {
        basicTax = minimumTax.get(i-1) + percentages.get(i-1) * (this.income - incomeCategory.get(i-1));
        return basicTax;
      }
    }
    return 0.0;
  }

  protected Taxpayer(String fullname, int taxRegistrationNumber, float income) {
    this.fullname = fullname;
    this.taxRegistrationNumber = taxRegistrationNumber;
    this.income = income;
  }

  public void addReceipt(Receipt receipt) throws WrongReceiptKindException {

    if(this.receiptKinds.containsKey(receipt.getKind()) ) { // if the key (receipt.getKind()) exists in hash map:
      amountPerReceiptsKind[receiptKinds.get(receipt.getKind())] += receipt.getAmount(); // add the amount
    }//end of for
    else {
      throw new WrongReceiptKindException();
    }
    receiptHashMap.put(receipt.getId(), receipt);
    totalReceiptsGathered++;
  }//end of method

  public void removeReceipt(int receiptId) throws WrongReceiptKindException {
    Receipt receipt = receiptHashMap.get(receiptId);
    if(this.receiptKinds.containsKey(receipt.getKind()) ) { // if the key (receipt.getKind()) exists in hash map:
      amountPerReceiptsKind[receiptKinds.get(receipt.getKind())] -= receipt.getAmount(); // remove the amount
    }//end of for
    else {
      throw new WrongReceiptKindException();
    }
    totalReceiptsGathered--;
    receiptHashMap.remove(receiptId);
  }

  public String getFullname() {
    return fullname;
  }

  public int getTaxRegistrationNumber() {
    return taxRegistrationNumber;
  }

  public float getIncome() {
    return income;
  }

  public HashMap<Integer, Receipt> getReceiptHashMap() {
    return receiptHashMap;
  }

  public double getVariationTaxOnReceipts() {
    float totalAmountOfReceipts = getTotalAmountOfReceipts();

    ArrayList<Float> percentages = new ArrayList<>(Arrays.asList(0.2f, 0.4f, 0.6f));
    ArrayList<Float> tax = new ArrayList<>(Arrays.asList(0.08f, 0.04f, -0.15f));

    for(int i=0; i<percentages.size(); i++) {
      if(totalAmountOfReceipts < percentages.get(i) * income) {
        double basicTax = calculateBasicTax() * tax.get(i); // Calculating the basic tax
        double rounded = (double) Math.round(basicTax * 100000) / 100000; // The basic tax rounded to 4 decimals
        return rounded;
      }
    }//end of for
    double basicTax = calculateBasicTax() * -0.3; // Calculating the basic tax
    double rounded = (double) Math.round(basicTax * 100000) / 100000; // The basic tax rounded to 4 decimals
    return rounded;
  }

  private float getTotalAmountOfReceipts() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += amountPerReceiptsKind[i];
    }
    return sum;
  }

  public int getTotalReceiptsGathered() {
    return totalReceiptsGathered;
  }

  public float getAmountOfReceiptKind(short kind) {
    return amountPerReceiptsKind[kind];
  }

  public double getTotalTax() {
    return calculateBasicTax() + getVariationTaxOnReceipts();
  }

  public double getBasicTax() {
    return calculateBasicTax();
  }

}