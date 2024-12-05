import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        this.view.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double firstNumber;
            double secondNumber;

            try {
                firstNumber = Double.parseDouble(view.getFirstNumber());
                secondNumber = Double.parseDouble(view.getSecondNumber());
                String operator = view.getSelectedOperator();

                switch (operator) {
                    case "+":
                        view.setResult(String.valueOf(model.add(firstNumber, secondNumber)));
                        break;
                    case "-":
                        view.setResult(String.valueOf(model.subtract(firstNumber, secondNumber)));
                        break;
                    case "*":
                        view.setResult(String.valueOf(model.multiply(firstNumber, secondNumber)));
                        break;
                    case "/":
                        view.setResult(String.valueOf(model.divide(firstNumber, secondNumber)));
                        break;

                    default:
                        view.setResult("Unknown operator");
                        break;
                }
            } catch (NumberFormatException ex) {
                view.setResult("Invalid input");
            } catch (ArithmeticException ex) {
                view.setResult(ex.getMessage());
            }
        }
    }
}

