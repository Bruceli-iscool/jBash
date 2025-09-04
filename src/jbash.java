import java.util.*;
import java.io.File;
public class jbash {
    public static void main(String args[]) {
        if (args[0].isEmpty()) {
            System.out.println("jBash Error! No Input File.");
        } else {
            Program program = new Program();
        }
    }
}
class Program {
    private String input;
    public Program(String file) {
        try (Scanner scanner = new Scanner(new File("example.txt"))) {
            while (scanner.hasNextLine()) {
                input += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("jBash Error! Could not Find Input File.");
        }
    }
    public void lex() {
        ArrayList<String> result = new ArrayList<String>();
        String z = "";
        boolean ifString = false;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            switch (c) {
                case '(': case ')': case ';': case '=': case '+': case '-': case '*': case '/':case '{': case '}':case ':':
                    if (!z.isEmpty()) {
                        result.add(z);
                        z = "";
                    }
                    result.add(String.valueOf(c));
                    break;
                case '"':
                    if (!z.isEmpty() && ifString) {
                        ifString = false;
                        result.add(z);
                        z = "";
                    } else {
                        ifString = true;
                    }
                    result.add("\"");
                    break;
                case ' ':
                    if (!z.isEmpty() && !ifString) {
                        result.add(z);
                        z = "";
                    } else if (ifString) {
                        z += c;
                    }
                    break;
                default:
                    z += c;
                    break;
            }
        }
        if (!z.isEmpty()) {
            result.add(z);
        }

        tokens = result;
    }
}