public class Patient{
   int aeg;
   String name;
   String sex;
   float weight;
   boolean allergires;

   public Patient(String name1,int aeg1,String sex1,float weight1,boolean allergires1){
      aeg = aeg1;
      name = name1;
      sex = sex1;
      weight = weight1;
      allergires = allergires1;
   }
    public Patient(){
       this(" ",0," ",0,false);
    }
    public String toString(){
      return("病人信息为：\n姓名："+name+"\n年龄："+aeg+"\n性别："+sex+"\n体重："+weight+"\n过敏症："+allergires);
   }
}