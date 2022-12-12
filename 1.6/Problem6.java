import java.util.HashMap;
import java.util.Random;
/**
 * zerobase
 * 과제6: 가상 대선 당선 시뮬레이션 프로그램
 * 작성자: 이상훈 (ithingv34)
 * 날짜: 2022/12/12
 */
public class Problem6 {

    public static HashMap<String, Integer> getMap(String name, int voteCnt) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(name, voteCnt);
        return map;
    }
    public static void main(String[] args) {

        HashMap<Integer, HashMap<String, Integer>> voteMap = new HashMap<>();
        int totalVote = 10;

        voteMap.put(1, getMap("이재명", 0)); // 이재명
        voteMap.put(2, getMap("운삭열", 0)); // 윤석열
        voteMap.put(3, getMap("심상정", 0)); // 심상정
        voteMap.put(4, getMap("안철수", 0)); // 안철수

        for(int i = 0; i < totalVote; i++) {
            Random rnd = new Random();
            int vote = rnd.nextInt(4) + 1;

            voteMap.get(vote).values();
            System.out.println("[투표진행율]: " + String.format("%.2f", (double) i / (double) totalVote * 100) + "%");
        }
    }
}
