package lab6.wangbo.exception;

/**
 * @author WangBo
 * @date 26.05.2019
 */
public class NonKeySpecifiedException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static NonKeySpecifiedException DEFAULT_INSTANCE =
            new NonKeySpecifiedException("At least one key must be specified");

    public NonKeySpecifiedException(String message) {
        super(message);
    }
}
