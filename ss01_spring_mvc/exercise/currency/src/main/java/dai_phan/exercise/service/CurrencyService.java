package dai_phan.exercise.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService{


    @Override
    public double convertUsdToVnd(double usd) {

        return usd*23000;
    }
}
