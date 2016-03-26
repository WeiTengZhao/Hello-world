#include<stdio.h>
#include<ctype.h>
//#include "Testscan.c"
extern int Testscan();
char Scanin[300],Scanout[300];
FILE *fin, *fout;

void main() {
	int es = 0;
	es = TESTscan();
	if (es > 0) {
		printf("词法分析有错，编译停止");
	}
	else {"词法分析成功\n";}
}
