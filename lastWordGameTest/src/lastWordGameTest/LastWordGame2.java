package lastWordGameTest;

import java.util.HashMap;
import java.util.Scanner;

public class LastWordGame2 {

	// 전역변수

	Scanner s = new Scanner(System.in);

	int pNum; // 스캐너로 입력받는 플레이어수
	String pName; // 스캐너로 입력받는 플레이어명
	String words; // 스캐너로 입력받는 플레이어단어
	String[] Arr = null; // 플레이어명 배열 준비(이름배열)
	
	HashMap<Integer,String> map = null; // for문으로 int키값 ->value로 String words불러내기

	public void gameSet() { // 게임초기설정 메소드

		System.out.println("**************************");
		System.out.println("      LAST WORD GAME      ");
		System.out.println("**************************");

		System.out.print("끝말잇기 게임에 참여할 인원 수 입력(숫자) :");
		pNum = s.nextInt();
		Arr = new String[pNum];

		// 인원수만큼 반복(for), 이름입력받아서(scanner)
		for (int i = 0; i < pNum; i++) {
			System.out.print("게임에 참여하는 사람의 이름 입력 :");
			pName = s.next();
			Arr[i] = pName;
		}

		System.out.println();// 개행

		/*** 플레이어 총원 출력 테스트 ***/
		//System.out.println(Arrays.toString(Arr));

		System.out.println("끝말잇기 게임을 시작합니다.");
		System.out.println("처음 제시되는 단어는 '부산' 입니다.");

	}

	public void gameStart() {// 게임시작 메소드
			
		map = new HashMap<>();
		char c1;// j-1번째 마지막단어. j=0(첫사람)은 예외처리필요
		char c2;// j번째 첫단어

		for (int j = 0;; j++) { // 두번째배열의사람부터 진정한게임시작.

			System.out.print(Arr[(j % pNum)] + "> ");
			words = s.next(); // 입력받은단어
			map.put(j,words);

			if (j == 0) {
				c1 = '산';
			} else {
				c1 = map.get(j-1).charAt(map.get(j-1).length() - 1);// j-1번째 마지막단어
			}

			c2 = map.get(j).charAt(0);// j번째 첫단어

			if (c1 == c2) { // if문나가서 다시 for무한반복
					
			} else {
				System.out.println("=================");
				System.out.println("틀린 단어를 입력했습니다.");
				System.out.println(Arr[(j%pNum)] + " 이(가) 졌습니다.");
				System.exit(0);
			}
		}
	}
}
