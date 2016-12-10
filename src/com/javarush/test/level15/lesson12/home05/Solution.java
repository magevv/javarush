package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution() { }

    public Solution(int x, int y) { }

    public Solution (int x) { }

    private Solution(String s) { }

    private Solution(int x, String s) { }

    private Solution (double x) { }

    protected Solution(short s) { }

    protected Solution(int x, int y, float z) { }

    protected Solution (String s, int x) { }

    Solution(short s, int x) { }

    Solution(float z) { }

    Solution (String s, String d, int x) { }
}

