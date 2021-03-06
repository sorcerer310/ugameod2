/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.routines;


import com.bsu.ugame.wechatgame.jooq.db.Login;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FunLeftrate extends AbstractRoutine<BigDecimal> {

    private static final long serialVersionUID = -7542611;

    /**
     * The parameter <code>login.Fun_LeftRate.RETURN_VALUE</code>.
     */
    public static final Parameter<BigDecimal> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.DECIMAL(10, 2), false, false);

    /**
     * The parameter <code>login.Fun_LeftRate.paddDate</code>.
     */
    public static final Parameter<String> PADDDATE = createParameter("paddDate", org.jooq.impl.SQLDataType.VARCHAR(50), false, false);

    /**
     * The parameter <code>login.Fun_LeftRate.pleftType</code>.
     */
    public static final Parameter<Integer> PLEFTTYPE = createParameter("pleftType", org.jooq.impl.SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>login.Fun_LeftRate.pboxappid</code>.
     */
    public static final Parameter<String> PBOXAPPID = createParameter("pboxappid", org.jooq.impl.SQLDataType.VARCHAR(50), false, false);

    /**
     * The parameter <code>login.Fun_LeftRate.pgameappid</code>.
     */
    public static final Parameter<String> PGAMEAPPID = createParameter("pgameappid", org.jooq.impl.SQLDataType.VARCHAR(50), false, false);

    /**
     * Create a new routine call instance
     */
    public FunLeftrate() {
        super("Fun_LeftRate", Login.LOGIN, org.jooq.impl.SQLDataType.DECIMAL(10, 2));

        setReturnParameter(RETURN_VALUE);
        addInParameter(PADDDATE);
        addInParameter(PLEFTTYPE);
        addInParameter(PBOXAPPID);
        addInParameter(PGAMEAPPID);
    }

    /**
     * Set the <code>paddDate</code> parameter IN value to the routine
     */
    public void setPadddate(String value) {
        setValue(PADDDATE, value);
    }

    /**
     * Set the <code>paddDate</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setPadddate(Field<String> field) {
        setField(PADDDATE, field);
    }

    /**
     * Set the <code>pleftType</code> parameter IN value to the routine
     */
    public void setPlefttype(Integer value) {
        setValue(PLEFTTYPE, value);
    }

    /**
     * Set the <code>pleftType</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setPlefttype(Field<Integer> field) {
        setField(PLEFTTYPE, field);
    }

    /**
     * Set the <code>pboxappid</code> parameter IN value to the routine
     */
    public void setPboxappid(String value) {
        setValue(PBOXAPPID, value);
    }

    /**
     * Set the <code>pboxappid</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setPboxappid(Field<String> field) {
        setField(PBOXAPPID, field);
    }

    /**
     * Set the <code>pgameappid</code> parameter IN value to the routine
     */
    public void setPgameappid(String value) {
        setValue(PGAMEAPPID, value);
    }

    /**
     * Set the <code>pgameappid</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public void setPgameappid(Field<String> field) {
        setField(PGAMEAPPID, field);
    }
}
