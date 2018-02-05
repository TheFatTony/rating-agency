package com.chieftain.agency.rest.resources;

import com.chieftain.agency.entity.AccessToken;
import com.chieftain.agency.entity.User;
import com.chieftain.agency.service.UserService;
import com.chieftain.agency.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/user")
public class UserResource
{
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        UserDetails userDetails = (UserDetails) principal;

        return new UserDto(userDetails.getUsername(), this.createRoleMap(userDetails));
    }


    @Path("authenticate")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public AccessToken authenticate(@FormParam("username") String username, @FormParam("password") String password)
    {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof User)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        return this.userService.createAccessToken((User) principal);
    }

    private Map<String, Boolean> createRoleMap(UserDetails userDetails)
    {
        Map<String, Boolean> roles = new HashMap<>();
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            roles.put(authority.getAuthority(), Boolean.TRUE);
        }

        return roles;
    }
}
