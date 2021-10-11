package lab3;

/**
 * The type Fahrenheit temperature.
 */
public class FahrenheitTemperature implements Temperature {

  private double tempInFahrenheit;

  /**
   * Instantiates a new Fahrenheit temperature.
   *
   * @param tempInFahrenheit the temp in fahrenheit
   * @throws IllegalArgumentException the illegal argument exception
   */
  public FahrenheitTemperature(double tempInFahrenheit) throws IllegalArgumentException {
    this.tempInFahrenheit = tempInFahrenheit;
    if (this.inCelsius()<ABS_ZERO_C) {
      throw new IllegalArgumentException("tempInFahrenheit is too low");
    }
  }

  /**
   * Instantiates a new Fahrenheit temperature.
   *
   * @param tempInCelsius the temp in celsius
   * @param isCelsius     a boolean variable that indicates input in celsius
   * @throws IllegalArgumentException the illegal argument exception
   */
  public FahrenheitTemperature(double tempInCelsius, boolean isCelsius)
      throws IllegalArgumentException {
    if (!isCelsius) {
      throw new IllegalArgumentException("isCelsius must be true");
    }
    if (tempInCelsius<ABS_ZERO_C) {
      throw new IllegalArgumentException("tempInCelsius is too low");
    }
    this.tempInFahrenheit = tempInCelsius*9/5 + 32;
  }

  @Override
  public double inCelsius() {
    return (tempInFahrenheit - 32) * 5/9;
  }

  @Override
  public double inFahrenheit() {
    return this.tempInFahrenheit;
  }

  @Override
  public double inKelvin() {
    return this.inCelsius() - ABS_ZERO_C;
  }

  @Override
  public Temperature add(Temperature t) throws IllegalArgumentException {
    return new FahrenheitTemperature(this.tempInFahrenheit + t.inFahrenheit());
  }

  @Override
  public String toString() {
    return String.format("%.1f° Fahrenheit", this.tempInFahrenheit);
  }
}
