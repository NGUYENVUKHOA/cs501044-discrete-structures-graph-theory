package edu.tdt.hamilton;

/**
 * Created by Phuc Duong on 8/10/2016.
 * huuphucduong@gmail.com
 */
public class Test {

    public static void main(String[] args)
    {
        Hamilton h = new Hamilton("resources/test_euler_1.txt");
        System.out.println(h.getHamiltonCircuit(0).toString());
    }
}
