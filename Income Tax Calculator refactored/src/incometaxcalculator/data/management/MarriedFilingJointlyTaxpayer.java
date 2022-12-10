package incometaxcalculator.data.management;

import java.util.ArrayList;

public class MarriedFilingJointlyTaxpayer extends Taxpayer {

  public MarriedFilingJointlyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    super.incomeCategory = new ArrayList<>();
    super.incomeCategory.add(0.0f);
    super.incomeCategory.add(36080.0f);
    super.incomeCategory.add(90000.0f);
    super.incomeCategory.add(143350.0f);
    super.incomeCategory.add(254240.0f);
    float inf = Float.POSITIVE_INFINITY;
    super.incomeCategory.add(inf);

    super.percentages  = new ArrayList<>();
    super.percentages.add(0.0535f);
    super.percentages.add(0.0705f);
    super.percentages.add(0.0705f);
    super.percentages.add(0.0785f);
    super.percentages.add(0.0985f);

    super.minimumTax = new ArrayList<>();
    super.minimumTax.add(0.0f);
    super.minimumTax.add(1930.28f);
    super.minimumTax.add(5731.64f);
    super.minimumTax.add(9492.82f);
    super.minimumTax.add(18197.69f);
  }
}