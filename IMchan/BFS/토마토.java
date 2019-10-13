package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;

	static class Point {
		int r, c, d;

		Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M + 2][N + 2];
		visited = new boolean[M + 2][N + 2];
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt() + 1;
			}
		}

		Queue<Point> queue = new LinkedList<>();
		int cnt = 0, max = 0;
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == 2 && !visited[i][j]) {
					queue.add(new Point(i, j, 2));
					visited[i][j] = true;
				}
			}
		}
		while (!queue.isEmpty()) {

			/*
			 * System.out.println(); for(int s=1; s<=M; s++) { for(int z=1; z<=N; z++) {
			 * System.out.print(visited[s][z]+ " "); } System.out.println(); }
			 */
			Point p = queue.poll();
			max = p.d - 2;

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (arr[nr][nc] != 0 && arr[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc, p.d + 1)); //
					arr[nr][nc] = p.d + 1;
				}
			}
		}

		for (int s = 1; s <= M; s++) {
			for (int z = 1; z <= N; z++) {
				if (arr[s][z] == 1) {  // 갇힌 토마토를 찾아야한다 그래야지 나온다값이!!
					max = -1;
				}
			}
		}
	

		/*System.out.println();
		for (int s = 1; s <= M; s++) {
			for (int z = 1; z <= N; z++) {
				System.out.print(arr[s][z] + " ");
			}
			System.out.println();
		}*/
		System.out.println(max);
	}
}