global start
section .text

start:
  call main ; calls main Function

exit:
  push dword 1
  mov eax, 1
  sub esp, 4
  int 0x80 ; Exiting Program

section .data

section .bss
