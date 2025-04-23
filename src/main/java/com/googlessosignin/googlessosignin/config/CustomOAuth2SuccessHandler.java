package com.googlessosignin.googlessosignin.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.googlessosignin.googlessosignin.entity.AppUser;
import com.googlessosignin.googlessosignin.repository.AppUserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;


@Component
public class CustomOAuth2SuccessHandler  extends SimpleUrlAuthenticationSuccessHandler{

    private final AppUserRepository userRepository;

    public CustomOAuth2SuccessHandler(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, 
                                        Authentication authentication) throws IOException, ServletException {

                                    OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();

                                    String email = oauthUser.getAttribute("email");
                                    String name = oauthUser.getAttribute("name");

                                    userRepository.findByEmail(email).orElseGet(() -> {
                                            AppUser user = new AppUser();
                                            user.setEmail(email);
                                            user.setName(name);
                                            user.setProvider("google");
                                            System.out.println("Saving new user: " + user);  // Log to check the user details
                                            return userRepository.save(user);

                                    });

                                    super.onAuthenticationSuccess(request, response, authentication);
                                    

    }
 
}
