import java.util.Random;
import java.util.Scanner;

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

        String frontNum = birthYear + birthMonth + birthDay;
        String backNum = getResidentialNum(birthYear, birthMonth, birthDay, gender);

        System.out.println(frontNum + "-" + backNum);
    }

    private static String getResidentialNum(String birthYear, String birthMonth, String birthDay, char gender) {

        char seventhNum = getSeventhNum(birthYear, gender);
        String randomNum = getRandomNum();

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
