/**
  이름:이건영
  날짜:ex0419
  주제:성적구하기
*/
class MyReport{
   public static void main(String[] args){
    String name = "이건영";
    int korea = 85;
    int english = 75;
    int math = 85;
    int total = korea+english+math;
    double mean = total/3.0;
    char grade =(mean>=90) ? 'A':'f';
    

    System.out.println("이름 = "+name);
    System.out.println("국어 = "+korea);
    System.out.println("영어 = "+english);
    System.out.println("수학 = "+math);
    System.out.println("평균 = "+mean);
    System.out.println("학점 = "+grade); 
    }
}