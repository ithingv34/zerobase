import java.util.Scanner;
/**
 * zerobase
 * 과제2: 결제 금액 캐시백 계산 프로그램
 * 작성자: 이상훈 (ithingv34)
 * 날짜: 2022/12/12
 */
public class Problem2 {
    public static void main(String[] args) {

        System.out.println("[캐시백 계산]");
        Scanner sc = new Scanner(System.in);
        int payment; // 결제금액

        do {
            System.out.print("결제 금액을 입력해 주세요.(금액):");
            while (!sc.hasNextInt()) {
                System.out.println("결제 금액을 제대로 입력해주세요.");
                sc.next();
            }
            payment = sc.nextInt();
        } while (payment <= 0); // 결제 금액은 0보다 커야한다.

        int cashback = payment / 1000 >= 3 ? 300 : (payment / 1000) * 100;

        System.out.println("결제 금액은 " + payment + "원이고, 캐시백은 " + cashback + "원 입니다.");

    }
}
