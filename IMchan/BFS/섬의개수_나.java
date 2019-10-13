package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬의개수_나 {
	static int W; // 넓이
	static int H; // 높이
	static int[][] map;
	static boolean[][] visited;

	static class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if (W == 0 && H == 0) {
				break;
			}
			map = new int[H + 2][W + 2];
			visited = new boolean[H + 2][W + 2];
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			/*
			 * for(int i=0; i<map.length; i++) { for(int j=0; j<map.length; j++) {
			 * System.out.print(map[i][j]); } System.out.println(); }
			 */
			int cnt = 0;
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= W; j++) {
					Queue<Point> queue = new LinkedList<>();
					if (map[i][j] == 1 && !visited[i][j]) {
						queue.add(new Point(i, j));
						visited[i][j] = true;
						cnt++;
					}

					while (!queue.isEmpty()) {
						Point p = queue.poll();
						for (int d = 0; d < 8; d++) {
							int nr = p.r + dr[d];
							int nc = p.c + dc[d];
							if (map[nr][nc] == 1 && !visited[nr][nc]) {
								visited[nr][nc] = true;
								queue.add(new Point(nr, nc));
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
