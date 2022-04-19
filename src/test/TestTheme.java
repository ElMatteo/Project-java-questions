package test;

import data.question.QCM;
import data.themes.Theme;
import data.question.VF;

import java.util.ArrayList;

public class TestTheme {
    public static void main(String[] args) {
        Theme theme = new Theme("Géographie", new ArrayList());
        theme.changementStatus();
        System.out.println(theme);
        theme.ajoutQuestion(new QCM("ou se trouve paris ?", 1, "Allemagne", "Maroc", "Angleterre", "France"));
        theme.ajoutQuestion(new VF("Antoine à 20 ans",2,true));
        System.out.println(theme);
    }
}
