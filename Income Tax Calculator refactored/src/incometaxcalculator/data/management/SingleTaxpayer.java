package incometaxcalculator.data.management;

import java.util.ArrayList;

public class SingleTaxpayer extends Taxpayer {

  public SingleTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    super.incomeCategory = new ArrayList<>();
    super.incomeCategory.add(0.0f);
    super.incomeCategory.add(24680.0f);
    super.incomeCategory.add(81080.0f);
    super.incomeCategory.add(90000.0f);
    super.incomeCategory.add(152540.0f);
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
    super.minimumTax.add(1320.38f);
    super.minimumTax.add(5296.58f);
    super.minimumTax.add(5996.80f);
    super.minimumTax.add(10906.19f);
  }
}