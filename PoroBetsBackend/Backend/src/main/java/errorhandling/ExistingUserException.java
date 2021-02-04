/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandling;

/**
 *
 * @author Emil Svensmark
 */
public class ExistingUserException extends Exception {

    public ExistingUserException(String message) {
        super(message);
    }

    public ExistingUserException() {
        super("Username already existing");
    }
}
