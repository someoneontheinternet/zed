# ZED Programming Language

## Dev Documentation

#### Start
The label start is declared as global. From it, it calls the 'main' function.
The start function:
```assembly
  start:
    call main ; Call the main methods

  exit:
    push dword 1 ; syscall val return 1
    mov eax, 1 ; syscal: sys_exit
    sub esp, 4 ; allign stack pointer
    int 0x80 ; Calling kernal
```
The 'exit' function calls the kernal to stop the program. Otherwise, it will invoke a Segmentation Fault.

#### Variables
```assembly
; Variables
  sub esp, 4 ; Size of the variable
  mov dword [ebp - 4], 0x0 ; Value

  mov eax, [ebp - 4] ; Use var by using ebp - offset
```
#### Arrays
```assembly
; Arrays  
  ; int arr[3]
  sub esp, 8 ; Init arr header
  mov dword [ebp - 4], esp
  mov dword [ebp - 8], 3v

  sub esp, 12 ; Allocating Space for content  

  ; eax - offset from [ebp - 4]
  mov eax, [ebp - 4]

  ; arr[0] = eax - 0
  ; arr[1] = eax - 4
  ; arr[2] = eax = 8

  ; Setting arr[0] to 0x36
  sub eax, 4
  mov dword [eax], 0x36

  ; Setting arr[1] to 0x36
  sub eax, 4
  mov dword [eax], 0x37

  ; Setting arr[2] to 0x36
  sub eax, 4
  mov dword [eax], 0x38

  ; Resetting eax
  mov eax, 0x0

  ; Getting arr[1]
  mov eax, [ebp - 4] ; Getting val of start of arr
  sub eax, 8 ; arr[1] mem addr = (index + 1) * eleSize

  mov eax, [eax]
```
#### Functions
