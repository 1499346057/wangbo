package lab6.wangbo.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * @author WangBo
 * @date 26.05.2019
 */
@Provider
public class NonKeySpecifiedExceptionMapper implements ExceptionMapper<NonKeySpecifiedException> {

    @Override
    public Response toResponse(NonKeySpecifiedException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
