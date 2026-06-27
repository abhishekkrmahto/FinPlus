package services;

import models.FraudAlert;
import repository.FraudAlertRepository;

public class FraudService {
    FraudAlertRepository fraudAlertRepository = new FraudAlertRepository();

    public FraudAlert getFraudDetails(long accountId) {

        return fraudAlertRepository.getFraudData(accountId);

    }

    public void updateFraud(long senderAccountNumber, int newRiskLevel) {
        fraudAlertRepository.updateFraud(senderAccountNumber, newRiskLevel);
    }
}
