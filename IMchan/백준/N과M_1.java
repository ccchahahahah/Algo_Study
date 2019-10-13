package IM연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 중복없는 수열을 모두 구해라 
public class N과M_1 {
    
    static int n;
    static int m;
    static boolean visited[];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        
        dfs(0, ""); //함수 작성 시 기능을 유추할 만한 걸로 하면 좋다!
        //주석을 하나씩 다 달기 
        //
    }
    
    public static void dfs(int len, String str) {
        if(len == m) { //
        	System.out.println(str);
            return;
        }
        
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(len + 1, str + i + " ");
                visited[i] = false;
            }
        }
    }
}