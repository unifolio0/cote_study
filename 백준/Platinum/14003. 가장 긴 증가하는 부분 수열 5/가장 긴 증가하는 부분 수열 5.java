import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[N];
        int idx = 0;
        res[idx] = nums[0];
        int[] order = new int[N];
        for (int i = 1; i < N; i++) {
            if (res[idx] < nums[i]) {
                res[++idx] = nums[i];
                order[i] = idx;
            } else {
                int start = 0;
                int end = idx;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (res[mid] < nums[i]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                res[start] = nums[i];
                order[i] = start;
            }
        }
        bw.write((idx + 1) + "\n");
        int k = idx;
        int[] rr = new int[k + 1];
        for (int i = N - 1; i > -1; i--) {
            if (order[i] == k) {
                rr[k] = nums[i];
                k--;
            }
        }

        for (int i = 0; i < idx + 1; i++) {
            bw.write(rr[i] + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
