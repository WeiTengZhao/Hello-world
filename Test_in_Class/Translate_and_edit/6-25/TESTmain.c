/*
 * TESTmain.c
 *
 *  Created on: 2016年6月11日
 *      Author: Administrator
 */
#include<stdio.h>
#include<ctype.h>
extern int TESTscan();
extern int TESTparse();
char Scanin[300],Scanout[300],Codeout[300];
FILE *fp,*fin,*fout;

void main(){
	int es = 0;
	es= TESTscan();
	if(es > 0) {
		printf("词法分析有错，编译停止");
	}else {
		printf("词法分析成功");
	}
	if (es == 0) {
		es = TESTparse(); //调语法分析
		if (es == 0) printf("语法分析成功!\n");
		else printf("语法分析错误!\n");
	}
	system("pause");
}

