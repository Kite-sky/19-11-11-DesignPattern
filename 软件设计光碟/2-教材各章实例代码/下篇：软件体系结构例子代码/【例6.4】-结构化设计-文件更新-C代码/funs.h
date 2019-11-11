#ifndef FUNS_H_INCLUDED
#define FUNS_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 100000
#define SALELINESIZE 1500
#define LINESIZE 200
#define LINESIZEOFWORD 10
#define PATHSIZE 100


int Input(char** Sale, char *fileName);
void CorrectPoliticalError(char** Sale);
void CorrectY2KError(char** Sale);
void Sort(char** Sale, int countOfLine);
void Output(char** Sale, char*state,char *fileName);


#endif // FUNS_H_INCLUDED
