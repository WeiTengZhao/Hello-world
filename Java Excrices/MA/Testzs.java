//求 101~200内的 质数（只能被1和它本身整除的数)
public class Testzs{
   public static void main(String args[]){  
      for(int i=101;i<=200;i+=2){
         boolean f = true;
         for(int j=2;j<i;j++){
            if(i % j == 0){
               f = false;
               break;
            }
          }
         if(!f){
             continue;
         }
         System.out.println(i);
         }
       
   }
}