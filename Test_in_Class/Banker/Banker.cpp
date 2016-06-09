/*
 * Banker.cpp
 *
 *  Created on: 2016年6月8日
 *      Author: Administrator
 */
#include<iomanip>
#include<iostream>

using namespace std;
#define M 100 //总进程数
#define N 50 //总的资源种数
#define FALSE 0
#define TRUE 1
//M 个进程对N 类资源最大资源需求量
int MAX[M][N];//={{5,5,9},{5,3,6},{4,0,11},{4,2,5},{4,2,4}};M=4,N=
//系统可用资源数
int AVAILABLE[N];//={2,3,3};
//M 个进程已经得到N 类资源的资源量
int ALLOCATION[M][N];//={{2,1,2},{4,0,2},{4,0,5},{2,0,4},{3,1,4}};
//M 个进程还需要N 类资源的资源量
int NEED[M][N];//={{3,4,7},{1,3,4},{0,0,6},{2,2,1},{1,1,0}};
int Request[N];//={0,0,0};
int mess,need;
int main(void) {
	int i=0,j=0;
	char flag='Y',zt=' ';
	void showdata();
	void changedata(int);
	void restoredata(int);
	int checkerror(int);

	cout<<"请输入需申请资源的进程数:";
	cin>>mess;
	cout<<"请输入需申请资源的种类数:";
	cin>>need;
//============================================最大资源数=============================
	for (int a = 0;a < mess ;a++) {
		for (int b = 0; b < need;b++) {
			cout << "请输入资源数MAX:";
			cin >> MAX[a][b];
		}
	}
//===========================================已有资源数===============================
	for (int a = 0;a < mess ;a++) {
		for (int b = 0; b < need;b++) {
			cout<<"请输入已经拥有的资源数目 ALLOCATION:";
			cin >> ALLOCATION[a][b];
			NEED[a][b] = MAX[a][b] - ALLOCATION[a][b];
			if ( NEED[a][b] < 0) {
				cout << "输入的ALLOCATION数值错误;";
					b--;
					continue;
			}
		}
	}
//========================================现有资源数目=============================
	for (int a = 0;a < mess ;a++) {
		cout<<"请输入现有资源数目AVAILABLE:";
		cin >> AVAILABLE[a];
	}
//=================================================================================
	showdata();
	while(flag=='Y'||flag=='y') {
		i=-1;
		for (int a = 0;a < mess ;a++) {
		for (int b = 0; b < need;b++) {
			/*cout << "MAX[mess][need]:"<< MAX[a][b] <<endl ;
			cout << "ALLOCATION[mess][need]:"<< ALLOCATION[a][b] <<endl ;
			cout << "AVAILABLE[mess][need]:"<< AVAILABLE[a] <<endl ;
		*/}
	}
		cout<<"请输入需申请资源的进程号:";
		cin>>i;
		while(i < 0 ||i >= mess) {
			cout<<"输入的进程号不存在，重新输入!"<<endl;
			cin>>i;
		}
		cout<<"请输入进程"<<i<<"申请的资源数"<<endl;
		for (j=0;j<need;j++) {
			cout<<" 资源"<<j<<": ";
			cin>>Request[j];
			if(Request[j]>NEED[i][j]) {
				cout<<" 进程"<<i<<"申请的资源数大于进程"<<i<<"还需要"<<j<<"类资源的资源量!";
				cout<<" 申请不合理， 出错! 请重新选择!"<<endl<<" 按Y/N 键并回车后继续......"<<endl;
				cin>>zt;
				flag='N';
				break;
			}
			else {
				if(Request[j]>AVAILABLE[j]) {
					cout<<" 进程"<<i<<"申请的资源数大于系统可用"<<j<<"类资源的资源量!";
					cout<<"申请不合理，让该进程等待!，请重新选择!"<<endl<<"按Y/N 键并回车后继续......"<<endl;
					cin>>zt;
					flag='N';
					break;
				}
			}
		}
		if(flag=='Y'||flag=='y')
		{
			changedata(i);
			if(checkerror(i))
			{
				restoredata(i);
				showdata();
			}
			else
				showdata();
		}
		else
			showdata();
		cout<<endl;
		cout<<"是否继续银行家算法演示,按'Y'或'y'键继续,按'N'或'n'键退出演示: ";
		cin>>flag;
	}
	return 0;
}
void showdata() {
	int i,j;
	cout<<"系统可用的资源数为AVAILABLE:"<<endl<<endl;
	for (j=0;j<need;j++) cout<<"资源"<<j<<"\t";
	cout<<endl;
	for (j=0;j<need;j++) cout<<" "<<AVAILABLE[j]<<"\t";
	cout<<endl<<endl;
	cout<<"各进程还需要的资源量NEED:"<<endl<<endl;
	for (j=0;j<need;j++)cout<<"\t 资源"<<j;
	cout<<endl;
	for (i=0;i<mess;i++){
		cout<<"进程"<<i<<"\t";
		for (j=0;j<need;j++)cout<<setw(3)<<NEED[i][j]<<"\t";
		cout<<endl;
	}
	cout<<endl;
	cout<<"各进程已经得到的资源量ALLOCATION:"<<endl<<endl;
	for (j=0;j<need;j++) cout<<"\t 资源"<<j;
	cout<<endl;
	for (i=0;i<mess;i++) {
		cout<<"进程"<<i;
		for (j=0;j<need;j++) cout<<setw(4)<<ALLOCATION[i][j]<<"\t";
		cout<<endl;
	}
	cout<<endl;
}
void changedata(int k) {
	int j;
	for (j=0;j<need;j++)
	{
		AVAILABLE[j]=AVAILABLE[j]-Request[j];
		ALLOCATION[k][j]=ALLOCATION[k][j]+Request[j];
		NEED[k][j]=NEED[k][j]-Request[j];
	}
}
void restoredata(int k) {
	int j;
	for (j=0;j<need;j++)
	{
		AVAILABLE[j]=AVAILABLE[j]+Request[j];
		ALLOCATION[k][j]=ALLOCATION[k][j]-Request[j];
		NEED[k][j]=NEED[k][j]+Request[j];
	}
}
int checkerror(int s) {
	int WORK[M],FINISH[M],temp[M];
	int i,j,p,k=0;
	for(i=0;i<mess;i++) FINISH[i]=FALSE;
	for(j=0;j<need;j++) WORK[j]=AVAILABLE[j];
	i=s;
	i=0;
	cout<<setw(3)<<"进程号"<<setw(8)<<"WORK "<<setw(10)<<"NEED "<<setw(14)<<"Allocation"<<setw(18)<<"Work+Allo "<<setw(3)<<"Finish"<<endl;
	while(i<mess) {
		p=0;
		for (j=0;j<need;j++) if (FINISH[i]==FALSE&&NEED[i][j]<=WORK[j]) p=p+1;
		if (p>=need) {
			cout<<setw(3)<<i<<setw(6);
			for (j=0;j<need;j++) cout<<WORK[j]<<" ";
			cout<<setw(3);
			for (j=0;j<need;j++) cout<<NEED[i][j]<<" ";
			cout<<setw(6);
			for (j=0;j<need;j++) cout<<ALLOCATION[i][j]<<" ";
			for (j=0;j<need;j++) WORK[j]=WORK[j]+ALLOCATION[i][j];
			cout<<setw(8);
			for (j=0;j<need;j++) cout<<WORK[j]<<" ";
			cout<<setw(8)<<" True"<<endl;
			FINISH[i]=TRUE;
			temp[k]=i;
			k++;
			i=0;
			}
		else {
			i++;
		}
	}
	for(i=0;i<mess;i++)
		if(FINISH[i]==FALSE) {
			cout<<endl;
			cout<<"找不到安全序列，系统不安全!!! 本次资源申请不成功!!!"<<endl;
			cout<<endl;
			return 1;
		}
		cout<<endl<<"经安全性检查，系统安全，本次分配成功。"<<endl<<endl;
		cout<<"安全序列为: ";
		for(i=0;i<mess;++i)
			cout<<setw(5)<<"进程"<<temp[i]<<"-->";
		cout<<"完成"<<endl<<endl;
		return 0;
}



