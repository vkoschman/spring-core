package com.andreitop.dlookup;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

class DependencyPooling {

    static void dependencyPull() throws NamingException {

        Context ctx = new InitialContext();
        ctx.bind("human", Human.class);
        Human human = (Human)ctx.lookup("human");
    }

    private class Human {
    }
}
