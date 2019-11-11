#include "funs.h"

void CorrectPoliticalError(char** Sale)
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

        currentLine = Sale[indexOfLines];

        currentWord = strtok(currentLine," ");
        while(currentWord)
        {
            wordsOfcurrentLine[countOfWords] = currentWord;
            currentWord = strtok(NULL," ");
            countOfWords++;
        }

        if(!strcmpi(wordsOfcurrentLine[countOfWords - 4],  "Republic")
            && !strcmpi(wordsOfcurrentLine[countOfWords - 3],  "Of")
            && !strcmpi(wordsOfcurrentLine[countOfWords - 2],  "China") )
        {
            while(indexOfWords < countOfWords)
            {
                if(indexOfWords == countOfWords - 4)
                {
                    strcat(processedLine, "Taiwan");
                    strcat(processedLine, " ");
                }
                else if(indexOfWords  != countOfWords - 3 && indexOfWords  != countOfWords - 2)
                {
                    strcat(processedLine, wordsOfcurrentLine[indexOfWords]);
                    strcat(processedLine, " ");
                }
                else if( indexOfWords  == countOfWords - 1 )
                {
                    strcat(processedLine, wordsOfcurrentLine[indexOfWords]);
                }
                indexOfWords++;
            }
        }
        else
        {
            while(indexOfWords < countOfWords - 1)
            {
                strcat(processedLine, wordsOfcurrentLine[indexOfWords]);
                strcat(processedLine, " ");
                indexOfWords++;
            }
            strcat(processedLine, wordsOfcurrentLine[indexOfWords]);

        }

        strcpy(Sale[indexOfLines],processedLine);
        indexOfLines++;
    }
}
