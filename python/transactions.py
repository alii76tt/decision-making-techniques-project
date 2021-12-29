class Transactions:
    def __init__(self, language, table, isCost, alternativesNames):
        self.language = language
        self.table = table
        self.isCost = isCost
        self.alternativesNames = alternativesNames

    def optimism(self):
        maxValues = []
        counter = 0
        for i in self.table:
            maxValues.append([max(i)])
            counter += 1
        
        if self.isCost:
            alternativeName = min(self.alternativesNames)
            result = min(maxValues)
        else:
            alternativeName = min(self.alternativesNames)
            result = max(maxValues)

        name = Transactions.getName(self, nameTR="İyimserlik", nameEN="Optimism")
        Transactions.getResult(self, name, alternativeName, result)

    def pessimism(self):
        minValues = []

        counter = 0
        for i in self.table:
            minValues.append([min(i)])
            counter += 1

        if self.isCost:
            alternativeName = max(self.alternativesNames)
            result = min(minValues)
        else:
            alternativeName = min(self.alternativesNames)
            result = max(minValues)

        name = Transactions.getName(self, nameTR="Kötümserlik", nameEN="Pessimist")
        Transactions.getResult(self, name, alternativeName, result)

    def hurwicz(self):
        hurwiczTable = []
        hurwiczValue = Transactions.getAlfa(self)
        for item in self.table:
            resultHurwicz = (max(item) * hurwiczValue + min(item) * (1 - hurwiczValue))
            hurwiczTable.append(resultHurwicz)
            resultHurwicz = 0

        if self.isCost:
            alternativeName = min(self.alternativesNames)
            result = min(hurwiczTable)
        else:
            alternativeName = min(self.alternativesNames)
            result = max(hurwiczTable)

        name = Transactions.getName(self, nameTR="Hurwics", nameEN="Hurwicz")
        Transactions.getResult(self, name, alternativeName, result)

    def laplace(self, numberOfNaturalStates):
        laplaceValue = 1 / numberOfNaturalStates
        laplaceTable = []

        total = 0
        for item in self.table:
            for i in item:
                value = i * laplaceValue
                total += value
                value = 0
            laplaceTable.append(total)
            total = 0

        if self.isCost:
            alternativeName = min(self.alternativesNames)
            result = min(laplaceTable)
        else:
            alternativeName = max(self.alternativesNames)
            result = max(laplaceTable)

        name = Transactions.getName(self, nameTR="Eş Olasılık", nameEN="Laplace")
        Transactions.getResult(self, name, alternativeName, result)

    def getAlfa(self):
        while True:
            try:
                if self.language == "TR" or self.language == "tr":
                    hurwiczValue = float(input("Lütfen hurwics değerini giriniz(Nokta kullanınız orn:0.2): "))
                else:
                    hurwiczValue = float(input("Please enter the hurwicz value (Use a dot ex:0.2): "))

                if hurwiczValue < 0 or hurwiczValue > 1:
                    if self.language == "TR" or self.language == "tr":
                        print("Alfa değerini kontrol ediniz!")
                    else:
                        print("Check the alpha value!")
                else:
                    break
            except ValueError:
                print("Check your value!")

        return hurwiczValue

    def getName(self, nameTR, nameEN):
        if self.language == "TR" or self.language == "tr":
            name = nameTR
        else:
            name = nameEN
        return name

    def getResult(self, name, alternativeName, value):
        if self.language == "TR" or self.language == "tr":
            print("(" + name + ") Seçilebilecek en iyi karar: " + alternativeName + " alternatifi ve değeri: " + str(value))
        else:
            print("(" + name + ") Best decision to choose: " + alternativeName + " alternative and value: " + str(value))
