package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추BFS {
	static int N; // 세로의 길이
	static int M; // 가로의 길이
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();

			map = new int[N + 2][M + 2]; //+2 하는이유는 0을 바깥으로 나가면안되기떄문에
			visited = new boolean[N+2][N+2];
			
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				map[r + 1][c + 1] = 1;
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						cnt++;
						// BFS탐색 시작.
						// 큐를 준비하고.
						// 첫번째 상태노드를 큐에 삽입
						Queue<Point> queue = new LinkedList<>();
						visited[i][j] = false;
						queue.add(new Point(i, j)); // 1인칸 찾고자하니까그래서 i 와 j값을 초기값으로
						// 큐가 빌때까지
						while (!queue.isEmpty()) {
							Point p = queue.poll();
							// 상하좌우로 인접한 배추를 큐에 삽입
							for (int d = 0; d < 4; d++) {
								int nr = p.r + dr[d];
								int nc = p.c + dc[d];
								if (map[nr][nc] == 1 && !visited[nr][nc]) {
									visited[nr][nc] = true; 
									queue.add(new Point(nr, nc));
								}
							} // end of for-loop

						}// end of while
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
}
