public class Testfor{
  public static void main(String args[]){
    long r = 0;
    long f = 1;
    for(int i = 1;i < 11;i++){
      f = i * f;
      r += f; 
    }
  //计算1到10的阶乘和 1!+2!+....+10!
  System.out.println("r的值："+r);
  System.out.println("F的值："+f);
  }
}