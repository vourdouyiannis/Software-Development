package incometaxcalculator.data.management;

import java.util.ArrayList;

public class HeadOfHouseholdTaxpayer extends Taxpayer {

  public HeadOfHouseholdTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    super.incomeCategory = new ArrayList<>();
    super.incomeCategory.add(0.0f);
    super.incomeCategory.add(30390.0f);
    super.incomeCategory.add(90000.0f);
    super.incomeCategory.add(122110.0f);
    super.incomeCategory.add(203390.0f);
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
    super.minimumTax.add(1625.87f);
    super.minimumTax.add(5828.38f);
    super.minimumTax.add(8092.13f);
    super.minimumTax.add(14472.61f);
  }
}
