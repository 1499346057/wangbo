package lab6.wangbo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author WangBo
 * @date 26.05.2019
 */
@Path("/auth")
@Produces({MediaType.APPLICATION_JSON})
public class AuthenticationResource {

    @GET
    public String authSuccessful()
    {
        // Fail authentication will be rejected by filter
        return "Authorization is successful";
    }

}
