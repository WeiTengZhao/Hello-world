import java.util.*;

enum Score{
   EXCELLENT,
   QUALIFIED,
   FALED,
   Another;
}


public class ScoreTest{ 
   public static void main(String args[]){
      System.out.println("��¼�����ĳɼ���");
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
         case EXCELLENT:System.out.println("ѧ�Եĳɼ�(O��O)b");break;
         case QUALIFIED:System.out.println("�r(�s���t)�q�պϣ�����");break;
         case FALED:System.out.println("��ȥ���ޣ�(�s�F����)�s��ߩ���");break;
         default:System.out.println("�����������");
      }  
   }
}