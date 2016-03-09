public class AreaTest{
   public static void main(String args[]){

      Circle c = new Circle();
      c.radius = 10;
      Rectangle r = new Rectangle();
      r.width  = 20;
      r.height = 30;
      System.out.println("圆的周长:"+c.circumference()); 
      System.out.println("矩形的面积:"+r.area());   
      }
}