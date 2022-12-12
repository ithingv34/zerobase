import java.util.ArrayList;
import java.util.Scanner;

/**
 * zerobase
 * 과제8: 연소득 과세 금액 계산 프로그램
 * 작성자: 이상훈 (ithingv34)
 * 날짜: 2022/12/12
 */

public class Problem8 {

    public static void calcTaxByRate(long annualIncome) {
        int taxRatesRangeIdx = TaxCalculaotrUtils.getTaxRatesRangeIdx(annualIncome);
        int taxSum = 0;
        double rate = 0;
        long tax = 0;
        long money = 0;
        long totalTax = 0;

        for (int i = 0; i < taxRatesRangeIdx; i++) {
            rate = TaxCalculaotrUtils.taxRates[i].getRates();
            tax = TaxCalculaotrUtils.taxRates[i].getTax();
            money = (int) (rate * tax);
            totalTax += money;
            taxSum += tax;

            System.out.printf("\t%d * %d%% = \t %d\n", tax, (int) (rate * 100), money);
        }

        tax = annualIncome - taxSum;
        rate = TaxCalculaotrUtils.taxRates[taxRatesRangeIdx].getRates();
        money = (int) (rate * tax);
        totalTax += money;

        System.out.printf("\t%d * %d%% = \t %d\n", tax, (int) (rate * 100), money);
        System.out.println("\n");
        System.out.printf("[세율에 의한 세금]: \t\t\t %d\n", totalTax);
    }

    public static void calcTaxByDeduction(long annualIncome){

        int taxRatesRangeIdx = TaxCalculaotrUtils.getTaxRatesRangeIdx(annualIncome);
        double taxRate = TaxCalculaotrUtils.taxRates[taxRatesRangeIdx].getRates();
        int deduction = TaxCalculaotrUtils.taxRates[taxRatesRangeIdx].getProgressiveDeduction();
        long totalTax = (long) (annualIncome * taxRate) - deduction;

        System.out.format("[누진공제 계산에 의한 세금]: \t %d\n", totalTax);
    }

    public static void main(String[] args) {
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요:");

        Scanner sc = new Scanner(System.in);

        // 1. 연소득 금액 입력
        long annualIncome = sc.nextLong();

        calcTaxByRate(annualIncome); // 세율에 의한 세금 계산
        calcTaxByDeduction(annualIncome); // 누진공제 계산에 의한 세금 계산
    }
}
