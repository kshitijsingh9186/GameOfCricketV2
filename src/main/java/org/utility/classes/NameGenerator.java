package org.utility.classes;

public class NameGenerator {
    private static int number = 0;
    public static String generateRandomName()
    {
        number++;
        return "PlayerNumber"+number;
    }
}
