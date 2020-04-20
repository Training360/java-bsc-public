package introcontrol;

public class IntroControl {

    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();
        System.out.println(introControl.subtractTenIfGreaterThanTen(0));
        System.out.println(introControl.subtractTenIfGreaterThanTen(10));
        System.out.println(introControl.subtractTenIfGreaterThanTen(15));

        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(1));

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Jane"));

        System.out.println("calculateBonus");
        System.out.println(introControl.calculateBonus(0));
        System.out.println(introControl.calculateBonus(100));
        System.out.println(introControl.calculateBonus(1_000_000));
        System.out.println(introControl.calculateBonus(1_000_090));

        System.out.println("calculateMeterReadingsDifference");
        System.out.println(introControl.calculateConsumption(10, 20));
        System.out.println(introControl.calculateConsumption(9990, 10));

        System.out.println("printNumbers");
        introControl.printNumbers(10);
        System.out.println("printNumbersBetween");
        introControl.printNumbersBetween(10, 20);

        System.out.println("printNumbersBetweenAnyDirection");
        introControl.printNumbersBetweenAnyDirection(10, 20);
        System.out.println("printNumbersBetweenAnyDirection - reverse");
        introControl.printNumbersBetweenAnyDirection(20, 10);

        System.out.println("printOddNumbers - 1");
        introControl.printOddNumbers(1);
        System.out.println("printOddNumbers - 10");
        introControl.printOddNumbers(10);
        System.out.println("printOddNumbers - 11");
        introControl.printOddNumbers(11);
    }

    public int subtractTenIfGreaterThanTen(int number) {
        if (number > 10) {
            return number - 10;
        } else {
            return number;
        }
    }

    public String greetingToJoe(String name) {
        if (name.equals("Joe")) {
            return "Hello Joe";
        } else {
            return "";
        }
    }

    public String describeNumber(int number) {
        if (number == 0) {
            return "zero";
        } else {
            return "not zero";
        }
    }

    public int calculateBonus(int sale) {
        if (sale >= 1_000_000) {
            return sale / 10;
        } else {
            return 0;
        }
    }


    public void printNumbers(int max) {
        for (int i = 0; i <= max; i++) {
            System.out.println(i);
        }
    }

    public void printNumbersBetween(int min, int max) {
        for (int i = min; i <= max; i++) {
            System.out.println(i);
        }
    }

    public void printNumbersBetweenAnyDirection(int a, int b) {
        if (b > a) {
            for (int i = a; i <= b; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = a; i >= b; i--) {
                System.out.println(i);
            }
        }
    }

    public void printOddNumbers(int max) {
        for (int i = 1; i <= max; i = i + 2) {
            System.out.println(i);
        }
    }

    public int calculateConsumption(int prev, int next) {
        if (prev <= next) {
            return next - prev;
        } else {
            return 10_000 - prev + next;
        }
    }

}

