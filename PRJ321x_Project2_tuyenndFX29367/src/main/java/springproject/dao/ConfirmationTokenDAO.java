package springproject.dao;

import springproject.entity.ConfirmationToken;
import springproject.entity.User;

public interface ConfirmationTokenDAO {
    public ConfirmationToken findByConfirmationToken(String confirmationToken);

    public void saveConfirmationToken(ConfirmationToken confirmationToken);
}
