package linkedlists;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
Patrick Gallagher 
Homework #5_1
03/36/2023
This program lets the user enter a string that contains multiple words
from a graphical user interface and displays them in a text area. */
public class LinkedLists extends JFrame implements ActionListener {
    
    private JTextArea textArea;
    private JTextField inputField;
    private JButton sortButton;
    private JButton shuffleButton;
    private JButton reverseButton;
    private LinkedList<String> wordsList;

    public LinkedLists() {
        
        super("Word List");

        wordsList = new LinkedList<String>();

        inputField = new JTextField(10);
        inputField.addActionListener(this);

        textArea = new JTextArea(20, 20);
        textArea.setEditable(false);

        sortButton = new JButton("Sort");
        sortButton.addActionListener(this);

        shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(this);

        reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(this);
           
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Enter a string: "));
        panel1.add(inputField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(panel1, BorderLayout.NORTH);
        panel2.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel3 = new JPanel();
        panel3.add(sortButton);
        panel3.add(shuffleButton);
        panel3.add(reverseButton);

        getContentPane().add(panel2, BorderLayout.CENTER);
        getContentPane().add(panel3, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
        /* I had help with this next block of code from my roommate. */
        // I struggle with eventlisters and searching syntax.
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Sort")) {
            Collections.sort(wordsList);
        } else if (command.equals("Shuffle")) {
            Collections.shuffle(wordsList);
        } else if (command.equals("Reverse")) {
            Collections.reverse(wordsList);
        } else {
            String input = inputField.getText().toLowerCase();
            String[] words = input.split("\\W+");
            for (String word : words) {
                if (!wordsList.contains(word)) {
                    wordsList.add(word);
                }
            }
        }

        updateTextArea();
    }
        // Same thing above here.
    private void updateTextArea() {
        textArea.setText("");
        for (String word : wordsList) {
            textArea.append(word + "\n");
        }
    }

    public static void main(String[] args) {
        new LinkedLists();
    }
}
