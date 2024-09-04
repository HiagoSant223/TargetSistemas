import java.util.Scanner;

public class Teste05 {
    public static String inverterString(String s) {
        String sInvertida = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            sInvertida += s.charAt(i);
        }
        return sInvertida;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma string para inverter: ");
        String string = scanner.nextLine();
        scanner.close();
        
        System.out.println("String invertida: " + inverterString(string));
    }
}

