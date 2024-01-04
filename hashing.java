public class hashing {

}
/*
Retrieving data O(1)

Search Key(24,52,91,
67,48,83)

Hash Table  -  same like an array - not need to scan, we can retrieve data with O(1)

Hash Functions(
k mod 10,
k mod n,
Mid Square,
Folding Method)


k mod 10 (0 to 9)


24 mod 10 = 4

mid square 123  =(2*2)=4

123456

 123
+456

=579

62 - collision

Collision Resolution

Chaining - Open
hashing

Open Addressing -
Closed hashing
(Linear Probing,
Quadratic Probing,
Double Hashing)


Chaining means to create external chain using linked list


Closed hashing means use hash table space first

linear Probing means next available space


quadratic(h+i*i mode n)

30
h(6) = 30 mod 6

0 +1^2 mod 6 =1

0+4 mod 6= 4 th location


Double hashing -(input, resolution)

h1(k) = k mod 11
h2(k) = 8 - k mod 8

h1(k)+h2(k) mod 11







 */
