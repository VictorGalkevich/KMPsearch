import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String obr = scanner.next();
        char[] base = (obr + "@" + str).toCharArray();
        int[] pi = prefixFunction(base);
        System.out.println();
    }

    static int[] prefixFunction(char[] s) {
        int n = s.length;
        int[] pi = new int[n]; // в i-м элементе (его индекс i-1) количество совпавших символов в начале и конце для подстроки длины i.
        // p[0] = 0 всегда, p[1] = 1, если начинается с двух одинаковых
        for (int i = 1; i < n; ++i) {
            // ищем, какой префикс-суффикс можно расширить
            int j = pi[i - 1]; // длина предыдущего префикса-суффикса, возможно нулевая

            while ((j > 0) && (s[i] != s[j])) { // этот нельзя расширить,
                j = pi[j - 1];   // берем длину меньшего префикса-суффикса
            }

            if (s[i] == s[j]) {
                ++j;// расширяем найденный (возможно пустой) префикс-суффикс
            }

            pi[i] = j;
        }
        return pi;
    }
}