package temperatureconverter.android.vogella.com.temperatureconverter;

/**
 * Created by churong1 on 5/11/16.
 */
public class ConverterUtil {
    public static float convertFahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    public static float convertCelsiusToFahrenheit(float celsius) {
        return ((celsius * 9) / 5) + 32;
    }
}
