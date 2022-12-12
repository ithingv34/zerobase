import java.util.*;

/**
 * zerobase
 * 과제7: 로또 당첨 프로그램
 * 작성자: 이상훈 (ithingv34)
 * 날짜: 2022/12/12
 */
public class Problem7 {

    public static int getLottoNum() {
        System.out.println("[로또 당첨 프로그램]");

        Scanner sc = new Scanner(System.in);
        int lottoNum = 0;

        // 사용자가 정수(1~10)를 입력할 때 까지 반복한다.
        while (true) {
            try {
                System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
                lottoNum = sc.nextInt();

                if (1 <= lottoNum && lottoNum <= 10) {
                    break;
                } else {
                    System.out.println("로또는 1개 이상 10개 이하만 구매할 수 있습니다.");
                }
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("잘못 입력하였습니다. 1 이상 ~ 10 이하의 정수를 입력해주세요.");
            }
        }
        return lottoNum;
    }

    public static ArrayList<Integer> lottoGenerator() {
        ArrayList<Integer> lottoNumber = new ArrayList<>();

        while (lottoNumber.size() < 6) {
            int number = (int) (Math.random() * 45) + 1;
            if (!lottoNumber.contains(number)) { // 중복제거
                lottoNumber.add(number);
            }
        }
        return lottoNumber;
    }

    // 출력 형식을 맞춰주기 위한 메소드입니다.
    public static String getLottoNumberStr(ArrayList<Integer> lottoNumber) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lottoNumber.size(); i++) {
            if (i == lottoNumber.size() - 1) {
                sb.append(String.format("%02d", lottoNumber.get(i)));
            } else {
                sb.append(String.format("%02d,", lottoNumber.get(i)));
            }
        }
        return sb.toString();
    }

    public static int compareLottoNumber(ArrayList<Integer> winLottoNumber, ArrayList<Integer> userLottoNumber) {
        int equalCnt = 0;

        for (Integer userNumber : userLottoNumber) {
            if (winLottoNumber.contains(userNumber)) {
                equalCnt++;
            }
        }
        return equalCnt;
    }

    public static void main(String[] args) {

        // 1. 로또 구매 수량 입력
        int lottoNum = getLottoNum();
        HashMap<String, ArrayList<Integer>> userLottoMap = new HashMap<>(); // 구입한 로또의 정보를 저장할 Map

        // 2. 입력한 개수만큼의 로또 생성
        for (int i = 0; i < lottoNum; i++) {
            String alpha = String.valueOf((char) (i + 65));
            ArrayList<Integer> lottoNumber = lottoGenerator();
            userLottoMap.put(alpha, lottoNumber);

            // 로또 번호를 출력한다.
            String lottoNumberStr = getLottoNumberStr(lottoNumber);
            System.out.println(alpha + "\t" + lottoNumberStr);
        }

        // 3. 로또 당첨 번호 생성
        System.out.println();
        System.out.println("[로또 발표]");
        ArrayList<Integer> winLottoNumber = lottoGenerator();
        String winLottoNumberStr = getLottoNumberStr(winLottoNumber);
        System.out.println("\t" + winLottoNumberStr);

        // 내 로또 결과
        System.out.println();
        System.out.println("[내 로또 결과]");

        for (String alpha : userLottoMap.keySet()) {
            ArrayList<Integer> userLottoNumber = userLottoMap.get(alpha);
            String lottoStrNum = getLottoNumberStr(userLottoNumber);

            // 4. 당첨 번호와 구매 로또 비교하여 숫자 일치 여부 판단
            int equalCnt = compareLottoNumber(winLottoNumber, userLottoNumber);
            System.out.println(alpha + "\t" + lottoStrNum + " => " + equalCnt + "개 일치");
        }
    }
}


