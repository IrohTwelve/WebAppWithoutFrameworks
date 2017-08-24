package com.osoleksandr.controller;

import com.osoleksandr.factory.Factory;
import com.osoleksandr.servlet.Request;
import com.osoleksandr.servlet.ViewModel;

public class UserNotFoundPageController implements Controller {
    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        vm.setView("UserNotFound");
        return vm;
    }
}
