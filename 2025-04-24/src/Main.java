//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] arr = {"Apple", "Banana", "Orange"};
        for(String i : arr)
            System.out.println(i);

        String str = "abishek";
        int in = 5;
        System.out.println(str + in);
        System.out.println(in + str);

        StringBuilder sb = new StringBuilder();
        StringBuffer sf  = new StringBuffer(str);

        sb.append(sf);
        sb.append(" prabhu");
        System.out.println(sb);

        int n = 200;
        Integer n1 = 200;
        Integer n2 = 200;
        System.out.println(n==200);
        System.out.println(n1 == n2);
        System.out.println(n1.equals(200));

    }
}