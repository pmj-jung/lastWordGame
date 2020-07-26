package lastWordGameTest;

import java.util.HashMap;
import java.util.Scanner;

public class LastWordGame2 {

	// ��������

	Scanner s = new Scanner(System.in);

	int pNum; // ��ĳ�ʷ� �Է¹޴� �÷��̾��
	String pName; // ��ĳ�ʷ� �Է¹޴� �÷��̾��
	String words; // ��ĳ�ʷ� �Է¹޴� �÷��̾�ܾ�
	String[] Arr = null; // �÷��̾�� �迭 �غ�(�̸��迭)
	
	HashMap<Integer,String> map = null; // for������ intŰ�� ->value�� String words�ҷ�����

	public void gameSet() { // �����ʱ⼳�� �޼ҵ�

		System.out.println("**************************");
		System.out.println("      LAST WORD GAME      ");
		System.out.println("**************************");

		System.out.print("�����ձ� ���ӿ� ������ �ο� �� �Է�(����) :");
		pNum = s.nextInt();
		Arr = new String[pNum];

		// �ο�����ŭ �ݺ�(for), �̸��Է¹޾Ƽ�(scanner)
		for (int i = 0; i < pNum; i++) {
			System.out.print("���ӿ� �����ϴ� ����� �̸� �Է� :");
			pName = s.next();
			Arr[i] = pName;
		}

		System.out.println();// ����

		/*** �÷��̾� �ѿ� ��� �׽�Ʈ ***/
		//System.out.println(Arrays.toString(Arr));

		System.out.println("�����ձ� ������ �����մϴ�.");
		System.out.println("ó�� ���õǴ� �ܾ�� '�λ�' �Դϴ�.");

	}

	public void gameStart() {// ���ӽ��� �޼ҵ�
			
		map = new HashMap<>();
		char c1;// j-1��° �������ܾ�. j=0(ù���)�� ����ó���ʿ�
		char c2;// j��° ù�ܾ�

		for (int j = 0;; j++) { // �ι�°�迭�ǻ������ �����Ѱ��ӽ���.

			System.out.print(Arr[(j % pNum)] + "> ");
			words = s.next(); // �Է¹����ܾ�
			map.put(j,words);

			if (j == 0) {
				c1 = '��';
			} else {
				c1 = map.get(j-1).charAt(map.get(j-1).length() - 1);// j-1��° �������ܾ�
			}

			c2 = map.get(j).charAt(0);// j��° ù�ܾ�

			if (c1 == c2) { // if�������� �ٽ� for���ѹݺ�
					
			} else {
				System.out.println("=================");
				System.out.println("Ʋ�� �ܾ �Է��߽��ϴ�.");
				System.out.println(Arr[(j%pNum)] + " ��(��) �����ϴ�.");
				System.exit(0);
			}
		}
	}
}
