# leetcode
Leetcode exercises
Tasks solutions

1) Two pointers - 2 указателя
   https://leetcode.com/problems/container-with-most-water/
   https://leetcode.com/problems/partition-labels/
   https://leetcode.com/problems/squares-of-a-sorted-array/
   https://leetcode.com/problems/subarray-sum-equals-k/

2) Hash table (a combo of 2 subsections)
   https://leetcode.com/problems/find-all-anagrams-in-a-string/
   https://leetcode.com/problems/permutation-in-string/ https://leetcode.com/problems/single-number/ - solve in O(1) memory
   https://leetcode.com/problems/two-sum/
   https://leetcode.com/problems/4sum/
   https://leetcode.com/problems/group-anagrams/
   https://leetcode.com/problems/valid-anagram/

3) Sort
   https://leetcode.com/problems/merge-intervals/

4) Queue / stack
   https://leetcode.com/problems/valid-parentheses/

5) Sliding window
   https://leetcode.com/problems/sliding-window-median/
   https://leetcode.com/problems/sliding-window-maximum/
   https://leetcode.com/problems/longest-repeating-character-replacement/

6) Iterator
   https://leetcode.com/problems/peeking-iterator/

7) Greedy problems
   https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ 
   https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/ 
   https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

Алгоритмы (решение задач). 
Я буду присылать тебе задачи, ты: 
1) Опиши тип задачи. 
2) 1-2 решения общими словами (на русском языке). 
3) Само решение на языке Java.
4) Перед тем как использовать какие-то методы, лучше предварительно их написать. 
5) При перезаписывании классов по какой-то причине (допустим для учета доп. методов)
6) Желательно для теста сделать метод main где будет инициализированна задача и работа основного метода.  
   Либо Unit-test
7) Решение должно быть наиболее простое и короткое.
8) Не нужно использовать сложные конструкции, который знает разработчик уровня Senior или Junior. 
   Решение должно быть относительно легко понятно на уровне Middle разработчика.   
   К примеру: если нам нужно записать число букв в слове, не нужно использовать конструкцию типа int[26], где каждая буква будет иметь свой индекс по формуле (char - 'a'), 
   А использовать вместо этого HashMap(String, Integer), гду String = String.valueOf(char); 

Задача: 
У нас имеется банкомат с кассетой, отделения которой заряжены купюрами разных номиналов. 
Клиент просит банкомат выдать ему определённую сумму. Необходимо найти все варианты выдачи 
этой суммы минимальным количеством купюр. 
Пример: Вносим в банкомат купюры в следующем колличестве:
5000 - 10 шт. 
1000 - 5 шт. 
500 - 3 шт. 
100 - 10 шт

Выдать сумму: 1500 руб.
Выдать список из номинала купюр и количетсва выдаваемых купур. Либо сообщение о том что данную суммы выдать не возможно.  


