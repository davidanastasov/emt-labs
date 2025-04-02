package com.davidanastasov.emtlabproject.model.exceptions;

public class BookAlreadyInWishlistException extends RuntimeException {

  public BookAlreadyInWishlistException() {
    super("That book is already in the wishlist");
  }
}
