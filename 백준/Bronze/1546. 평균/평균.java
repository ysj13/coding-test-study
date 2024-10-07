import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        double[] newScore = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);
        int M = score[score.length - 1];
        double sum = 0;

        for(int i = 0; i < score.length; i++) {
            newScore[i] = (double) (score[i]) / M * 100;
            sum += newScore[i];
        }

        bw.write(sum / N + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
