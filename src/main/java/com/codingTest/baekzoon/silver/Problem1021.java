import java.io.*;
import java.util.*;

public class Problem1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < T; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            int targetIdx = queue.indexOf(target);
            int halfIdx = queue.size() / 2;
            
            if(targetIdx <= halfIdx) {
                for(int j = 0; j < targetIdx; j++) {
                    queue.addLast(queue.pollFirst());
                    answer++;
                }
            } else {
                for(int j = 0; j < queue.size() - targetIdx; j++) {
                    queue.addFirst(queue.pollLast());
                    answer++;
                }
            }
            queue.pollFirst();
        }
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
