import java.util.Scanner;import java.text.DecimalFormat;public class Body Mass Index {
public static void main(String arg []){
Scanner s = new Scanner(System.in);
System.out.println("Enter your weight");
double kilo = s.nextFloat();
System.out.println("Enter your height (cm): ");
double boy = s.nextInt();
double vki = kilo/Math.pow(boy/100,2);
DecimalFormat df = new DecimalFormat("##.##");
System.out.println("Body Mass Index: "+df.format(vki));
System.out.println("Status: ");
if(vki<=18.5){
System.out.println("Underweight");
System.out.println(df.format(18.5*Math.pow(boy/100,2)-kilo)+" You need to gain weight"); }
else if(vki<=24.9){
System.out.println("Normaly"); }
else if(vki<=29.9){
System.out.println("Overweight");
System.out.println(df.format(kilo-24.9*Math.pow(boy/100,2))+" You need to lose weight");
}
else if(vki<=39.9){
System.out.println("Obese");
System.out.println(df.format(kilo-24.9*Math.pow(boy/100,2))+" You need to lose weight"); }
else if(vki<=39.9){
System.out.println("Extreme Obese");
System.out.println(df.format(kilo - 24.9 * Math.pow(boy / 100, 2)) + " You need to lose weight"); }
}
}
