package test;

import data.themes.Theme;
import data.themes.Themes;

import java.util.ArrayList;

public class TestThemes {
    public static void main(String[] args) {
        Themes themes = new Themes();
        Theme th;
        for (int i = 0; i < 20; i++) {
            String a = Character.toString((char) i + 65);
            themes.ajoutTheme(new Theme(a, new ArrayList()));
        }
    }

}
