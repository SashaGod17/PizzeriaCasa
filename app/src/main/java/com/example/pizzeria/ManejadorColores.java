package com.example.pizzeria;

import android.graphics.Color;

public class ManejadorColores {

        private static int color = Color.WHITE;

        public static int getColor() {
            return color;
        }

        public static void setColor(int c) {
            color = c;
        }

}
