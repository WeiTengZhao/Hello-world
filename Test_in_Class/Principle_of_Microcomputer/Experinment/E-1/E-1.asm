code segment
    assume cs:code
main proc far  
    mov ax, 0d000h  	 ;�����洢���ε�ַ
    mov es,ax
    mov bx, 0c000h  	 ;�����洢��ƫ�Ƶ�ַ
    mov cx,100h     	 ;д�������洢�����ַ�����
    mov dl,40h;      	 ;A��ǰһ���ַ���ASCII��
rep1: inc dl             ;������һ���ַ���ASCII��
    mov es:[bx],dl   	 ;д�������洢��
    inc bx               ;ָ����һ���洢��Ԫ 
    cmp dl,5ah        	 ;��⵱ǰд�����ĸ�Ƿ�ΪZ
    jnz ss1              ;������תss1,����д����һ����ĸ
    mov dl,40h        	 ;�ѵ�Z,�ٴ�A��ʼ����д
ss1: loop rep1       	 ;��CX��Ϊ0,תrep1,����д����һ����ĸ
    mov bx, 0c000h        ;�����洢��ƫ�Ƶ�ַ
    mov cx,100h      	 ;Ҫ��ʾ���ַ�����
rep2: mov dl,es:[bx] 	 ;ȡ�����ڴ�һ���ַ�
    mov ah,02h        	 ;DOS 2�Ź���
    int 21h              ;����DOS 2�Ź���,��ʾDL�е��ַ�
    inc bx               ;ָ����һ�洢��Ԫ
    loop rep2            ;��CX��Ϊ0,תrep2������ʾ��һ����ĸ
    mov ax,4c00h    	 ;����������,����DOS 
    int 21h    
main endp               
code ends
    end main
