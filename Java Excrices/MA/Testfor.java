public class Testfor{
  public static void main(String args[]){
    long r = 0;
    long f = 1;
    for(int i = 1;i < 11;i++){
      f = i * f;
      r += f; 
    }
  //����1��10�Ľ׳˺� 1!+2!+....+10!
  System.out.println("r��ֵ��"+r);
  System.out.println("F��ֵ��"+f);
  }
}