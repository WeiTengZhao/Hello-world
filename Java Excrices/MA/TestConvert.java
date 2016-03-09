public class TestConvert
{
  public static void main(String args[])
   {int i1=1;
    int i2=2;
    float f1=1.2f;
    double d1=(i1+i2)*f1;
    float f2=(float)((i2+i2)*1.2);//1.2为double，运算全部变成，全部强转
    byte b1=1;
    byte b2=2;
    byte b3=(byte)(b1+b2);
    System.out.println(b3);
    double d2=1e200;
    float  f3=(float)d2;//超出float范围，强转出来无限(Infinity)
    System.out.println(f3);
    long l1=123;
    long l2=88888888888888888L;//不加L默任为INT会溢出
    float f4=l1+l2+f1;
    long l=(long)f1;//小数位直接舍去
    }
}
    
    