public class TestMethod{
   public static void main(String args[]){
      m();
      m1(2,3);
      int i = m2(4,6);
      System.out.println(i);
   }

   public static void m(){
      System.out.println("OK");
      return;
   }

   public static void m1(int i,int j){
      System.out.println(i+j);
      return;
   }

   public static int m2(int i,int j){
       return i > j ? i : j ;
   }
 }