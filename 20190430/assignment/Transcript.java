/**
 * �̸�: ������
 * ��¥: 4�� 30��
 * ����: �������ϱ�
 */
public class Transcript {
    public static void main(String[] args) {

        String name = "������";
        
        int korean = (int)(Math.random()*56+45);
        int english = (int)(Math.random()*56+45);
        int math = (int)(Math.random()*56+45);
        
        int total = korean + english + math;
        double average = (total * 100 / 3) / 100.0;
        char grade = 'F';

		if(average >= 90)
			grade = 'A';
		else if(average >= 80)
			grade = 'B';
		else if(average >= 70)
			grade = 'C';
		else if(average >= 60)
			grade = 'D';

		System.out.println(grade);

		switch((int)(average/10)){
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
		}
		System.out.println(grade);

        System.out.println("�̸�: " + name);
        System.out.println("����: " + korean + "\t����: " + english + "\t����: " + math);
        System.out.println("����: " + total + "\t���: " + average + "\t����: " + grade);      
    }
}