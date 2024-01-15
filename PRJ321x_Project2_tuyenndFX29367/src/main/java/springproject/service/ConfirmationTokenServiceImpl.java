package springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springproject.dao.ConfirmationTokenDAO;
import springproject.entity.ConfirmationToken;
@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    @Autowired
    private ConfirmationTokenDAO confirmationTokenDAO;

    @Override
    @Transactional
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        return confirmationTokenDAO.findByConfirmationToken(confirmationToken);
    }

    @Override
    @Transactional
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenDAO.saveConfirmationToken(confirmationToken);
    }
}
