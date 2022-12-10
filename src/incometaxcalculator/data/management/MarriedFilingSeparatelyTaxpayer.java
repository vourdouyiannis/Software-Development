package incometaxcalculator.data.management;

import java.util.ArrayList;

public class MarriedFilingSeparatelyTaxpayer extends Taxpayer {

  public MarriedFilingSeparatelyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    super.incomeCategory = new ArrayList<>();
    super.incomeCategory.add(0.0f);
    super.incomeCategory.add(18040.0f);
    super.incomeCategory.add(71680.0f);
    super.incomeCategory.add(90000.0f);
    super.incomeCategory.add(127120.0f);
    float inf = Float.POSITIVE_INFINITY;
    super.incomeCategory.add(inf);

    super.percentages  = new ArrayList<>();
    super.percentages.add(0.0535f);
    super.percentages.add(0.0705f);
    super.percentages.add(0.0785f);
    super.percentages.add(0.0785f);
    super.percentages.add(0.0985f);

    super.minimumTax = new ArrayList<>();
    super.minimumTax.add(0.0f);
    super.minimumTax.add(965.14f);
    super.minimumTax.add(4746.74f);
    super.minimumTax.add(6184.88f);
    super.minimumTax.add(9098.80f);
  }
}