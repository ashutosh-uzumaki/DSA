# 📖 Backtracking & Recursion - Active Revision Sheet

> *Focus on patterns, not memorization. Trace your own GitHub code against this sheet.*

---

## 🔹 Group 2: Subsets & Combinations

| Problem | Core Structure | Key Delta | Complexity |
|---------|----------------|-----------|------------|
| **Subsets** | Record at top → `for i=start` → `helper(i+1)` → `remove()` | None | `O(N·2^N)` |
| **Subsets II** | Same + `Arrays.sort()` + `if(i>start && nums[i]==nums[i-1]) continue` | Skip sibling duplicates only | `O(N·2^N)` |
| **Comb Sum I** | Record at leaf → `helper(i, sum+val)` → `if(sum>target) return` | Reuse via `i` (not `i+1`) | `O(N^(T/M))` |
| **Comb Sum II** | Sort + skip dupes + `helper(i+1)` + `break` if `sum+val>target` | No reuse + loop-level pruning | `O(2^N)` |
| **Comb Sum III** | Loop `1..9` → base `path.size()==k` → `helper(i+1)` | Fixed size, range constraint | `O(C(9,k)·k)` |
| **Subset Sums/XOR** | Drop `path`, pass `curr`, record at every call | Use class field or return value (primitives don't pass by ref) | `O(2^N)` |

---

## 🔹 Group 3: Permutations & Arrangements

| Problem | Core Structure | Key Delta | Complexity |
|---------|----------------|-----------|------------|
| **Permutations I** | Loop `0..n-1` → `if(used[i]) continue` → mark → recurse → unmark → base `size==n` | `used[]` tracks inclusion state | `O(N!·N)` |
| **Permutations II** | Sort + `if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue` | Skip only if prev identical was backtracked | `O(N!·N)` |
| **Letter Combinations** | `map[digit]` → loop chars → `path.append/deleteCharAt` → base `idx==len` | Cartesian product, no `used[]` | `O(4^N·N)` |

---

## 🔹 Group 4: Partitioning & Grid DFS

| Problem | Core Structure | Key Delta | Complexity |
|---------|----------------|-----------|------------|
| **Generate Parentheses** | `if(open<n) add '('` → `if(close<open) add ')'` → base `len==2n` | Constraint-driven branching | `O(4^N/√N)` |
| **Palindrome Partitioning** | Loop `i=start` → `sub = s.substring(start,i+1)` → `if(isPal)` recurse `i+1` | Cut-and-validate | `O(N·2^N)` |
| **Word Search** | 4-direction DFS → mark `visited` → early `return true` → unmark | In-place or `boolean[][]` restore | `O(M·N·4^L)` |

---

## 🧠 Universal Decision Checklist (Trace Before You Code)
1. **Reuse allowed?** → `helper(i)` (yes) vs `helper(i+1)` (no)
2. **Duplicates in input?** → Sort + `if(i>start && nums[i]==nums[i-1])`
3. **Record where?** → Top of method (subsets) vs Leaf/base case (fixed size/sum/IP)
4. **Grid/2D?** → Directions array, mark/unmark, early exit on match
5. **String/Partition?** → Loop cut points, validate segment, backtrack `StringBuilder.length`

---

## 🔍 How to Use This for Active Recall
1. Open your GitHub repo for **one problem per group**.
2. **Read your code silently** → then close the tab.
3. **Out loud**, explain:
    - Where you `choose`, `explore`, and `unchoose`
    - What your base case checks
    - Why your loop bounds/skip logic work
4. If you hesitate >10 seconds → that's your revision target.

---
