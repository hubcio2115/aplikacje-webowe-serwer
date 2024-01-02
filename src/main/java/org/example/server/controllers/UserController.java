package org.example.server.controllers;

import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.example.server.domains.user.ChangePasswordRequest;
import org.example.server.domains.user.ChangeUserDetailsRequest;
import org.example.server.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PatchMapping("password")
  public ResponseEntity<?> changePassword(
      @RequestBody ChangePasswordRequest request, Principal connectedUser) {
    userService.changePassword(request, connectedUser);

    return ResponseEntity.ok().build();
  }

  @PatchMapping("details")
  public ResponseEntity<?> changeDetails(@RequestBody ChangeUserDetailsRequest request, Principal connectedUser) {
    userService.changeDetails(request, connectedUser);

    return ResponseEntity.ok().build();
  }
}
