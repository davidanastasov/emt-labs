package com.davidanastasov.emtlabproject.model.exceptions;

public class BookNotInWishlistException extends RuntimeException {

  public BookNotInWishlistException() {
    super("That book is not in the wishlist");
  }
}
