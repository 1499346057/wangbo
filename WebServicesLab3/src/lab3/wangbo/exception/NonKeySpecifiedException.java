package lab3.wangbo.exception;

import javax.xml.ws.WebFault;

/**
 * @author WangBo
 * @date 23.05.2019
 */
@WebFault(faultBean = "lab3.wangbo.exception.NonKeySpecifiedExceptionBean")
public class NonKeySpecifiedException extends Exception {
    private final NonKeySpecifiedExceptionBean fault;

    public NonKeySpecifiedException(String message, NonKeySpecifiedExceptionBean fault) {
        super(message);
        this.fault = fault;
    }

    public NonKeySpecifiedException(String message, NonKeySpecifiedExceptionBean fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public NonKeySpecifiedExceptionBean getFaultInfo() {
        return fault;
    }
}
