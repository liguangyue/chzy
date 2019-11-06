package com.chzyplus.member.utils;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class MyModule extends SimpleModule {
    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Object.class, PropertyFilterMixIn.class);
    }
}