package edu.lemon.generics;

public record Account<T, U>(T id, String email, U sum) {

    @Override
    public String toString() {
        return "Account[" +
                "id=" + id + ", " +
                "email=" + email + ", " +
                "sum=" + sum + ']';
    }
}
