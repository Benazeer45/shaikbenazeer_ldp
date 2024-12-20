package Java_Assignments.Lambdas_Streams.JavaLambdaBasics;

import javax.swing.*;

public class LambdaEventListener {
    public static void main(String[] args) {
        JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JButton b = new JButton("click");
        b.setBounds(80, 100, 70, 30);

        // Lambda expression implementing here.
        b.addActionListener(e -> {
            tf.setText("hello swing");
        });

        JFrame f = new JFrame();
        f.add(tf);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}

