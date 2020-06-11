package com.company.Student0.Exception.Impl;

import com.company.Student0.Exception.StudentIdExpection;

public class StudentIdExceptionImpl extends Exception implements StudentIdExpection {
    static final long serialVersionUID = -3387516993124229948L;
    public StudentIdExceptionImpl() {
    }

    public StudentIdExceptionImpl(String message) {
        super(message);
    }

    @Override
    public void StudentIdHanderException() throws StudentIdExceptionImpl {
            throw new StudentIdExceptionImpl();
    }


}
