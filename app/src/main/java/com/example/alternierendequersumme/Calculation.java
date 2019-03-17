package com.example.alternierendequersumme;

class Calculation {
    public static void calculateAlternierendeQuersumme(String matrikelnummer) {
        char[] chars = matrikelnummer.toCharArray();
        int[] numbers = new int[chars.length];
        int sum = 0;
        String oddOrEven;

        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Character.getNumericValue(chars[i]);
        }

        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i] * (-1);
            i++;
        }

        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        if (sum % 2 == 0) {
            oddOrEven = "gerade";
        } else {
            oddOrEven = "ungerade";
        }

        String back = "Die alternierende Quersumme Ihrer Matrikelnummer lautet: "
                + Integer.toString(sum) + ". Sie ist " + oddOrEven + ".";

        MainActivity.response.setText(back);
    }
}
