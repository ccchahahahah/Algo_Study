package 알고리즘8주차;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {
	static int N,M;
	static int [][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		//상하좌우 0으로 꽉찬 더미 행 열을 만들어서. 벽대신 삼아서 경계체크를 안해도 되도록
		arr = new int [N+2][M+2];
		visited = new boolean[N+2][M+2];
		for(int i=1; i<N+1; i++) {
			String line = sc.next();
			for(int j=1; j<M+1; j++) {
				arr[i][j] = line.charAt(j-1)- '0';
			}
		}
		//dfs(1,1,1);
	//시작점 상태노드를 큐에 담고 방문체크
		//큐가 다 빌때까지
		// 하나 꺼내서 검사
		//이동 간으한 노드를 방문한적 없다면, 방문체크 후 큐에 삽입 
	}
	
	
	static class Node{
		int r,c,cnt;
		Node(int r, int c, int cnt){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	Queue<Node> queue = new LinkedList<>();
	queue.add(new Node(1,1,1));     //시작점 상태노드에 큐를 담고 담을러면 Node 구조체를 어떻게 해야하나...
	visited[1][1] = true; 
	
	while(!queue.isEmpty()) {
		Node node = queue.poll();
		if(node.r == N && node.c == M) {
			System.out.println(node.cnt);
			break;
		}
		for(int i=0; i<4; i++) {
			int nr = node.r + dr[i];
			int nc = node.c + dc[i];
			if(arr [nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
			queue.add(new Node(nr,nc,node.cnt+1));
			
			}
		}
	}
}
	//델타 만들고 4방으로 탐색하며 이동가능하면 재귀호출
	static boolean [][] visited;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	static void dfs(int r, int c, int cnt) { //내위치가 어디고 몇번만에 왔는지 알아야한다
		if( r == N && c == M ) {
			System.out.println(cnt);
			return;
		}
		for(int i=0; i<4; i++) { //설명gogo!!//4번돌린이유 델타는 4방향이라서 무조건 4
			int nr = r + dr[i]; // r+dr[i] 
			int nc = c + dc[i];
			if(!visited[nr][nc] && arr[nr][nc]==1) {
				visited[nr][nc] = true;
				dfs(nr,nc,cnt+1);
				visited[nr][nc] = false;
			}
			dfs(nr, nc, cnt+1);
		}//갔던곳이 아니어양 하고 , 길이 있어야함
	
	}
	
	
	
}
