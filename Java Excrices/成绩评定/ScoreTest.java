import java.util.*;

enum Score{
   EXCELLENT,
   QUALIFIED,
   FALED,
   Another;
}


public class ScoreTest{ 
   public static void main(String args[]){
      System.out.println("请录入您的成绩：");
      Scanner na = new Scanner(System.in);
      int n = na.nextInt();
      if(n >= 70){
         getScore(Score.EXCELLENT);
      }
      if((n >= 60) && (n < 70)){
         getScore(Score.QUALIFIED);
      }
      if((n > 0)&&(n < 60)){
         getScore(Score.FALED);
      }

      if(n < 0){
         getScore(Score.Another);
      }
   }


   public static void getScore(Score s){
      switch(s){
         case EXCELLENT:System.out.println("学霸的成绩(OдO)b");break;
         case QUALIFIED:System.out.println("╮(╯▽╰)╭凑合，过了");break;
         case FALED:System.out.println("滚去重修！(╯‵□′)╯︵┻━┻");break;
         default:System.out.println("数据输入错误");
      }  
   }
}