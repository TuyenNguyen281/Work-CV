package springproject.service;

import springproject.entity.ConfirmationToken;

public interface ConfirmationTokenService {
    public ConfirmationToken findByConfirmationToken(String confirmationToken);

    public void saveConfirmationToken(ConfirmationToken confirmationToken);

}
