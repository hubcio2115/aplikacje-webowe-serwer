package org.example.server.domains.token;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  @Query(
      value =
          """
      SELECT token FROM Token token INNER JOIN User user\s
      ON token.user.id = user.id\s
      WHERE user.id = :id AND (token.expired = false AND token.revoked = false)\s
      """)
  List<Token> findAllValidTokenByUser(Integer id);

  Optional<Token> findByTokenCode(String token);
}
