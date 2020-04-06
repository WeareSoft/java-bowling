package user;

import java.security.InvalidParameterException;

public class User {

    private String name;

    public User(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidParameterException("User Object required valid name");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
