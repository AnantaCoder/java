# XOR (`^`) Cheat Sheet for Java & LeetCode

Keep this as a one-page revision sheet.

---

# 1. XOR Truth Table

| A | B | A ^ B |
| - | - | ----- |
| 0 | 0 | 0     |
| 0 | 1 | 1     |
| 1 | 0 | 1     |
| 1 | 1 | 0     |

**Rule:** Same bits → `0`, Different bits → `1`

---

# 2. Most Important XOR Identities ⭐⭐⭐⭐⭐

```java
a ^ a = 0
```

```java
a ^ 0 = a
```

```java
a ^ b = b ^ a
```

(Commutative)

```java
(a ^ b) ^ c = a ^ (b ^ c)
```

(Associative)

```java
a ^ b ^ a = b
```

Duplicates always cancel.

---

# 3. Binary Example

```
5 = 101
3 = 011
---------
    110 = 6
```

```
7 = 111
7 = 111
---------
    000 = 0
```

---

# 4. Java Syntax

```java
int ans = a ^ b;
```

Compound assignment

```java
ans ^= num;
```

Equivalent to

```java
ans = ans ^ num;
```

---

# 5. Single Number Pattern ⭐⭐⭐⭐⭐

Array

```
2 1 4 1 2
```

```
2 ^ 1 ^ 4 ^ 1 ^ 2

↓

2 cancels
1 cancels

↓

4
```

Code

```java
int ans = 0;

for (int num : nums) {
    ans ^= num;
}

return ans;
```

Used in:

*

---

# 6. Missing Number Pattern ⭐⭐⭐⭐

```
0 1 2 4
```

Missing = 3

```
0^1^2^3^4

^

0^1^2^4

↓

3
```

---

# 7. Find the ith Bit

```java
int bit = (n >> i) & 1;
```

Example

```java
int n = 13;

int bit = (n >> 2) & 1;
```

Returns

```
1
```

---

# 8. Check if ith Bit is Set

```java
if ((n & (1 << i)) != 0)
```

Example

```java
if ((13 & (1 << 3)) != 0)
```

Returns

```
true
```

---

# 9. Set ith Bit

```java
n |= (1 << i);
```

Example

```
1001

↓

1101
```

---

# 10. Clear ith Bit

```java
n &= ~(1 << i);
```

---

# 11. Toggle ith Bit ⭐⭐⭐

```java
n ^= (1 << i);
```

Example

```
1010

↓

1000
```

---

# 12. Rightmost Set Bit ⭐⭐⭐⭐⭐

```java
int rightMost = xor & (-xor);
```

Used in:

*

---

# 13. Prefix XOR

Exactly like Prefix Sum.

```
arr = 5 2 7 3
```

Prefix XOR

```
5

5^2 = 7

7^7 = 0

0^3 = 3
```

Range XOR

```
L...R

=

prefix[R]

^

prefix[L-1]
```

Used in:

*

---

# 14. XOR Swap (Interview Trick)

```java
a ^= b;
b ^= a;
a ^= b;
```

> In production code, prefer using a temporary variable because it's clearer.

---

# 15. Common Bit Operations

| Operation            | Code      |
| -------------------- | --------- |
| AND                  | `a & b`   |
| OR                   | `a \| b`  |
| XOR                  | `a ^ b`   |
| NOT                  | `~a`      |
| Left Shift           | `a << k`  |
| Right Shift          | `a >> k`  |
| Unsigned Right Shift | `a >>> k` |

---

# 16. XOR Patterns in Interviews

| Pattern              | Problem |
| -------------------- | ------- |
| Single unique number |         |
| Missing number       |         |
| Two unique numbers   |         |
| Prefix XOR           |         |
| Maximum XOR          |         |

---

# 17. Time Complexity

| Operation          | Complexity |
| ------------------ | ---------- |
| XOR (`^`)          | **O(1)**   |
| AND (`&`)          | **O(1)**   |
| OR (`\|`)          | **O(1)**   |
| Shift (`<<`, `>>`) | **O(1)**   |

---

# 18. The Five Rules to Memorize

```
1. a ^ a = 0
```

```
2. a ^ 0 = a
```

```
3. XOR is commutative
```

```
4. XOR is associative
```

```
5. Duplicates always cancel
```

---

## Placement Tip

For most placement interviews, if you master these five XOR patterns—

* Unique element
* Missing number
* Prefix XOR
* Rightmost set bit (`xor & -xor`)
* Bit masking (`1 << i`)

—you'll be able to solve the majority of XOR-based questions without converting large numbers to binary manually. That's how experienced candidates approach these problems.
