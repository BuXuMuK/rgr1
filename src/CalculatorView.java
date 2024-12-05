import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView {
    private final JTextField firstNumberField;
    private final JTextField secondNumberField;
    private final JTextField resultField;
    private final JButton calculateButton;
    private final JComboBox<String> operatorComboBox;

    public CalculatorView() {
        JFrame frame = new JFrame("Calculator");
        firstNumberField = new JTextField(10);
        secondNumberField = new JTextField(10);
        resultField = new JTextField(10);
        calculateButton = new JButton("=");

        String[] operators = {"+", "-", "*", "/"};
        operatorComboBox = new JComboBox<>(operators);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(firstNumberField);
        panel.add(operatorComboBox);
        panel.add(secondNumberField);
        panel.add(calculateButton);
        panel.add(resultField);

        frame.getContentPane().add(panel);
        frame.setSize(400, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public String getFirstNumber() {
        return firstNumberField.getText();
    }

    public String getSecondNumber() {
        return secondNumberField.getText();
    }

    public String getSelectedOperator() {
        return (String) operatorComboBox.getSelectedItem();
    }

    public void setResult(String result) {
        resultField.setText(result);
    }

    public void addCalculateListener(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }
}
