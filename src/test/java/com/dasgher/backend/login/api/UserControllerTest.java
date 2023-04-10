package com.dasgher.backend.login.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.assertj.core.api.Assertions.assertThat;

import com.dasgher.backend.login.model.LoginInformation;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    
    @InjectMocks
    UserController userController;

    @Test
    void testAuthenticateMethod(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var loginInfo = new LoginInformation("kokesh","fupash");
        var result = userController.authenticate(loginInfo);
        assertThat(result.username()).isEqualTo(loginInfo.username());
        assertThat(result.password()).isEqualTo(loginInfo.password());
    }
}