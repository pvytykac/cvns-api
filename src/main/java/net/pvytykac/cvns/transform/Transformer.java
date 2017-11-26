package net.pvytykac.cvns.transform;

/**
 * @author Paly
 * @since 2017-11-25
 */
public interface Transformer<FROM, TO> {

    TO transform(FROM from);

}
