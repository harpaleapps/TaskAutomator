package com.harpaleapps.taskautomator.modle;

public class ViewModel {
    private final String name;
    private final String description;

    public ViewModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
