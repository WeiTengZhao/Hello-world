import java.util.*;

public class Pat{
   public static void main(String arg[]){
      Patient p ;
      Pw pw;
      p=new Patient();
      pw = new Pw();
      
      Scanner num = new Scanner(System.in);
      do{
         System.out.println("��ӭʹ�ò�����Ϣ����ϵͳ�����������ѡ����Ӧ���ܡ�");
         System.out.println("1.¼�벡�������Ϣ��");
         System.out.println("2.�鿴������Ϣ");
         System.out.println("3.�˳�ϵͳ");
         int r = num.nextInt();
         pw = new Pw(r) ;
     
             switch(r){
               case(1):
                 Scanner na = new Scanner(System.in);
                 System.out.println("�������벡����Ϣ��");
                 System.out.print("���˵�����Ϊ��");
                 String nam = na.nextLine();
                 System.out.print("���䣺");
                 int ag = na.nextInt();
                 Scanner se = new Scanner(System.in);
                 System.out.print("�Ա�");
                 String s = se.nextLine();      
                 System.out.print("���أ�");
                 float w = na.nextFloat();
                 System.out.println("�Ƿ��������������true,��������false)��");
                 boolean a = na.nextBoolean();
                 p=new Patient(nam,ag,s,w,a);
                 System.out.print("¼��ɹ���ϵͳ����");
                 System.out.print("\n");
                 System.out.print("\n");
                 break;
            
              case(2):
                 System.out.print("������ϢΪ��");
                 System.out.println(p);
                 System.out.print("����ɹ���ϵͳ����");
                 System.out.print("\n");
                 System.out.print("\n");
                 break;
      
               case(3):
                  System.out.print("Thanks for using.");  
                  break;
               default:
                  System.out.println("�������ָ���������ϵͳ����");
                  System.out.print("\n");
                  System.out.print("\n");
                  break;
            }

       
      }  
      while(pw.panding != 3);
      num.close();
      
   }
}