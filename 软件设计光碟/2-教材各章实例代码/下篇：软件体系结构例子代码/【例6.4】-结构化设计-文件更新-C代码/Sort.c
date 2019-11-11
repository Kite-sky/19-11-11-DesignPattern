#include "funs.h"

void Sort(char** Sale, int countOfLine)
{
    char *temp;
    int indexFirst;
    int indexSecond;
    for(indexFirst = 0;indexFirst < countOfLine - 1; indexFirst++)
        for(indexSecond = indexFirst+1;indexSecond < countOfLine ;indexSecond++)
            if(strcmpi(Sale[indexFirst], Sale[indexSecond])>0)
            {
                temp=Sale[indexFirst];
                Sale[indexFirst]=Sale[indexSecond];
                Sale[indexSecond]=temp;
            }
}
