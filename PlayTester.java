import java.util.Scanner;

public class PlayTester {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Img.printImage("test\\Test\\chad.jfif");
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n\n\n\n\n\nEnter your combat code!");
            String x = input.nextLine();
            EnemyGroup player = new EnemyGroup(x);
            input.close();
        }
    }
}

