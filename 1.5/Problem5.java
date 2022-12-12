import java.util.Calendar;
import java.util.Scanner;
/**
 * zerobase
 * 과제5: 달력 출력 프로그램
 * 작성자: 이상훈 (ithingv34)
 * 날짜: 2022/12/12
 */
public class Problem5 {

    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");

        Scanner sc = new Scanner(System.in);

        System.out.printf("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();

        System.out.printf("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        printCalendar(year, month); // 달력 출력
    }

    private static void printCalendar(int year, int month) {
        Calendar cal = Calendar.getInstance();

        System.out.printf("\n\n[%d년 %02d월]\n",year, month);
        System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

        cal.set(year, month - 1 , 1); // calander의 시작날짜 설정 (calander는 month가 0부터 시작)

        int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int endDay = cal.getActualMaximum(Calendar.DATE);

        for (int i = 1; i < startDayOfWeek; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= endDay; i++) {
            System.out.printf("%02d\t", i);
            if (startDayOfWeek % 7 == 0) {
                System.out.println();
            }
            startDayOfWeek++;
        }
    }
}
