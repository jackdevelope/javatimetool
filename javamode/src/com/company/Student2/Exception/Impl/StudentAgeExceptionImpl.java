package com.Student1.Exception.Impl;

import com.Student1.Exception.StudentAgeException;

public class StudentAgeExceptionImpl extends Exception implements StudentAgeException {
    private static final long serialVersionUID = -3042686055658047285L;

    public StudentAgeExceptionImpl() {
    }

    public StudentAgeExceptionImpl(String message) {
        super(message);
    }



    @Override
    public void StudentAgeException() throws StudentAgeExceptionImpl {
        throw new StudentAgeExceptionImpl();
    }
}
