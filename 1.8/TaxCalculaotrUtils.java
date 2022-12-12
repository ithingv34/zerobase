/**
 * zerobase
 * 과제8: 연소득 과세 금액 계산 프로그램
 * 작성자: 이상훈 (ithingv34)
 * 날짜: 2022/12/12
 */
public class TaxCalculaotrUtils {
    public static class IncomeTaxInfo {
        private final int tax; // 과세
        private final double rates; // 세율
        private final int progressiveDeduction; // 누진공제

        public IncomeTaxInfo(int tax, double rates, int progressiveDeduction) {
            this.tax = tax;
            this.rates = rates;
            this.progressiveDeduction = progressiveDeduction;
        }

        public int getTax() {
            return tax;
        }

        public double getRates() {
            return rates;
        }

        public int getProgressiveDeduction() {
            return progressiveDeduction;
        }
    }

    public static final IncomeTaxInfo[] taxRates = {
            new IncomeTaxInfo(12000000, 0.06, 0),
            new IncomeTaxInfo(34000000, 0.15, 1080000),
            new IncomeTaxInfo(42000000, 0.24, 5220000),
            new IncomeTaxInfo(62000000, 0.35, 14900000),
            new IncomeTaxInfo(150000000, 0.38, 19400000),
            new IncomeTaxInfo(200000000, 0.4, 25400000),
            new IncomeTaxInfo(500000000, 0.42, 35400000),
            new IncomeTaxInfo(1000000000, 0.45, 65400000)
    };

    // 2. 종합소득세율표를 통한 조건 생성
    public static int getTaxRatesRangeIdx(long annualIncome) {
        if (annualIncome <= 12000000)
            return 0;
        else if (annualIncome > 12000000 && annualIncome <= 46000000)
            return 1;
        else if (annualIncome > 46000000 && annualIncome <= 88000000)
            return 2;
        else if (annualIncome > 88000000 && annualIncome <= 150000000)
            return 3;
        else if (annualIncome > 150000000 && annualIncome <= 300000000)
            return 4;
        else if (annualIncome > 300000000 && annualIncome <= 500000000)
            return 5;
        else if (annualIncome > 500000000 && annualIncome <= 1000000000)
            return 6;
        else if (annualIncome > 1000000000)
            return 7;
        else
            return -1;
    }
}
