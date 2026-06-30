`List`, `Set`, and `Map` are the three most important collection types in Java. They serve different purposes.

| Feature          | List      | Set                       | Map                       |
| ---------------- | --------- | ------------------------- | ------------------------- |
| Stores           | Elements  | Unique elements           | Key-Value pairs           |
| Duplicate values | ✅ Allowed | ❌ Not allowed             | Keys ❌, Values ✅          |
| Order            | Preserved | Depends on implementation | Depends on implementation |
| Index access     | ✅ Yes     | ❌ No                      | ❌ No (use key)            |
| Interface        | `List`    | `Set`                     | `Map`                     |

---

# 1. List

A `List` is an **ordered collection**.

### Properties

* Allows duplicates
* Maintains insertion order
* Can access using index

```java
List<String> list = new ArrayList<>();

list.add("Apple");
list.add("Banana");
list.add("Apple");

System.out.println(list);
// [Apple, Banana, Apple]

System.out.println(list.get(1));
// Banana
```

### Common Implementations

```java
ArrayList
LinkedList
Vector
Stack
```

### Common Methods

```java
add()
get(index)
set(index, value)
remove(index)
contains()
size()
clear()
```

---

# 2. Set

A `Set` stores **unique elements only**.

### Properties

* No duplicates
* No index
* Faster searching

```java
Set<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(10);

System.out.println(set);
// [10, 20]
```

Duplicate `10` is ignored.

---

## Implementations

### HashSet

* Fastest
* No ordering

```java
Set<Integer> set = new HashSet<>();
```

Example output

```
30 10 20
```

---

### LinkedHashSet

Maintains insertion order.

```java
Set<Integer> set = new LinkedHashSet<>();
```

Output

```
10 20 30
```

---

### TreeSet

Keeps elements sorted.

```java
Set<Integer> set = new TreeSet<>();
```

Output

```
10 20 30
```

---

### Useful Methods

```java
add()
remove()
contains()
size()
clear()
```

---

# 3. Map

A `Map` stores **key-value pairs**.

```
Roll No -> Name

101 -> Rahul
102 -> Aman
103 -> Priya
```

Keys are unique.

Values may repeat.

```java
Map<Integer, String> map = new HashMap<>();

map.put(1, "Apple");
map.put(2, "Banana");
map.put(1, "Orange");

System.out.println(map);
```

Output

```
{1=Orange, 2=Banana}
```

The value for key `1` is replaced.

---

## Implementations

### HashMap

* Fast
* No order

```java
Map<Integer, String> map = new HashMap<>();
```

---

### LinkedHashMap

Maintains insertion order.

```java
Map<Integer, String> map = new LinkedHashMap<>();
```

---

### TreeMap

Sorts according to keys.

```java
Map<Integer, String> map = new TreeMap<>();
```

---

### Common Methods

```java
put(key, value)
get(key)
remove(key)
containsKey()
containsValue()
keySet()
values()
entrySet()
size()
```

---

# Iterating over a Map

### Using `entrySet()` (most common)

```java
Map<Integer, String> map = new HashMap<>();

map.put(1, "A");
map.put(2, "B");

for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}
```

Output

```
1 A
2 B
```

---

# Which one should you use?

### Need duplicates?

```
Yes
 ↓
List
```

---

### Need unique values?

```
Yes
 ↓
Set
```

---

### Need key-value mapping?

```
Yes
 ↓
Map
```

---

# Time Complexity (Average)

| Operation    | ArrayList | HashSet | HashMap |
| ------------ | --------- | ------- | ------- |
| Add          | O(1)      | O(1)    | O(1)    |
| Search       | O(n)      | O(1)    | O(1)    |
| Remove       | O(n)      | O(1)    | O(1)    |
| Get by index | O(1)      | ❌       | ❌       |
| Get by key   | ❌         | ❌       | O(1)    |

---

# Which implementation to choose?

| Requirement                        | Collection      |
| ---------------------------------- | --------------- |
| Fast indexed access                | `ArrayList`     |
| Frequent insert/delete in middle   | `LinkedList`    |
| Unique elements                    | `HashSet`       |
| Unique elements in insertion order | `LinkedHashSet` |
| Unique elements in sorted order    | `TreeSet`       |
| Fast key-value lookup              | `HashMap`       |
| Key-value in insertion order       | `LinkedHashMap` |
| Key-value sorted by key            | `TreeMap`       |

### Quick memory trick

* **List** → Think **line** of items (ordered, duplicates allowed).
* **Set** → Think **group** of unique items (no duplicates).
* **Map** → Think **dictionary** (every **key** maps to a **value**).
