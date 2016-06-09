/*
 * Banker.cpp
 *
 *  Created on: 2016��6��8��
 *      Author: Administrator
 */
#include<iomanip>
#include<iostream>

using namespace std;
#define M 100 //�ܽ�����
#define N 50 //�ܵ���Դ����
#define FALSE 0
#define TRUE 1
//M �����̶�N ����Դ�����Դ������
int MAX[M][N];//={{5,5,9},{5,3,6},{4,0,11},{4,2,5},{4,2,4}};M=4,N=
//ϵͳ������Դ��
int AVAILABLE[N];//={2,3,3};
//M �������Ѿ��õ�N ����Դ����Դ��
int ALLOCATION[M][N];//={{2,1,2},{4,0,2},{4,0,5},{2,0,4},{3,1,4}};
//M �����̻���ҪN ����Դ����Դ��
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

	cout<<"��������������Դ�Ľ�����:";
	cin>>mess;
	cout<<"��������������Դ��������:";
	cin>>need;
//============================================�����Դ��=============================
	for (int a = 0;a < mess ;a++) {
		for (int b = 0; b < need;b++) {
			cout << "��������Դ��MAX:";
			cin >> MAX[a][b];
		}
	}
//===========================================������Դ��===============================
	for (int a = 0;a < mess ;a++) {
		for (int b = 0; b < need;b++) {
			cout<<"�������Ѿ�ӵ�е���Դ��Ŀ ALLOCATION:";
			cin >> ALLOCATION[a][b];
			NEED[a][b] = MAX[a][b] - ALLOCATION[a][b];
			if ( NEED[a][b] < 0) {
				cout << "�����ALLOCATION��ֵ����;";
					b--;
					continue;
			}
		}
	}
//========================================������Դ��Ŀ=============================
	for (int a = 0;a < mess ;a++) {
		cout<<"������������Դ��ĿAVAILABLE:";
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
		cout<<"��������������Դ�Ľ��̺�:";
		cin>>i;
		while(i < 0 ||i >= mess) {
			cout<<"����Ľ��̺Ų����ڣ���������!"<<endl;
			cin>>i;
		}
		cout<<"���������"<<i<<"�������Դ��"<<endl;
		for (j=0;j<need;j++) {
			cout<<" ��Դ"<<j<<": ";
			cin>>Request[j];
			if(Request[j]>NEED[i][j]) {
				cout<<" ����"<<i<<"�������Դ�����ڽ���"<<i<<"����Ҫ"<<j<<"����Դ����Դ��!";
				cout<<" ���벻���� ����! ������ѡ��!"<<endl<<" ��Y/N �����س������......"<<endl;
				cin>>zt;
				flag='N';
				break;
			}
			else {
				if(Request[j]>AVAILABLE[j]) {
					cout<<" ����"<<i<<"�������Դ������ϵͳ����"<<j<<"����Դ����Դ��!";
					cout<<"���벻�����øý��̵ȴ�!��������ѡ��!"<<endl<<"��Y/N �����س������......"<<endl;
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
		cout<<"�Ƿ�������м��㷨��ʾ,��'Y'��'y'������,��'N'��'n'���˳���ʾ: ";
		cin>>flag;
	}
	return 0;
}
void showdata() {
	int i,j;
	cout<<"ϵͳ���õ���Դ��ΪAVAILABLE:"<<endl<<endl;
	for (j=0;j<need;j++) cout<<"��Դ"<<j<<"\t";
	cout<<endl;
	for (j=0;j<need;j++) cout<<" "<<AVAILABLE[j]<<"\t";
	cout<<endl<<endl;
	cout<<"�����̻���Ҫ����Դ��NEED:"<<endl<<endl;
	for (j=0;j<need;j++)cout<<"\t ��Դ"<<j;
	cout<<endl;
	for (i=0;i<mess;i++){
		cout<<"����"<<i<<"\t";
		for (j=0;j<need;j++)cout<<setw(3)<<NEED[i][j]<<"\t";
		cout<<endl;
	}
	cout<<endl;
	cout<<"�������Ѿ��õ�����Դ��ALLOCATION:"<<endl<<endl;
	for (j=0;j<need;j++) cout<<"\t ��Դ"<<j;
	cout<<endl;
	for (i=0;i<mess;i++) {
		cout<<"����"<<i;
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
	cout<<setw(3)<<"���̺�"<<setw(8)<<"WORK "<<setw(10)<<"NEED "<<setw(14)<<"Allocation"<<setw(18)<<"Work+Allo "<<setw(3)<<"Finish"<<endl;
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
			cout<<"�Ҳ�����ȫ���У�ϵͳ����ȫ!!! ������Դ���벻�ɹ�!!!"<<endl;
			cout<<endl;
			return 1;
		}
		cout<<endl<<"����ȫ�Լ�飬ϵͳ��ȫ�����η���ɹ���"<<endl<<endl;
		cout<<"��ȫ����Ϊ: ";
		for(i=0;i<mess;++i)
			cout<<setw(5)<<"����"<<temp[i]<<"-->";
		cout<<"���"<<endl<<endl;
		return 0;
}



