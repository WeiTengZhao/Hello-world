import java.util.*;

public class Account{
   public static void main(String args[]){
      BackAccount account;
      Pw pw;
      pw = new Pw();
      System.out.println("欢迎使用银行管理系统，请初始化您的信息！");            
      
      System.out.println("您的姓名：");
      Scanner na = new Scanner(System.in);
      String name1 = na.nextLine();
      
      System.out.print("您的账号：");
      int num1 = na.nextInt(); 
      
      //Sanner me = new Scanner(System.out);
      System.out.print("您的密码：");
      int pass1 = na.nextInt(); 
      
      System.out.print("您的存款：");
      float balance1 = na.nextFloat();
      
      account = new BackAccount(name1,num1,pass1,balance1,Level.General);
      System.out.println("信息初始化成功！");
      System.out.println("\n");
      do{
         System.out.println("欢迎进入银行查询系统，请您登录!");
         //System.out.println("\n");
         System.out.print("请输入账号：");
         int num2 = na.nextInt();
         System.out.print("请输入密码：");
         int pass2 = na.nextInt();
         if((num2 == num1) && (pass1 == pass2)){
            
            System.out.println("\n");
            System.out.println("登录成功！");
            System.out.println("\n");
            System.out.println("请输入相应代号选择服务功能：");
            System.out.println("1.取款\n"+"2.存款\n"+"3.显示余额\n"+"4.退出");
         //System.out.println(account);
            int s = na.nextInt();
            pw = new Pw(s);
         
               switch(s){
                  case(1):
                    System.out.print("请输入取款金额:");
                    float o = na.nextFloat();
                    account.deposit(o);
                    System.out.println("取款成功");
                    System.out.println("\n");
                    System.out.println("系统退出");
                    break;

                  case(2):
                    System.out.print("请输入存款金额:");
                    float iit = na.nextFloat();
                    account.withdraw(iit);
                    System.out.println("存款成功!");
                    System.out.println("\n");
                    System.out.println("系统退出\n");
                    break;
               
                  case(3):
                    System.out.println(account);
                    System.out.println("显示完毕!");
                    System.out.println("\n");
                    System.out.println("系统退出\n");
                    break;               
 
                  case(4):
                    break;
                  default:
                     System.out.println("服务号输入错误，系统退出\n");
                     break;           
                }
            }
       
            else if( (num1 == num2) && (pass1 != pass2)){
              System.out.println("密码错误！");
              System.out.println("\n");
              System.out.println("系统退出\n");
              break;
            }
            else if( (num1 != num2) && (pass1 == pass2)){
              System.out.println("账号错误！");
              System.out.println("\n");
              System.out.println("系统退出\n");
              break; 
           }
      }
      while(pw.panding != 4);
    
       na.close();  
      
      
   }   
}