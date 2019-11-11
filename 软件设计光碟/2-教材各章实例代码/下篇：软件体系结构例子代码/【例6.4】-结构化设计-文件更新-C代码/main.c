#include "funs.h"

int main()
{

    char* Sale[SALELINESIZE];
    int countOfLine;

    char ifInputWrong = 1;
    int indexOfFiles;
    char* nameOfFile;
    char* state;

    while(ifInputWrong)
    {
        printf("��ѡ������Ҫת���ļ������:\n");
        printf("��Sale1.txt\t��Sale2.txt\t��Sale3.txt\t��Sale.txt\n");
        scanf("%d", &indexOfFiles);
        switch( indexOfFiles)
        {
            case 1:
                nameOfFile = "Sale1.txt";
                ifInputWrong = 0;
                break;
            case 2:
                nameOfFile = "Sale2.txt";
                ifInputWrong = 0;
                break;
            case 3:
                nameOfFile = "Sale3.txt";
                ifInputWrong = 0;
                break;
            case 4:
                nameOfFile = "Sale4.txt";
                ifInputWrong = 0;
                break;
            default:
                printf("��Ǹ�����������������������룺\n");
                break;
        }
    }

    countOfLine = Input(Sale, nameOfFile);
    CorrectPoliticalError(Sale);
    state = "CorrectPoliticalError_";
    Output(Sale,  state, nameOfFile);
    CorrectY2KError(Sale);
    state = "CorrectY2KError_";
    Output(Sale,  state, nameOfFile);
    Sort(Sale,  countOfLine);
    state = "Sort_";
    Output(Sale,  state, nameOfFile);

    printf("ת���ɹ���ת������ļ�������ProcessedFiles�ļ���.\n");
    system("pause");
    return 0;
}
