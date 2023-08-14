package org.acme;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import org.acme.rest.json.User;

import io.vertx.mutiny.ext.auth.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/User")
public class UserAdd {
        
    private Set<User> users = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public UserAdd() {
        
        users.add(new User("Dude Bug", "Winter user vacation"));
        users.add(new User("Lady Bug", "Summer user vacation"));
        users.add(new User("Link from the past", "Spring user vacation"));
        users.add(new User("Kratos", "Spring user vacation"));

    }

    @GET
    public Set<User> list() {
        return users;
    }

    @POST
    public Set<User> add(User user) {
        users.add(user);
        return users;
    }

    @DELETE
    public Set<User> delete(User user) {
        users.removeIf(existinguser -> existinguser.name.contentEquals(user.name));
        return users;
    }
    
}