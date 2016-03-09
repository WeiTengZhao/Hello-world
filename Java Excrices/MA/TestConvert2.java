public class TestConvert2
{  
   public static void main(String args[])
    {
     int i=1,j=12;
     double d1=1e200,d2=124;
     float  f1=0.1f;
     float  f2=(float)0.1;//两句不一样
     long l1=12345678,l2=88888888888888L;
     byte b1=1,b2=2,b3=127;
     i=i+j;
     System.out.println(i); 
     i=(i/100);
     System.out.println(i);
     i=(int)(i*0.1);
     char c1='c',c2=125;
     byte b=(byte)(b1-b2);
     char c=(char)(c1+c2-1);
     float f3=f1+f2;
     float f4=(float)(f1+f2*0.1);
     double d=d1*i+j;
     float f =(float)(d1*5+d2);
     }
}