//运用循环求 肺部尼奇 函数【F(n)=F(n-1)+F(n-2)】
public class Fab2{
   public static void main(String args[]){
      int k = 0;
      //int i = 5;
      int j = 1;
      int z = 1;
      
      for(int i=40;i>2;i--){
         k = j + z;
         z = j;
         j = k;      
      }
      
      
   
      System.out.println(k);
   }
}