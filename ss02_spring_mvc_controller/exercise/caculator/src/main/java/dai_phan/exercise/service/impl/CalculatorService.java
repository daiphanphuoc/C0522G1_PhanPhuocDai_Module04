package dai_phan.exercise.service.impl;

import dai_phan.exercise.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double addition(double first, double second) {
        return first + second;
    }

    @Override
    public double subtraction(double first, double second) {
        return first - second;
    }

    @Override
    public double multiplication(double first, double second) {
        return first * second;
    }

    @Override
    public double division(double first, double second) {
        return first / second;
    }
}
