package com.itqiwen.hibernate.test;

import com.itqiwen.hibernate.util.HibernateUtil;
import org.junit.Test;

public class TestCreateTable {
    @Test
    public void createTable(){
        HibernateUtil.getSession();
    }
}
