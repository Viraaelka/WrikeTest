package com.wrike;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Randomizer {
    public static String getEmailRandomizer(){
        return "TestEmail" + (int)(Math.random() *500) + "wpt@wriketask.qaa";
    }

    public WebElement getRandomArrayBtn(ArrayList<WebElement> webArray) {
        return webArray.get((int)(Math.random() * webArray.size()));
    }

}