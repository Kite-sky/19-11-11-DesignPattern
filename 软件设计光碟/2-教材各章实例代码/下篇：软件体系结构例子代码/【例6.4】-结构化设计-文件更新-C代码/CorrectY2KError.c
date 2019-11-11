#include "funs.h"

void CorrectY2KError(char** Sale)
{
    int indexOfLines = 0;

    while(Sale[indexOfLines] != NULL)
    {
        char processedLine[LINESIZE] = "";
        int countOfWords = 0;
        int indexOfWords = 0;
        char* currentLine;
        char* currentWord;
        char* wordsOfcurrentLine[LINESIZEOFWORD];
        char temCurrentTime[9];

        currentLine = Sale[indexOfLines];

        currentWord = strtok(currentLine," ");
        while(currentWord)
        {
            wordsOfcurrentLine[countOfWords] = currentWord;
            currentWord = strtok(NULL," ");
            countOfWords++;
        }

        strcpy(temCurrentTime, wordsOfcurrentLine[countOfWords - 1]);
        if(atoi(strtok(wordsOfcurrentLine[countOfWords - 1],  "-")) < 100)
        {
            while(indexOfWords < countOfWords - 1)
            {
                strcat(processedLine, wordsOfcurrentLine[indexOfWords]);
                strcat(processedLine, " ");
                indexOfWords++;
            }

            strcat(processedLine, "19");
            strcat(processedLine, temCurrentTime);

        }
        else
        {
            while(indexOfWords < countOfWords - 1)
            {
                strcat(processedLine, wordsOfcurrentLine[indexOfWords]);
                strcat(processedLine, " ");
                indexOfWords++;
            }
            strcat(processedLine, temCurrentTime);

        }

        strcpy(Sale[indexOfLines],processedLine);
        indexOfLines++;
    }
}
