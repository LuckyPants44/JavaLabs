package com.company;

public class IOSFactory implements OSFactory {
    @Override
    public Button CreateButton() {
        return new IOSButton();
    }

    @Override
    public Checkbox CreateCheckbox() {
        return new IOSCheckbox();
    }
}
