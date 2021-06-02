/**
 * sum
 */
public class sum {

    public static void main(String args[]) {
         int a;
         int b,c;
         try{
         a=Integer.parseInt(args[0]);
         b=Integer.parseInt(args[1]);

         c=a+b;
         System.out.println(c);
         }catch(Exception e){
             System.out.println("errors");
         }
    }
}