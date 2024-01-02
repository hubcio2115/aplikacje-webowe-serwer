package org.example.server.services;

import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.example.server.domains.user.ChangePasswordRequest;
import org.example.server.domains.user.ChangeUserDetailsRequest;
import org.example.server.domains.user.User;
import org.example.server.domains.user.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.val;

@Service
@RequiredArgsConstructor
public class UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

    val user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

    // check if the two new passwords are the same
    if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
      throw new IllegalStateException("Password are not the same");
    }

    // update the password
    user.setPassword(passwordEncoder.encode(request.getNewPassword()));

    // save the new password
    userRepository.save(user);
  }

  public void changeDetails(ChangeUserDetailsRequest request, Principal connectedUser) {
    val user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

    // update the details
    user.setFirstName(request.firstName());
    user.setLastName(request.lastName());
    user.setEmail(request.email());

    // save the new details
    userRepository.save(user);
  }
}
