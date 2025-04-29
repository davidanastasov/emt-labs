package com.davidanastasov.emtlabproject.model.exceptions;

public class EmptyWishlistException extends RuntimeException {

  public EmptyWishlistException() {
    super("The wishlist is already empty");
  }
}
