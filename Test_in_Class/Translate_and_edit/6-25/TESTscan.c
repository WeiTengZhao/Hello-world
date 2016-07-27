/*
 * TESTscan.c
 *
 *  Created on: 2016年6月11日
 *      Author:Shao
 */

#include<stdio.h>
#include<ctype.h>
#include<string.h>

#define keywordSum 8

static char *keyword[keywordSum] = { "if", "else", "for", "while", "do", "int", "read",
		"write" };

static char doubleword[10] = "><=!";

static char singleword[50] = "-+*(){}:;,";

extern char Scanin[300], Scanout[300];

extern FILE *fin, *fout;
int TESTscan() {
	char ch, token[40];
	int es = 0, j, n;

	printf("请输入源程序文件名（包括路径）:");
	scanf("%s", Scanin);
	printf("请输入词法分析输出文件名（包括路径）：");
	scanf("%s", Scanout);

	if ((fin = fopen(Scanin, "r")) == NULL) {
		printf("\n 打开词法分析输入文件出错 \n");
		return (1);
	}

	if ((fout = fopen(Scanout, "w")) == NULL) {
		printf("\n 创建词法分析输出文件出错 \n");
		return (2);
	}

	ch = getc(fin);
	while (ch != EOF) {
		while (ch == ' ' || ch == '\n' || ch == '\t') {
			ch = getc(fin);
		} //空格、制表符、换行符跳过判断
		/*===================================================关键字判断==================================================*/
		if (isalpha(ch)) {
			token[0] = ch;
			j = 1;
			ch = getc(fin);
			while (isalnum(ch)) {
				token[j++] = ch;
				ch = getc(fin);
			}
			token[j] = '\0';

			int n = 0;
			while ((n < keywordSum) && strcmp(token, keyword[n])) {
				n++;
			}
			if (n >= keywordSum) {
				fprintf(fout, "%s\t%s\n", "ID", token);
			} else {
				fprintf(fout, "%s\t%s\n", token, token);
			}
		}
		/*========================================================数字判断=================================================*/
		else if (isdigit(ch)) {
			token[0] = ch;
			j = 1;
			ch = getc(fin);
			while (isdigit(ch)) {
				token[j++] = ch;
				ch = getc(fin);
			}
			token[j] = '\0';
			fprintf(fout, "%s\t%s\n", "NUM", token);
		}
		/*========================================================实数判断=================================================
		 else if (isdigit(ch)) {
		 token[0] = ch;
		 j = 1;
		 int dot = 0;
		 ch = getc(fin);
		 while (isdigit(ch) || ch == ".") {
		 token[j++] = ch;
		 ch = getc(fin);
		 dot++;
		 }
		 if (dot == 1) {
		 token[j] = '\0';
		 fprintf(fout, "%s\t%s\n", "实数", token);
		 } else if (dot > 1) {
		 ch = getc(fin);
		 es = 4;
		 fprintf(fout, "%s\t%s\n", "ERROR", token);

		 } else {
		 token[j] = '\0';
		 fprintf(fout, "%s\t%s\n", "NUM", token);
		 }
		 }*/
		/*========================================================单符号串处理=================================================*/
		else if (strchr(singleword, ch) > 0) {
			token[0] = ch;
			token[1] = '\0';
			ch = getc(fin);
			fprintf(fout, "%s\t%s\n", token, token);
		}
		/*========================================================++处理=================================================
		 else if (strchr(singleword, ch) > 0) {
		 token[0] = ch;
		 token[1] = '\0';
		 ch = getc(fin);
		 if (ch == "+" && token[0] == ch) {
		 token[0] = ch;
		 token[1] = '\0';
		 ch = getc(fin);
		 fprintf(fout, "%s\t%s\n", token, token);
		 }
		 }*/
		/*========================================================负数处理=====================================================
		 else if (strchr(singleword, ch) > 0) {
		 token[0] = ch;
		 token[1] = '\0';
		 ch = getc(fin);
		 if (ch == "-" && isdigit(ch)) {
		 token[0] = ch;
		 j = 1;
		 ch = getc(fin);
		 while (isdigit(ch)) {
		 token[j++] = ch;
		 ch = getc(fin);
		 }
		 }*/
		/*========================================================双符号串处理=================================================*/
		else if (strchr(doubleword, ch) > 0) {
			token[0] = ch;
			ch = getc(fin);
			if (ch == '=') {
				token[1] = ch;
				token[2] = '\0';
				ch = getc(fin);
			} else {
				token[1] = '\0';
			}
				fprintf(fout, "%s\t%s\n", token, token);

		}

		/*========================================================&&、||处理=================================================/
		 else if (ch == "&" || ch == "|") {
		 token[0] = ch;
		 ch = getc(fin);
		 if (token[0] == ch) {
		 fprintf(fout, "%s\t%s\n", token, token);
		 } else {
		 es = 5;
		 fprintf(fout, "%s\t%s\n", "ERROR", token);
		 }
		 }*/
		/*========================================================注释处理=================================================*/
		else if (ch == '/') {
			ch = getc(fin);
			if (ch == '*') {
				char ch1;
				ch1 = getc(fin);
				do {
					ch = ch1;
					ch1 = getc(fin);
				} while ((ch != '*' || ch1 != '/') && ch1 != EOF);
				ch = getc(fin);
			} else {
				token[0] = '/';
				token[1] = '\0';
				fprintf(fout, "%s\t%s\n", token, token);
			}
		} else {
			token[0] = ch;
			token[1] = '\0';
			ch = getc(fin);
			es = 3;
			fprintf(fout, "%s\t%s\n", "ERROR", token);
		}
	}
	fclose(fin);
	fclose(fout);
	return (es);
}



