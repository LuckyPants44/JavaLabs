package com.company;

public class AndroidFactory implements OSFactory {
    @Override
    public Checkbox CreateCheckbox() {
        return new AndroidCheckbox();
    }

    @Override
    public Button CreateButton() {
        return new AndroidButton();
    }
}
