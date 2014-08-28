Characters count Exercise
====

The goal is to count all the characters and then list them so you can know how many A, B, C... are in the specified file.

Getting Started
===

1. Create a project named `CharsInFile`
2. Create a package `com.webridge.charsinfile`
3. Create a method `public static void displayCharCount(HashMap<Character, Integer> charCount)`
    * The method should display each characters (keys) and the char count (values)
    so as the unicode for the character
4. Create a method `public static HashMap<Character, Integer> countChars(String filePath)`
    * The method should read the file at the specified path and counts its characters
5. Read the file path in the **Main** method and 
Note: An easy way to get the unicode of a char is using `Integer.toString(char)`

Result sample
===

```
Input the path for the file to analyze:
README.md
 (Unicode: 32): 218
((Unicode: 40): 53
)(Unicode: 41): 53
*(Unicode: 42): 6
,(Unicode: 44): 5
-(Unicode: 45): 1
.(Unicode: 46): 13
0(Unicode: 48): 20
1(Unicode: 49): 39
2(Unicode: 50): 23
3(Unicode: 51): 21
4(Unicode: 52): 17
5(Unicode: 53): 20
6(Unicode: 54): 17
7(Unicode: 55): 7
8(Unicode: 56): 11
9(Unicode: 57): 16
:(Unicode: 58): 96
<(Unicode: 60): 2
=(Unicode: 61): 11
>(Unicode: 62): 2
A(Unicode: 65): 3
B(Unicode: 66): 2
C(Unicode: 67): 14
E(Unicode: 69): 2
F(Unicode: 70): 1
G(Unicode: 71): 1
H(Unicode: 72): 2
I(Unicode: 73): 4
M(Unicode: 77): 3
N(Unicode: 78): 1
P(Unicode: 80): 1
R(Unicode: 82): 3
S(Unicode: 83): 3
T(Unicode: 84): 4
U(Unicode: 85): 48
`(Unicode: 96): 17
a(Unicode: 97): 66
b(Unicode: 98): 3
c(Unicode: 99): 83
d(Unicode: 100): 71
e(Unicode: 101): 121
f(Unicode: 102): 10
g(Unicode: 103): 12
h(Unicode: 104): 45
i(Unicode: 105): 81
j(Unicode: 106): 1
k(Unicode: 107): 4
l(Unicode: 108): 20
m(Unicode: 109): 11
n(Unicode: 110): 79
o(Unicode: 111): 79
p(Unicode: 112): 14
r(Unicode: 114): 39
s(Unicode: 115): 33
t(Unicode: 116): 62
u(Unicode: 117): 18
v(Unicode: 118): 2
w(Unicode: 119): 5
x(Unicode: 120): 2
y(Unicode: 121): 8

Process finished with exit code 0
```