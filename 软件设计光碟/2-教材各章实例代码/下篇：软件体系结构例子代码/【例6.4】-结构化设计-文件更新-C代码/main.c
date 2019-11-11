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
        printf("请选择您想要转化文件的序号:\n");
        printf("①Sale1.txt\t②Sale2.txt\t③Sale3.txt\t④Sale.txt\n");
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
                printf("抱歉您输入的序号有误，请重新输入：\n");
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

    printf("转化成功，转化后的文件保存在ProcessedFiles文件中.\n");
    system("pause");
    return 0;
}
