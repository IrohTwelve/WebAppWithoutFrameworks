package com.osoleksandr.controller;

import com.osoleksandr.servlet.Request;
import com.osoleksandr.servlet.ViewModel;

public interface Controller {
    ViewModel process(Request request);
}
