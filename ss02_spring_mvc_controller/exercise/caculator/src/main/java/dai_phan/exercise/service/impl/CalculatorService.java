package dai_phan.exercise.service.impl;

import dai_phan.exercise.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    private double addition(double first, double second) {
        return first + second;
    }

    private double subtraction(double first, double second) {
        return first - second;
    }

    private double multiplication(double first, double second) {
        return first * second;
    }

    private double division(double first, double second) {
        return first / second;
    }

    @Override
    public String calculate(String first, String second, String calculator) {
        if(first.length()==0||second.length()==0){
            return "vui lòng nhập số";
        }
        try{
            double firstNumber =Double.parseDouble(first);
            double secondNumber =Double.parseDouble(second);
            switch (calculator){
                case "addition":
                    return String.format("%s",addition(firstNumber,secondNumber));
                case "subtraction":
                    return String.format("%s",subtraction(firstNumber,secondNumber));
                case "multiplication":
                    return String.format("%s",multiplication(firstNumber,secondNumber));
                case "division":
                    if(secondNumber==0){
                        return "không chia được cho 0";
                    }
                    return String.format("%s",division(firstNumber,secondNumber));
                default:
                    return "không tồn tại phép tính";
            }
        }catch (NumberFormatException e){
            return e.getMessage();
        }
    }
}
