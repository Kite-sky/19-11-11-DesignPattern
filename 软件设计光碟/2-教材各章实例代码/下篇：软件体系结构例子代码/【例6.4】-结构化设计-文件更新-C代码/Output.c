#include "funs.h"

void Output(char** Sale, char* state,char* fileName)
{
    char pathOfFile[PATHSIZE];
    int indexOfLine = 0;

    strcpy(pathOfFile,"ProcessedFiles/");
    strcat(pathOfFile, state);
    strcat(pathOfFile, fileName);

    FILE* out = fopen(pathOfFile,"w");

    if(strcmp(state, "Sort_"))
    {
        while(Sale[indexOfLine] != NULL)
        {
            fprintf(out, "%s\n", Sale[indexOfLine]);
            indexOfLine++;
        }
    }
    else
    {
        while(Sale[indexOfLine] != NULL)
        {
            fprintf(out, "%s\n", Sale[indexOfLine]);
            free(Sale[indexOfLine]);
            indexOfLine++;
        }
    }



    fclose(out);
}
