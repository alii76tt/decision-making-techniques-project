
import java.util.*;

public class Transactions
{

    public static void theCostOfOptimism(int numberOfAlternatives, int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language) {
        String name;
        int min = table[0][0];
        for (int i = 0; i < numberOfAlternatives; i++)
        {
            for (int j = 0; j < numberOfNaturalStates; j++)
            {
                if (table[i][j] < min)
                {
                    min = table[i][j];
                    alternativeName = alternativeNames[i];
                }
            }
        }

        name = getName(language, "İyimserlik", "Optimism");
        getResult(name, alternativeName, language, min);

    }
    public static void theProfitOfOptimism(int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language) {
        String name;
        int max = table[0][0];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < numberOfNaturalStates; j++) {
                if (max < table[i][j]) {
                    max = table[i][j];
                    alternativeName = alternativeNames[i];
                }
            }
        }

        name = getName(language, "İyimserlik", "Optimism");
        getResult(name, alternativeName, language, max);
    }

    public static void theCostOfPessimism(int numberOfAlternatives, int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language) {
        String name;
        int[] newValues = new  int[numberOfAlternatives];
        int min;
        int newValue = newValues[0];

        for (int i = 0; i < numberOfAlternatives; i++) {
            min = table[i][0];
            for (int j = 0; j < numberOfNaturalStates; j++) {
                if (min > table[i][j]) {
                    min = table[i][j];
                }
            }

            newValues[i] = min;
            for (int k : newValues) {
                if (newValue <= k) {
                    newValue = k;
                    alternativeName = alternativeNames[i];

                }
            }
        }



        name = getName(language, "Kotümserlik", "Pessimist");
        getResult(name, alternativeName, language, newValue);
    }
    public static void theProfitOfPessimism(int numberOfAlternatives, int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language) {
        String name;
        int[] newValues = new  int[numberOfAlternatives];
        int newValue;

        for (int i = 0; i < numberOfAlternatives; i++) {
            newValues[i] = table[i][0];
            for (int j = 0; j < numberOfNaturalStates; j++) {
                if (table[i][j] < newValues[i]) {
                    newValues[i] = table[i][j];
                }
            }

        }
        newValue = newValues[0];
        int counter = 0;
        for (int k : newValues) {
            if (newValue <= k) {
                newValue = k;
            }
            alternativeName = alternativeNames[counter];
            counter += 1;
        }

        name = getName(language, "Kotümserlik", "Pessimist");
        getResult(name, alternativeName, language, newValue);
    }

    // error
    public static void theCostOfEqualProbability(int numberOfAlternatives, int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language) {
        String name;
        double min = 0;
        double[] min1 = new double[numberOfAlternatives];
        double x;
        double y = 0;

        for (int i = 0; i < numberOfAlternatives; i++)
        {
            x = 0;
            for (int j = 0; j < numberOfNaturalStates; j++)
            {
                x += (table[i][j] / numberOfNaturalStates);
            }
            min1[i] = x;
            if (min1[i] <= y)
            {
                min = min1[i];
                alternativeName = alternativeNames[i];
            }
            y = min1[i];
        }
        name = getName(language, "Eş Olasılık", "Probability");
        getResult(name, alternativeName, language, (int) min);
    }
    public static void theProfitOfEqualProbability(int numberOfAlternatives, int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language) {
        String name;
        double max = 0;
        double x = 0;
        double y = 0;
        double[] newMaxTable = new double[numberOfAlternatives];

        for (int i = 0; i < numberOfAlternatives; i++)
        {
            for (int j = 0; j < numberOfNaturalStates; j++)
            {
                double k = (table[i][j] / numberOfNaturalStates);
                x +=  k;
            }
            newMaxTable[i] = x;
        }

        for (int i=0;i<newMaxTable.length;i++){
            if (newMaxTable[i] >= y)
            {
                max = newMaxTable[i];
                alternativeName = alternativeNames[i];
            }
            y = newMaxTable[i];
        }

        name = getName(language, "Eş Olasılık", "Probability");
        getResult(name, alternativeName, language, (int) max);
    }

    public static void theCostOfHurwicz(int numberOfAlternatives, int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language) {
        String name;
        double hurwics = getAlfa(language);
        double[] totalValue = new double[numberOfAlternatives];
        double min;
        double max;
        for (int i = 0; i < numberOfAlternatives; i++)
        {
            min = table[i][0];
            max = table[i][0];
            for (int j = 0; j < numberOfNaturalStates; j++)
            {
                if (table[i][j] < min)
                {
                    min = table[i][j];
                }
                if (table[i][j] > max)
                {
                    max = table[i][j];
                }
            }
            totalValue[i] = (min * hurwics) + ((1 - hurwics) * max);
        }
        min = totalValue[0];
        for (int x = 0; x < numberOfAlternatives; x++)
        {
            if (totalValue[x] <= min)
            {
                min = totalValue[x];
                alternativeName = alternativeNames[x];
            }
        }

        name = getName(language, "Hurwics", "Hurwicz");
        getResult(name, alternativeName, language, (int) min);
    }
    public static void theProfitOfHurwicz(int numberOfAlternatives, int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language) {
        String name;
        double hurwicz = getAlfa(language);
        double[] totalValue = new double[numberOfAlternatives];
        double max = 0;
        for (int i = 0; i < numberOfAlternatives; i++)
        {
            double first = table[i][0];
            double second = table[i][0];
            for (int j = 0; j < numberOfNaturalStates; j++)
            {
                if (table[i][j] < first)
                {
                    first = table[i][j];
                }
                if (table[i][j] > second)
                {
                    second = table[i][j];
                }
            }
            totalValue[i] = (second * hurwicz) + ((1 - hurwicz) * first);
        }
        for (int x = 0; x < numberOfAlternatives; x++)
        {
            if (totalValue[x] >= max)
            {
                max = totalValue[x];
                alternativeName = alternativeNames[x];
            }
        }

        name = getName(language, "Hurwics", "Hurwicz");
        getResult(name, alternativeName, language, (int) max);
    }

    // error
    public  static void savage(int numberOfAlternatives, int numberOfNaturalStates, int[][] table, String[] alternativeNames, String alternativeName, String language){
        String name;
        int x=0;
        int savage = table[0][0];
        int max1 = table[0][0];
        int[][] savageTable = new int[numberOfAlternatives][numberOfNaturalStates];

        if (numberOfNaturalStates <=2){
            for (int i = 0; i < numberOfAlternatives; i++) {
                for (int j = 0; j < numberOfNaturalStates; j++) {
                    x=table[j][i];
                    System.out.println(x);
                    if (table[i][1] > table[i][0]) {
                        max1 = table[i][1];
                    }
                    savageTable[i][j] = max1 - table[i][j];
                }

            }

            for (int i = 0; i < numberOfAlternatives; i++) {
                for (int j = 0; j < numberOfNaturalStates; j++) {
                    //
                    if (table[i][0] > table[i][1]) {
                        max1 = table[i][0];
                    }
                    savageTable[i][j] = max1 - table[i][j];
                }
            }

            System.out.println("Savage Table");
            for (int i = 0; i < savageTable.length; i++) {
                System.out.print(alternativeNames[i]);
                for (int j = 0; j < numberOfNaturalStates; j++) {
                    System.out.print(" " + savageTable[i][j] + " ");
                }
                System.out.println();
            }

            for (int[] ints : savageTable) {
                for (int j = 0; j < numberOfNaturalStates; j++) {
                    if (savage > ints[j]) {
                        savage = ints[j];
                        alternativeName = alternativeNames[j];
                    }
                }
            }
        }

        name = getName(language, "Pişmanlık", "Savage");
        getResult(name, alternativeName, language,  savage);
    }

    private static String getName(String language, String nameTR, String nameEN) {
        String name;
        if (Objects.equals(language, "TR") || Objects.equals(language, "tr")) {
            name = nameTR;
        }else
            name = nameEN;
        return name;
    }
    public static double getAlfa(String language) {
        double alfa;
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (Objects.equals(language, "TR") || Objects.equals(language, "tr"))
                System.out.print("Lütfen hurwics değerini giriniz(Nokta kullanınız orn:0.2): ");
            else
                System.out.print("Please enter the hurwicz value (Use a dot ex:0.2): ");
            alfa = Double.parseDouble(scanner.nextLine());

            if (alfa > 0 && alfa <  1){
                break;
            }else
                if (Objects.equals(language, "TR") || Objects.equals(language, "tr"))
                    System.out.println("Alfa değerini kontrol ediniz!");
                else
                    System.out.println("Check the alpha value!");
        }
        return alfa;
    }
    private static void getResult(String name, String alternativeName, String language, int value) {
        if (Objects.equals(language, "TR") || Objects.equals(language, "tr"))
            System.out.println("(" + name + ") Seçilebilecek en iyi karar: " + alternativeName + " değeri: " + value);
        else
            System.out.println("(" + name + ") Best decision to choose: " + alternativeName + " value: " + value);
    }
}