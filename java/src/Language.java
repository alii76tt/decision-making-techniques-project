import java.util.Scanner;

public class Language {

    public static void answersTr() {
        Scanner scanner = new Scanner(System.in);

        int numberOfAlternatives;
        int numberOfNaturalStates;

        // number of alternative and natural situations
        System.out.print("Lütfen alternatif sayısını giriniz: ");
        numberOfAlternatives = scanner.nextInt();
        System.out.print("Lütfen doğal durum sayısını giriniz: ");
        numberOfNaturalStates = scanner.nextInt();

        int[] alternatives = new int[numberOfAlternatives];
        int[] naturalStates = new int[numberOfNaturalStates];
        int[][] table = new int[numberOfAlternatives][numberOfNaturalStates];
        String[] alternativesNames = new String[numberOfAlternatives];
        String[] naturalStatesNames = new String[numberOfNaturalStates];

        // enter alternative name
        for (int i = 0; i < alternatives.length; i++)
        {
            System.out.print((i + 1) + " . Alternatifinin ismini giriniz: ");
            alternativesNames[i] = new Scanner(System.in).nextLine();
        }

        // entering natural situations
        for (int i = 0; i < naturalStates.length; i++)
        {
            System.out.print((i + 1) + " . Doğal durumun ismini giriniz: ");
            naturalStatesNames[i] = new Scanner(System.in).nextLine();
        }

        // enter table values
        for (int i = 0; i < numberOfAlternatives; i++)
        {
            for (int j = 0 ; j < numberOfNaturalStates; j++)
            {
                System.out.print("[" + alternativesNames[i] + "] alternatifi [" + naturalStatesNames[j] + "] doğal durumundaki değerini giriniz: ");
                table[i][j] = Integer.parseInt(new Scanner(System.in).nextLine());
            }
            System.out.println();
        }

        System.out.println("Tablonuz misali görünümü.");
        // show table
        for (int i = 0; i < numberOfAlternatives; i++) {
            System.out.print(alternativesNames[i]);
            for (int j = 0; j < numberOfNaturalStates; j++) {
                System.out.print(" " + table[i][j] + " ");
            }
            System.out.println();
        }

        String alternativeName = alternativesNames[0];

        while (true){

            System.out.print("Problem türü maliyet mi?(E/H): ");
            String answer = scanner.next();

            if (answer.equals("E") || answer.equals("e"))
            {
                Transactions.theCostOfOptimism(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                Transactions.theCostOfPessimism(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                Transactions.theCostOfEqualProbability(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                Transactions.theCostOfHurwicz(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                Transactions.savage(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                break;
            }
            else if (answer.equals("H") || answer.equals("h"))
            {
                Transactions.theProfitOfOptimism(numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                Transactions.theProfitOfPessimism(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                Transactions.theProfitOfEqualProbability(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                Transactions.theProfitOfHurwicz(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                Transactions.savage(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "TR");
                break;
            }else
                System.out.println("Lütfen geçerli değer giriniz!");
        }
    }
    public static void answersEn() {
        Scanner scanner = new Scanner(System.in);

        int numberOfAlternatives;
        int numberOfNaturalStates;

        // number of alternative and natural situations
        System.out.print("Please enter the number of alternatives:");
        numberOfAlternatives = scanner.nextInt();
        System.out.print("Please enter the number of natural states: ");
        numberOfNaturalStates = scanner.nextInt();

        int[] alternatives = new int[numberOfAlternatives];
        int[] naturalStates = new int[numberOfNaturalStates];
        int[][] table = new int[numberOfAlternatives][numberOfNaturalStates];
        String[] alternativesNames = new String[numberOfAlternatives];
        String[] naturalStatesNames = new String[numberOfNaturalStates];

        // enter alternative name
        for (int i = 0; i < alternatives.length; i++)
        {
            System.out.print((i + 1) + " . Enter the name of the alternative: ");
            alternativesNames[i] = new Scanner(System.in).nextLine();
        }

        // entering natural situations
        for (int i = 0; i < naturalStates.length; i++)
        {
            System.out.print((i + 1) + " . Enter the name of the natural state: ");
            naturalStatesNames[i] = new Scanner(System.in).nextLine();
        }

        // enter table values
        for (int i = 0; i < numberOfAlternatives; i++)
        {
            for (int j = 0 ; j < numberOfNaturalStates; j++)
            {
                System.out.print("[" + alternativesNames[i] + "] alternative [" + naturalStatesNames[j] + "] enter the value in its natural state: ");
                table[i][j] = Integer.parseInt(new Scanner(System.in).nextLine());
            }
            System.out.println();
        }

        System.out.println("Looks like your table.");
        // show table
        for (int i = 0; i < numberOfAlternatives; i++) {
            System.out.print(alternativesNames[i]);
            for (int j = 0; j < numberOfNaturalStates; j++) {
                System.out.print(" " + table[i][j] + " ");
            }
            System.out.println();
        }

        String alternativeName = alternativesNames[0];

        while (true){

            System.out.print("Is the problem type cost? (Y/N): ");
            String answer = scanner.next();

            if (answer.equals("Y"))
            {
                Transactions.theCostOfOptimism(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                Transactions.theCostOfPessimism(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                //Transactions.theCostOfEqualProbability(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                Transactions.theCostOfHurwicz(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                Transactions.savage(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                break;
            }
            else if (answer.equals("N"))
            {
                Transactions.theProfitOfOptimism(numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                Transactions.theProfitOfPessimism(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                Transactions.theProfitOfEqualProbability(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                Transactions.theProfitOfHurwicz(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                Transactions.savage(numberOfAlternatives, numberOfNaturalStates, table, alternativesNames, alternativeName, "EN");
                break;
            }else
                System.out.println("Please enter valid value!");
        }
    }
}