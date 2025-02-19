import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        numbers = Arrays.stream(numbers).sorted().toArray();

        int answer = findIndex(numbers, x);

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();

    }

    public static int findIndex(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        int answer = 0;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
                    
            if (sum == target) {
                answer++;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return answer;
    }
}