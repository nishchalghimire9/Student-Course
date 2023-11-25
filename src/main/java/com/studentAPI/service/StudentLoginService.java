package com.studentAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface StudentLoginService {
    public boolean validateCredentials (String username, String password);

}
