//����ѭ���� �β����� ������F(n)=F(n-1)+F(n-2)��(���ú���)
public class Fab3{
   public static void main(String args[]){
      System.out.println(f(40));
   }
   
   public static int f(int index){
      if(index<1){
        System.out.println("�����������!");
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