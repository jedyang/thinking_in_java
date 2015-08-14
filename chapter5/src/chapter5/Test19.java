package chapter5;

public class Test19 {

    public void receive(String... args)
    {
        for(String s : args)
        {
            System.out.println(s);
        }
    }

    public static void main(String[] args)
    {
        new Test19().receive("a","b","c");
        new Test19().receive(new String[]{"d","e","f"});
    }

}
