//运用递归求 肺部尼奇 函数【F(n)=F(n-1)+F(n-2)】
public class Fab{
   public static void main(String args[]){
      System.out.print(method(5));
   }

   public static int method(int i){
      if(i == 1||i == 2){
         return 1;
      }

      else{
         return(method( i - 1 ) + method( i -  2 ) );
      }
   }
}