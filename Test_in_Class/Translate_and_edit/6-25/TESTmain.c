/*
 * TESTmain.c
 *
 *  Created on: 2016��6��11��
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
		printf("�ʷ������д�����ֹͣ");
	}else {
		printf("�ʷ������ɹ�");
	}
	if (es == 0) {
		es = TESTparse(); //���﷨����
		if (es == 0) printf("�﷨�����ɹ�!\n");
		else printf("�﷨��������!\n");
	}
	system("pause");
}

