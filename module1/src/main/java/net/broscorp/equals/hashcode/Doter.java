package net.broscorp.equals.hashcode;

import java.math.BigDecimal;
import org.jetbrains.annotations.NotNull;

public class Doter {

  private Integer ranked;
  private BigDecimal toxicity;
  private String nickname;

  /**
   * This object represents general dota 2 player.
   * Integer ranked = not null positive field BigDecimal toxicity = not null decimal field in range
   * [0-1] String nickname = any not null string
   */
  public Doter(@NotNull Integer ranked, @NotNull BigDecimal toxicity, @NotNull String nickname) {
    this.ranked = ranked;
    if (toxicity.compareTo(BigDecimal.valueOf(0.0d)) >= 0
        && toxicity.compareTo(BigDecimal.valueOf(1.0d)) <= 1) {
      this.toxicity = toxicity;
    } else {
      this.toxicity = BigDecimal.valueOf(0);
    }
    this.nickname = nickname;
  }

  public Integer getRanked() {
    return ranked;
  }

  public void setRanked(Integer ranked) {
    this.ranked = ranked;
  }

  public BigDecimal getToxicity() {
    return toxicity;
  }

  /**
   * Must be in range [0.0d - 1.0d]
   */
  public void setToxicity(@NotNull BigDecimal toxicity) {
    if (toxicity.compareTo(BigDecimal.valueOf(0.0d)) >= 0
        && toxicity.compareTo(BigDecimal.valueOf(1.0d)) <= 0) {
      this.toxicity = toxicity;
    } else {
      this.toxicity = BigDecimal.valueOf(0);
    }
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Doter)) {
      return false;
    }
    Doter doter = (Doter) o;
    return ranked.equals(doter.ranked) && toxicity.equals(doter.toxicity) && nickname
        .equals(doter.nickname);
  }

  @Override
  public int hashCode() {
    return
        (ranked % 10)
            + (toxicity.multiply(BigDecimal.valueOf(100.0)).intValue() % 10)
            + nickname.chars().sum() % 10;
  }

  @Override
  public String toString() {
    return "Doter{"
        + "ranked=" + ranked
        + ", toxicity=" + toxicity
        + ", nickname='" + nickname + '\''
        + '}';
  }
}