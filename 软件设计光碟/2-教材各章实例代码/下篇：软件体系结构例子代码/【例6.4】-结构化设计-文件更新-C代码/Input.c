#include "funs.h"

int Input(char** Sale ,char* nameOfFile)
{
    char temSale[SIZE];
    int ch;
    int indexOfChar = 0;
    int indexOfLine = 0;
    char* currentLine;
    char pathOfFile[PATHSIZE];

    strcpy(pathOfFile, "TextFiles/");
    strcat(pathOfFile , nameOfFile);

    FILE* in =  fopen( pathOfFile ,"r");


    while( (ch = getc(in) ) != EOF)
    {
        temSale[indexOfChar] = ch;
        indexOfChar++;
    }

    fclose(in);

    currentLine =strtok(temSale, "\n") ;

    Sale[indexOfLine] = (char*)malloc(LINESIZE * sizeof(char));
    strcpy(Sale[indexOfLine],currentLine);
    indexOfLine++;
    while(1)
    {
        currentLine = strtok(NULL, "\n") ;
        if(currentLine == NULL)
        {
            Sale[indexOfLine]  = NULL;
            break;
        }
        Sale[indexOfLine] = (char*)malloc(LINESIZE * sizeof(char));
        strcpy( Sale[indexOfLine],currentLine);
        indexOfLine++;
    }
        return indexOfLine;

}
