package org.example.server.domains.token;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.*;
import org.example.server.domains.user.User;
import org.hibernate.proxy.HibernateProxy;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {

  @Id @GeneratedValue public Integer id;

  @Column(unique = true)
  private String tokenCode;

  @Builder.Default
  @Enumerated(EnumType.STRING)
  private TokenType tokenType = TokenType.BEARER;

  private boolean revoked;

  private boolean expired;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @ToString.Exclude
  private User user;

  @Override
  public final boolean equals(Object o) {
    if (Objects.isNull(o)) {
      return false;
    }
    if (this == o) {
      return true;
    }
    Class<?> oEffectiveClass =
        o instanceof HibernateProxy hibernateProxy
            ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
            : o.getClass();
    Class<?> thisEffectiveClass =
        this instanceof HibernateProxy hibernateProxy
            ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
            : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) {
      return false;
    }
    Token token = (Token) o;
    return Objects.nonNull(getId()) && Objects.equals(getId(), token.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy hibernateProxy
        ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
        : getClass().hashCode();
  }
}
