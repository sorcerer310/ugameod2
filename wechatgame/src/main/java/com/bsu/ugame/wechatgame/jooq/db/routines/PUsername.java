/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.routines;


import com.bsu.ugame.wechatgame.jooq.db.Login;

import javax.annotation.Generated;

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
public class PUsername extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 1599361143;

    /**
     * Create a new routine call instance
     */
    public PUsername() {
        super("P_UserName", Login.LOGIN);
    }
}
