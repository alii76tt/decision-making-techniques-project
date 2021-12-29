import java.util.Scanner;

public class Main
{
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static void main(String[] args)
    {
        System.out.println("\n" + "\n" +
                "\n" +
                "___  ____ ____ _ ____ _ ____ _  _    _  _ ____ _  _ _ _  _ ____    ___ ____ ____ _  _ _  _ _ ____ _  _ ____ ____ \n" +
                "|  \\ |___ |    | [__  | |  | |\\ |    |\\/| |__| |_/  | |\\ | | __     |  |___ |    |__| |\\ | | |  | |  | |___ [__  \n" +
                "|__/ |___ |___ | ___] | |__| | \\|    |  | |  | | \\_ | | \\| |__]     |  |___ |___ |  | | \\| | |_\\| |__| |___ ___] \n" +
                "                                                                                                                 \n" +
                  "                                                                                     https://github.com/alii76tt" +
                "");
        String language;
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.print(GREEN + "Please select your language(TR/EN): ");
            language = scanner.next();

            if (language.equals("TR") || language.equals("tr")) {
                Language.answersTr();
                break;
            }else if (language.equals("en") || language.equals("EN")){
                Language.answersEn();
                break;
            }else
                System.out.println("Please enter correct value!");
        }

    }
}