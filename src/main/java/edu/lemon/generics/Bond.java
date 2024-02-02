package edu.lemon.generics;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Bond(String owner, Long quantity, BigDecimal price, LocalDateTime dateTime) {}
