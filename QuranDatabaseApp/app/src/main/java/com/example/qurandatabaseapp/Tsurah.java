package com.example.qurandatabaseapp;

public class Tsurah
{
    public static int SurahID;
    public static String SurahIntro;
    public static String SurahNameE;
    public static String Nazool;
    public static String SurahNameU;

    public Tsurah(int id, String intro, String nameE, String nameU, String nazool) {

        SurahID=id;
        SurahIntro=intro;
        SurahNameE=nameE;
        SurahNameU=nameU;
        Nazool=nazool;
    }

    public static int getSurahID() {
        return SurahID;
    }

    public static String getSurahIntro() {
        return SurahIntro;
    }

    public static String getSurahNameE() {
        return SurahNameE;
    }

    public static String getNazool() {
        return Nazool;
    }

    public static String getSurahNameU() {
        return SurahNameU;
    }
}
