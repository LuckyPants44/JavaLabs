package com.company;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(OSFactory osFactory) {
        button = osFactory.CreateButton();
        checkbox = osFactory.CreateCheckbox();
    }

    public void Render(){
        button.render();
        checkbox.render();
    }
}
