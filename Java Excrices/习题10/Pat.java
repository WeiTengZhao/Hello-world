import java.util.*;

public class Pat{
   public static void main(String arg[]){
      Patient p ;
      Pw pw;
      p=new Patient();
      pw = new Pw();
      
      Scanner num = new Scanner(System.in);
      do{
         System.out.println("欢迎使用病人信息管理系统！请输入代号选择相应功能。");
         System.out.println("1.录入病人相关信息；");
         System.out.println("2.查看病人信息");
         System.out.println("3.退出系统");
         int r = num.nextInt();
         pw = new Pw(r) ;
     
             switch(r){
               case(1):
                 Scanner na = new Scanner(System.in);
                 System.out.println("请您输入病人信息：");
                 System.out.print("病人的姓名为：");
                 String nam = na.nextLine();
                 System.out.print("年龄：");
                 int ag = na.nextInt();
                 Scanner se = new Scanner(System.in);
                 System.out.print("性别：");
                 String s = se.nextLine();      
                 System.out.print("体重：");
                 float w = na.nextFloat();
                 System.out.println("是否过敏（是则输入true,否则输入false)：");
                 boolean a = na.nextBoolean();
                 p=new Patient(nam,ag,s,w,a);
                 System.out.print("录入成功！系统返回");
                 System.out.print("\n");
                 System.out.print("\n");
                 break;
            
              case(2):
                 System.out.print("病人信息为：");
                 System.out.println(p);
                 System.out.print("输出成功！系统返回");
                 System.out.print("\n");
                 System.out.print("\n");
                 break;
      
               case(3):
                  System.out.print("Thanks for using.");  
                  break;
               default:
                  System.out.println("所输入的指令代号有误！系统返回");
                  System.out.print("\n");
                  System.out.print("\n");
                  break;
            }

       
      }  
      while(pw.panding != 3);
      num.close();
      
   }
}