import java.io.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> numbers = new ArrayList<>();
        String input;

        while (true) {
            input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            numbers.add(input);
        }

        for(int i = 0; i < numbers.size(); i++) {
            String reverse = new StringBuilder(numbers.get(i)).reverse().toString();
            
            if("0".equals(Character.toString(numbers.get(i).charAt(0)))) {
                bw.write("no\n");
            }

            if(numbers.get(i).equals(reverse)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}