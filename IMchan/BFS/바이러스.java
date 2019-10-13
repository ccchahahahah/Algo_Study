package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {
	static class Point {
		static int r, c;
		static int[][] arr;
		static boolean[] visited;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		/*
		 * static int[] dr = { -1, 1, 0, 0 }; static int[] dc = { 0, 0, -1, 1 };
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt(); // 컴퓨터수
			int N = sc.nextInt(); // 연결된 컴퓨터수
			arr = new int[T + 2][T + 2];
			visited = new boolean[T + 2];
			for (int i = 1; i <= N; i++) {
				int x = sc.nextInt();
				int z = sc.nextInt();
				arr[x][z] = arr[z][x] = 1;
			}
		/*	for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}*/
			int cnt = 0;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(1);
			visited[1] = true;
			while(!queue.isEmpty()) {
				int p = queue.poll();
				for(int i=1; i<=T; i++) {
					if(arr[p][i]==1 && !visited[i]) {
						queue.add(i);
						cnt++;
						visited[i] = true;
					}
				}
			}
		System.out.println(cnt);
		}

	}
}