import java.util.*;

public class Account{
   public static void main(String args[]){
      BackAccount account;
      Pw pw;
      pw = new Pw();
      System.out.println("��ӭʹ�����й���ϵͳ�����ʼ��������Ϣ��");            
      
      System.out.println("����������");
      Scanner na = new Scanner(System.in);
      String name1 = na.nextLine();
      
      System.out.print("�����˺ţ�");
      int num1 = na.nextInt(); 
      
      //Sanner me = new Scanner(System.out);
      System.out.print("�������룺");
      int pass1 = na.nextInt(); 
      
      System.out.print("���Ĵ�");
      float balance1 = na.nextFloat();
      
      account = new BackAccount(name1,num1,pass1,balance1,Level.General);
      System.out.println("��Ϣ��ʼ���ɹ���");
      System.out.println("\n");
      do{
         System.out.println("��ӭ�������в�ѯϵͳ��������¼!");
         //System.out.println("\n");
         System.out.print("�������˺ţ�");
         int num2 = na.nextInt();
         System.out.print("���������룺");
         int pass2 = na.nextInt();
         if((num2 == num1) && (pass1 == pass2)){
            
            System.out.println("\n");
            System.out.println("��¼�ɹ���");
            System.out.println("\n");
            System.out.println("��������Ӧ����ѡ������ܣ�");
            System.out.println("1.ȡ��\n"+"2.���\n"+"3.��ʾ���\n"+"4.�˳�");
         //System.out.println(account);
            int s = na.nextInt();
            pw = new Pw(s);
         
               switch(s){
                  case(1):
                    System.out.print("������ȡ����:");
                    float o = na.nextFloat();
                    account.deposit(o);
                    System.out.println("ȡ��ɹ�");
                    System.out.println("\n");
                    System.out.println("ϵͳ�˳�");
                    break;

                  case(2):
                    System.out.print("����������:");
                    float iit = na.nextFloat();
                    account.withdraw(iit);
                    System.out.println("���ɹ�!");
                    System.out.println("\n");
                    System.out.println("ϵͳ�˳�\n");
                    break;
               
                  case(3):
                    System.out.println(account);
                    System.out.println("��ʾ���!");
                    System.out.println("\n");
                    System.out.println("ϵͳ�˳�\n");
                    break;               
 
                  case(4):
                    break;
                  default:
                     System.out.println("������������ϵͳ�˳�\n");
                     break;           
                }
            }
       
            else if( (num1 == num2) && (pass1 != pass2)){
              System.out.println("�������");
              System.out.println("\n");
              System.out.println("ϵͳ�˳�\n");
              break;
            }
            else if( (num1 != num2) && (pass1 == pass2)){
              System.out.println("�˺Ŵ���");
              System.out.println("\n");
              System.out.println("ϵͳ�˳�\n");
              break; 
           }
      }
      while(pw.panding != 4);
    
       na.close();  
      
      
   }   
}