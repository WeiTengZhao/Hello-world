//运用循环求 肺部尼奇 函数【F(n)=F(n-1)+F(n-2)】(调用函数)
public class Fab3{
   public static void main(String args[]){
      System.out.println(f(40));
   }
   
   public static int f(int index){
      if(index<1){
        System.out.println("参数输入错误!");
        return -1;
      }
          
      if(index == 1||index == 2){
         return 1;   
      }

      int f1 = 1;
      int f2 = 1;
      int f3 = 0;
      
      for(int i=0;i<index-2;i++){
        f3 = f1 + f2;
        f2 = f1;
        f1 = f3;
      }
      return f3;
   }
}