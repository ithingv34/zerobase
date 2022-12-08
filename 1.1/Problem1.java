public class Problem1 {
    public static void gugudan() {
        System.out.println("[구구단 출력]");
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                // 10보다 작은 경우 앞에 0을 붙여 출력한다.
                System.out.printf("%02d X %02d = %02d  ", j, i, i * j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        gugudan();
    }
}
