package 알고리즘8주차;

import java.util.Scanner;

public class 인접행렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//정점의 갯수를 N이라 하고 간선의 개수를 M이라고 하자
		int N = sc.nextInt();
		int M = sc.nextInt();
		int [][] arr = new int [N][M];
		//한행 한행 출발 한열 한열 도착지점 알고싶어서 이렇게 
		for(int i=0; i<M; i++) {
			int n1= sc.nextInt(); //출발
			int n2 = sc.nextInt(); // 도착
			int n3 = sc.nextInt(); //가충치 
			arr[N][M] = n3;   //여기에 가충치값을 집어넣는다!
			//간섭행렬이 주어지면 인접찾을수있어야한다
			//그래프적인 요소를 입력으로 주면 어떻게 하는지알아야하는것임
		
		}
	}

}
