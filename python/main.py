from language import *
from colorama.ansi import Fore

print(Fore.LIGHTBLUE_EX + "\n" + "\n" +
                "\n" +
                "___  ____ ____ _ ____ _ ____ _  _    _  _ ____ _  _ _ _  _ ____    ___ ____ ____ _  _ _  _ _ ____ _  _ ____ ____ \n" +
                "|  \\ |___ |    | [__  | |  | |\\ |    |\\/| |__| |_/  | |\\ | | __     |  |___ |    |__| |\\ | | |  | |  | |___ [__  \n" +
                "|__/ |___ |___ | ___] | |__| | \\|    |  | |  | | \\_ | | \\| |__]     |  |___ |___ |  | | \\| | |_\\| |__| |___ ___] \n" +
                "                                                                                                                 \n" +
                  "                                                                                     https://github.com/alii76tt" +
                "")

while True:
    try:
        answer = input("Select your language(TR/EN): ")
        print()
        language = Language(language=answer)
        if answer == "TR" or answer == "tr":
            language.answerTr()
            break
        elif answer == "EN" or answer == "en":
            language.answerEn()
            break
        else:
            print("Please enter correct value!")
    except KeyboardInterrupt:
        print("\n" + "Goodbye, Friend!")
        quit()