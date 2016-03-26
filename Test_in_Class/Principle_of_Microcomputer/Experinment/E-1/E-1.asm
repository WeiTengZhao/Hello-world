code segment
    assume cs:code
main proc far  
    mov ax, 0d000h  	 ;外扩存储器段地址
    mov es,ax
    mov bx, 0c000h  	 ;外扩存储器偏移地址
    mov cx,100h     	 ;写入外扩存储器的字符个数
    mov dl,40h;      	 ;A的前一个字符的ASCII码
rep1: inc dl             ;生成下一个字符的ASCII码
    mov es:[bx],dl   	 ;写入外扩存储器
    inc bx               ;指向下一个存储单元 
    cmp dl,5ah        	 ;检测当前写入的字母是否为Z
    jnz ss1              ;不是则转ss1,继续写入下一个字母
    mov dl,40h        	 ;已到Z,再从A开始重新写
ss1: loop rep1       	 ;若CX不为0,转rep1,继续写入下一个字母
    mov bx, 0c000h        ;外扩存储器偏移地址
    mov cx,100h      	 ;要显示的字符个数
rep2: mov dl,es:[bx] 	 ;取外扩内存一个字符
    mov ah,02h        	 ;DOS 2号功能
    int 21h              ;调用DOS 2号功能,显示DL中的字符
    inc bx               ;指向下一存储单元
    loop rep2            ;若CX不为0,转rep2继续显示下一个字母
    mov ax,4c00h    	 ;否则程序结束,返回DOS 
    int 21h    
main endp               
code ends
    end main
