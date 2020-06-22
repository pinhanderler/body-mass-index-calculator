import java.util.Scanner;import java.util.Scanner;
import java.text;

public class BodyMassIndexCalculator {
    private static final double UNDERWEIGHT   = 18.5;
    private static final double NORMALLY      = 24.9;
    private static final double OVERWEIGHT    = 29.9;
    private static final double OBESE         = 39.9;
    private static final double EXTREME_OBESE = 39.9;

    private static final String MESSAGE_LOSE_WEIGHT = " You need to lose weight";
    private static final String MESSAGE_GAIN_WEIGHT = " You need to gain weight";

    private enum Weight {
        UNDERWEIGHT("Underweight"),
        NORMAL("Normal"),
        OVERWEIGHT("Overweight"),
        OBESE("Obese"),
        EXTREME_OBESE("Extreme obese");

        private String name;
        Weight (String name) {
            this.name = name;
        }
        public String getName() { return name; }
    }

    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your weight");
        double kilo = s.nextFloat();
        System.out.println("Enter your height (cm): ");
        double boy = s.nextInt();
        double boy2 = Math.pow(boy / 100, 2); // change to normal name
        double vki = kilo / boy2;

        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("Body Mass Index: " + df.format(vki));
        System.out.println("Status: ");

        Weight weight = getWeight(vki);
        System.out.println(weight.name);
        switch (weight) {
            case UNDERWEIGHT:
                System.out.println(df.format(UNDERWEIGHT * boy2 -kilo) + MESSAGE_GAIN_WEIGHT);
                break;
            case NORMAL:
                break;
            case OVERWEIGHT:
            case OBESE:
            case EXTREME_OBESE:
                System.out.println(df.format(kilo - NORMALLY * boy2) + MESSAGE_LOSE_WEIGHT);
                break;
        }
    }

    private static Weight getWeight(double vki) {
        if (vki <= UNDERWEIGHT)   return Weight.UNDERWEIGHT;
        if (vki <= NORMALLY)      return Weight.NORMAL;
        if (vki <= OVERWEIGHT)    return Weight.OVERWEIGHT;
        if (vki <= OBESE)         return Weight.OBESE;
        if (vki <= EXTREME_OBESE) return Weight.EXTREME_OBESE;
        throw new IllegalArgumentException("Doesn't match any category");
    }
}

    private static final String MESSAGE_LOSE_WEIGHT = " You need to lose weight";
    private static final String MESSAGE_GAIN_WEIGHT = " You need to gain weight";

    private enum Weight {
        UNDERWEIGHT("Underweight"),
        NORMAL("Normal"),
        OVERWEIGHT("Overweight"),
        OBESE("Obese"),
        EXTREME_OBESE("Extreme obese");

        private String name;
        Weight (String name) {
            this.name = name;
        }
        public String getName() { return name; }
    }

    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your weight");
        double kilo = s.nextFloat();
        System.out.println("Enter your height (cm): ");
        double boy = s.nextInt();
        double boy2 = Math.pow(boy / 100, 2); // change to normal name
        double vki = kilo / boy2;

        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("Body Mass Index: " + df.format(vki));
        System.out.println("Status: ");

        Weight weight = getWeight(vki);
        System.out.println(weight.name);
        switch (weight) {
            case UNDERWEIGHT:
                System.out.println(df.format(UNDERWEIGHT * boy2 -kilo) + MESSAGE_GAIN_WEIGHT);
                break;
            case NORMAL:
                break;
            case OVERWEIGHT:
            case OBESE:
            case EXTREME_OBESE:
                System.out.println(df.format(kilo - NORMALLY * boy2) + MESSAGE_LOSE_WEIGHT);
                break;
        }
    }

    private static Weight getWeight(double vki) {
        if (vki <= UNDERWEIGHT)   return Weight.UNDERWEIGHT;
        if (vki <= NORMALLY)      return Weight.NORMAL;
        if (vki <= OVERWEIGHT)    return Weight.OVERWEIGHT;
        if (vki <= OBESE)         return Weight.OBESE;
        if (vki <= EXTREME_OBESE) return Weight.EXTREME_OBESE;
        throw new IllegalArgumentException("Doesn't match any category");
}
    }
