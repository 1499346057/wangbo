package lab3.wangbo.exception;


import javax.xml.ws.WebFault;


/**
 * @author WangBo
 * @date 23.05.2019
 */
@WebFault(faultBean = "lab3.wangbo.exception.EmptyIdentifierExceptionBean")
public class EmptyIdentifierException extends Exception {
    private final EmptyIdentifierExceptionBean fault;

    public EmptyIdentifierException(String message, EmptyIdentifierExceptionBean fault) {
        super(message);
        this.fault = fault;
    }

    public EmptyIdentifierException(String message, EmptyIdentifierExceptionBean fault, Throwable cause){
        super(message, cause);
        this.fault = fault;
    }

    public EmptyIdentifierExceptionBean getFaultInfo() {
        return fault;
    }
}
