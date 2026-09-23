import java.util.Scanner;

public class ConsoleIO{
    private Scanner myObj;

    ConsoleIO (Scanner myObj) {
        this.myObj = myObj;
    }

    public void afficher(String prompt) {
        System.out.println(prompt);
    }

    public String lireLigne() {
        return myObj.nextLine();
    }
}
