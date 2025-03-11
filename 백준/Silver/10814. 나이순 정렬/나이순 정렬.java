import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new Member(i, age, name));
        }

        Collections.sort(list);

        for (Member member : list) {
            bw.write(String.valueOf(member));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Member implements Comparable<Member> {
        int order;
        int age;
        String name;

        public Member(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Member m) {
            int ageCompare = Integer.compare(this.age, m.age);

            if (ageCompare == 0) {
                return Integer.compare(this.order, order);
            }

            return ageCompare;
        }
    }
}
