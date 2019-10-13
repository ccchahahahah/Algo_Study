package BFS;

import java.util.*;

public class 단지번호붙히기 {
	static int N;
	static int[][] arr;
	static boolean visited[][];

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N + 2][N + 2];
		visited = new boolean[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= N; j++) {
				arr[i][j] = str.charAt(j - 1) - '0';
			}
		}

		int max = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					Queue<Point> queue = new LinkedList<>();
					queue.add(new Point(i, j));
					arr[i][j] = 0;
					visited[i][j] = true;
					max++;
					int cnt = 1;

					while (!queue.isEmpty()) {
						Point p = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = p.r + dr[d];
							int nc = p.c + dc[d];
							if (arr[nr][nc] == 1 && !visited[nr][nc]) {
								queue.add(new Point(nr, nc));
								cnt++;
								visited[nr][nc] = true;
								arr[nr][nc] = 0;
							}
						}
					}
					list.add(cnt);
				}
			}
		}
		System.out.println(max);
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});

//		for (int i = list.size() -1; i >= 0; i--) {
//			arr.add(list.get(i));
//		}
		System.out.println(list.toString());
	}
}
