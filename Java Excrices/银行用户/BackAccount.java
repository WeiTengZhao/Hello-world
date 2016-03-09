public class BackAccount{
   private String name;
   private int num;
   private int password;
   private float balance;
   Level grade;


   public BackAccount(String intname,int intnum, int inpassword,float intbalance,Level General){
      name = intname;
      num = intnum;
      password = inpassword;
      balance = intbalance;
      grade = General;
   }

   public BackAccount(){
   this("",0,0,0,Level.General);
   }

   public float deposit(float ot){
      balance -= ot;
      return balance;
   }
 
   public float withdraw(float it){
      balance += it;
      return balance;
   }

   public String getname(){
      return name;
   }
   public int getnum(){
      return num;
   }
   
   public int getpassword(){
      return password;
   }
   
   public float getbalance(){
      return balance;
   }

   public Level getgrade(){
      return grade;
   }


   public void setname(String intname){
      intname = name;
    
   }
   public void setnum(int intnum){
     intnum = num;
    
   }
   public void setpassword(int inpassword){
      inpassword = password;
   }
   public void setbalance(float intbalance){
      intbalance = balance;
 
   }
   public void setgrade(Level Gelenal){
      grade =  Gelenal;
   }
   public String toString(){
     return("用户等级为："+grade+"\n"+"用户名为："+name+"\n"+"账号："+num+"\n"+"余额："+balance+"\n"); 
  }
}
//===========================================================
