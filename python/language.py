from transactions import Transactions

class Language:
    def __init__(self, language):
        self.language = language

    def answerTr(self):
        alternativesNames = []
        naturalStatesNames = []

        # number of alternative and natural situations
        numberOfAlternatives = int(input('Lütfen alternatif sayısını giriniz: '))
        numberOfNaturalStates = int(input('Lütfen doğal durum sayısını giriniz: '))

        print()
        # enter alternative name
        for i in range(0, numberOfAlternatives):
            result = input(f"{i + 1}. Alternatifinin ismini giriniz: ")
            alternativesNames.append(str(result))
            i += 1

        print()
        # enter natural situations
        for i in range(0, numberOfNaturalStates):
            result = str(input(f"{i + 1}. Doğal durumun ismini giriniz:: "))
            naturalStatesNames.append(result)

        print()
        tableCache = []
        table = []
        # enter table values
        for i in range(0, numberOfAlternatives):
            for j in range(0, numberOfNaturalStates):
                value = int(input(
                    f"[{alternativesNames[i]}] alternatifinin [{naturalStatesNames[j]}] doğal durumundaki değeri giriniz: "))
                tableCache.append(value)
            table.append(tableCache)
            tableCache = []
        
        print()
        # show table
        print("Tablo misali görünüm\n")
        counter = 0
        for item in table:
            print("\r" + alternativesNames[counter] + " --> " + str(item))
            counter += 1

        print()
        while True:
            choice = str(input("Probleminiz maliyet mi(E/H): "))
            if choice == "e" or choice == "E":
                transactionsCost = Transactions(language="tr", table=table, isCost=True,
                                            alternativesNames=alternativesNames)
                transactionsCost.optimism()
                transactionsCost.pessimism()
                transactionsCost.hurwicz()
                transactionsCost.laplace(numberOfNaturalStates=numberOfNaturalStates)
                break
            elif choice == "H" or choice == "h":
                transactionsProfit = Transactions(language=self.language, table=table, isCost=False,
                                            alternativesNames=alternativesNames)
                transactionsProfit.optimism()
                transactionsProfit.pessimism()
                transactionsProfit.hurwicz()
                transactionsProfit.laplace(numberOfNaturalStates=numberOfNaturalStates)
                break
            else:
                print("Lütfen geçerli değer giriniz!")

    def answerEn(self):
        alternativesNames = []
        naturalStatesNames = []

        # number of alternative and natural situations
        numberOfAlternatives = int(input('Please enter the number of alternatives: '))
        numberOfNaturalStates = int(input('Please enter the number of natural states: '))

        print()
        # enter alternative name
        for i in range(0, numberOfAlternatives):
            result = input(f"{i + 1}. Enter the name of the alternative: ")
            alternativesNames.append(str(result))
            i += 1

        print()
        # enter natural situations
        for i in range(0, numberOfNaturalStates):
            result = str(input(f"{i + 1}. Enter the name of the natural state: "))
            naturalStatesNames.append(result)

        print()
        tableCache = []
        table = []
        # enter table values
        for i in range(0, numberOfAlternatives):
            for j in range(0, numberOfNaturalStates):
                value = int(input(
                    f"[{alternativesNames[i]}] alternative [{naturalStatesNames[j]}] enter the value in its natural state: "))
                tableCache.append(value)
            table.append(tableCache)
            tableCache = []
        
        print()
        # show table
        print("Looks like your table\n")
        counter = 0
        for item in table:
            print("\r" + alternativesNames[counter] + " --> " + str(item))
            counter += 1
            
        print()
        while True:
            choice = str(input("Is the problem type cost?(Y/N): "))

            if choice == "y" or choice == "Y":
                transactionsCost = Transactions(language=self.language, table=table, isCost=True,
                                                alternativesNames=alternativesNames)
                transactionsCost.optimism()
                transactionsCost.pessimism()
                transactionsCost.hurwicz()
                transactionsCost.laplace(numberOfNaturalStates=numberOfNaturalStates)
                break
            elif choice == "N" or choice == "n":
                transactionsProfit = Transactions(language=self.language, table=table, isCost=False,
                                                  alternativesNames=alternativesNames)
                transactionsProfit.optimism()
                transactionsProfit.pessimism()
                transactionsProfit.hurwicz()
                transactionsProfit.laplace(numberOfNaturalStates=numberOfNaturalStates)
                break
            else:
                print("Please enter valid value!")
