/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

/**
 * The type Mecanographic number.
 */
@Embeddable
public class MecanographicNumber implements ValueObject, Comparable<MecanographicNumber> {
    private static final long serialVersionUID = 1L;
    private String number;

    /**
     * Instantiates a new Mecanographic number.
     */
    protected MecanographicNumber() {
        // for ORM
    }

    /**
     * Instantiates a new Mecanographic number.
     *
     * @param mecanographicNumber the mecanographic number
     */
    public MecanographicNumber(final String mecanographicNumber) {
        if (StringPredicates.isNullOrEmpty(mecanographicNumber)) {
            throw new IllegalArgumentException(
                    "Mecanographic Number should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.number = mecanographicNumber;
    }

    /**
     * Value of mecanographic number.
     *
     * @param mecanographicNumber the mecanographic number
     * @return the mecanographic number
     */
    public static MecanographicNumber valueOf(final String mecanographicNumber) {
        return new MecanographicNumber(mecanographicNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MecanographicNumber)) {
            return false;
        }

        final MecanographicNumber that = (MecanographicNumber) o;
        return this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public int compareTo(final MecanographicNumber arg0) {
        return number.compareTo(arg0.number);
    }

    @Override
    public String toString() {
        return this.number;
    }
}
