//���1~100��ǰ5���ܱ�3��������
public class Testz3{
   public static void main(String args[]){
      int num = 0;
      for(int j=1;j<101;j++){
         if(j%3 == 0){
            System.out.println(j);
         }
       num ++ ;
         if(num == 6){
            break;
         }
       }
   }
}