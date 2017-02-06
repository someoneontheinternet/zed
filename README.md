# ZED Programming Language

### Dev Documentation

#### Variables
; Variables <br>
  sub esp, 4 ; Size of the variable <br>
  mov dword [ebp - 4], 0x0 ; Value <br>
  <br>
  mov eax, [ebp - 4] ; Use var by using ebp - offset <br>

#### Arrays
; Arrays  <br>
  ; int arr[3] <br>
  sub esp, 8 ; Init arr header <br>
  mov dword [ebp - 4], esp <br>
  mov dword [ebp - 8], 3v
 <br>
  sub esp, 12 ; Allocating Space for content  <br>
 <br>
  ; eax - offset from [ebp - 4] <br>
  mov eax, [ebp - 4]
   <br>
  ; arr[0] = eax - 0 <br>
  ; arr[1] = eax - 4 <br>
  ; arr[2] = eax = 8 <br>
   <br>
  ; Setting arr[0] to 0x36 <br>
  sub eax, 4 <br>
  mov dword [eax], 0x36 <br>
 <br>
  ; Setting arr[1] to 0x36 <br>
  sub eax, 4 <br>
  mov dword [eax], 0x37 <br>
 <br>
  ; Setting arr[2] to 0x36 <br>
  sub eax, 4 <br>
  mov dword [eax], 0x38 <br>
 <br>
  ; Resetting eax <br>
  mov eax, 0x0 <br>

  ; Getting arr[1] <br>
  mov eax, [ebp - 4] ; Getting val of start of arr <br>
  sub eax, 8 ; arr[1] mem addr = (index + 1) * eleSize <br>
 <br>
  mov eax, [eax] <br>
