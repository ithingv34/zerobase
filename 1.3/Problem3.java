// 놀이동산 입장권 계산 프로그램

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {

        System.out.println("[입장권 계산]");
        Scanner sc = new Scanner(System.in);

        // 나이
        System.out.print("나이를 입력해주세요.(숫자):");
        int age = sc.nextInt();

        // 입장시간
        System.out.print("입장시간을 입력해주세요.(숫자입력):");
        int entryTime = sc.nextInt();

        // 국가유공자 여부
        System.out.print("국가유공자 여부를 입력해주세요.(y/n):");
        char isNationalMerit = sc.next().charAt(0);

        // 복지카드
        System.out.print("복지카드 여부를 입력해주세요.(y/n):");
        char welfareCard = sc.next().charAt(0);

        int admissionFee = getAdmission(age, entryTime, isNationalMerit, welfareCard);

        System.out.println("입장료: " + admissionFee);
    }

    private static int getAdmission(int age, int entryTime, char isNationalMerit, char welfareCard) {

        // 나이 조건
        if (age < 3) {
            return 0;
        } else if (age < 13) {
            return 4000;
        }

        // 시간 조건 (특별할인)
        if (entryTime >= 17) {
            return 4000;
        }

        // 복지카드를 소유했거나 국가 유공자인 경우 일반할인
        if (isNationalMerit == 'y' || welfareCard == 'y') {
            return 8000;
        }

        // 기본 입장료
        return 10000;
    }
}
