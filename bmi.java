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
  /*Body mass index
Wikipedia, the free encyclopedia

Some information in this article is unsourced. You may look for the discussion page for details. You can contribute to Wikipedia by adding resources in accordance with the article.
Body mass index (BMI) is calculated by dividing body mass (kg) by the square of its length in meters. The ideal weight is obtained by multiplying the desired BMI by the square of the length.

The table showing the BMI and body weight values ​​for adults aged 19-24 is as follows:

Age group BMI range Classification
19-24 -20 Poor
19-24 20 to 24.9 Normal
19-24 25-29.9 Slightly fat
19-24 30 to 34.9 Fat
19-24 35-44,9 Important for health
19-24 45-49.9 Excessive fat
19-24 +49,9 Morbid (fatal) fat
There may be an increase in body mass index as the age progresses.

Appropriate body mass index values ​​by age are as follows:

Age Ideal BMI
19-24 19-24
25-34 20-25
35-44 21-26
45-54 22-27
55-65 23-28
+65 24-29
Body Mass Index (BMI) = Body Weight (kg.) / Square of the length (m.)
Ideal Weight = BMI value desired to be reached {\ displaystyle \ times} {\ displaystyle \ times} Square of height
• Sample Ideal Weight = 24 {\ displaystyle \ times} {\ displaystyle \ times} (1.60 {\ displaystyle \ times} {\ displaystyle \ times} 1.60) = 61.4 kg

How is body surface area calculated?
Body surface area is linked to weight and height. 
If you are curious about the total outer surface area of ​​your body in space, you can calculate it with this tool. 
The m2 I calculate is of course a theoretical calculation.
The exact area of ​​the body can only be calculated using the necessary software by transferring this three-dimensional data to the computer environment after scanning the body with a three-dimensional scanning device.
*/
}
}
