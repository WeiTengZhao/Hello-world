public class OddSum{
   public static void main(String args[]){
      //1+2+...+100的和
      int r = 0;
      for(int i=0;i<=100;++i,++i){
         r += i ;
      }
   
    System.out.println("和为："+r);   
   }
}