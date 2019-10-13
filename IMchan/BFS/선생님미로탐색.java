package 알고리즘8주차;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 선생님미로탐색 {
	static boolean[][] visited; // 길을 찾는데 델타를 다 탐색하면서 확인하기 위해 2차원 불리형배열 생성
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r, c, cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	// ====
	static int N, M; //
	static int[][] map; //

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 상하좌우로 0으로 꽉찬 더미 행 열 을 만들어서... 벽대신 삼아서 경계체크를 안해도 되도록
		map = new int[N + 2][M + 2]; // 델타를 쓰면 4방향을무조건검색 가장자리 같은경우 4방향검색하면 판에 바깥에 나갈수가있다
		visited = new boolean[N + 2][M + 2];
		for (int i = 1; i < N + 1; i++) {
			String line = sc.next();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}
//		dfs(1, 1, 1);
		// 시작점 상태노드를 큐에 담고 방문체크를 한다.
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 1, 1)); // 시작점이 1이였다
		visited[1][1] = true;// 방문했다 들어왔으면 방문했다
		// 큐가 다 빌때까지.
		while (!queue.isEmpty()) {
			// 하나 꺼내서 검사( 도착지인지 검사 )
			Node node = queue.poll();
			if (node.r == N && node.c == M) {
				System.out.println(node.cnt);
				break;
			}
			// 이동 가능한 (상태전이 가능한) 노드를 방문한적없다면, 방문체크 후 큐에 삽입.
			for (int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true; // 방문한거고
					queue.add(new Node(nr, nc, node.cnt + 1));
				}

//			}	static int[] dr = {-1,1,0,0};
//			static int[] dc = {0,0,-1,1};
//			
			}

		}

	}
}

/*
 * static void dfs(int r, int c, int cnt) { if( r == N && c == M ) {
 * System.out.println(cnt); return; } //===================================
 * for(int i = 0; i < 4; i++) { int nr = r + dr[i]; int nc = c + dc[i]; //갔던 곳이
 * 아니어야 하고, 길이 있어야함 if(!visited[nr][nc] && map[nr][nc] == 1) { visited[nr][nc] =
 * true; dfs(nr, nc, cnt+1); visited[nr][nc] = false; } }
 * 
 * }
 */
