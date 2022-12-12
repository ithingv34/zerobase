import java.util.Random;
import java.util.Scanner;

/**
 * zerobase
 * 과제 4: 주민등록번호 생성 프로그램
 * 작성자: 이상훈 (ithingv34)
 * 날짜: 2022/12/12
 *
 * 특이사항: 주민번호의 앞자리는 보통 6자리로 YYMMDD 이지만 문제에 나온 콘솔화면의 결과에 맞춰 YYYYMMDD로 출력하였습니다.
 */

public class Problem4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");

        // 출생년도
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        String birthYear = sc.next();

        // 출생월
        System.out.print("출생월을 입력해 주세요.(mm):");
        String birthMonth = sc.next();

        // 출생일
        System.out.print("출생일을 입력해 주세요.(dd):");
        String birthDay = sc.next();

        // 성별
        System.out.print("성별을 입력해 주세요.(m/f):");
        char gender = sc.next().charAt(0);

        String frontNum = birthYear + birthMonth + birthDay; // 주민번호 앞번호
        String backNum = getResidentialNum(birthYear, birthMonth, birthDay, gender); // 주민번호 뒷번호

        System.out.println(frontNum + "-" + backNum); // 주민번호 출력
    }

    private static String getResidentialNum(String birthYear, String birthMonth, String birthDay, char gender) {

        char seventhNum = getSeventhNum(birthYear, gender); // 성별, 외국인 유무에 의한 뒷자리 첫번째 번호
        String randomNum = getRandomNum(); // 나머지 6자리 랜덤번호 생성

        return seventhNum + randomNum;
    }

    private static String getRandomNum() {
        Random rnd = new Random();
        String res = "";

        for (int i = 0; i < 6; i++) {
            String rand = Integer.toString(rnd.nextInt(10));
            res += rand;
        }
        return res;
    }

    private static char getSeventhNum(String birthYear, char gender) {
        if (isBetween(birthYear, 1800, 1899)){
            return gender == 'm' ? '9' : '0';
        } else if (isBetween(birthYear, 1900, 1999)) {
            return gender == 'm' ? '1' : '2';
        } else  {
            return gender == 'm' ? '3' : '4';
        }
    }

    public static boolean isBetween(String birthYear, int lower, int upper) {
        int year = Integer.parseInt(birthYear);
        return lower <= year && year <= upper;
    }
}
