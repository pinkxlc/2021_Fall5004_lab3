package lab3;

/**
 * The type Celsius temperature.
 */
public class CelsiusTemperature implements Temperature {

  private double tempInCelsius;

  /**
   * Instantiates a new Celsius temperature.
   *
   * @param tempInCelsius the temp in celsius
   * @throws IllegalArgumentException the illegal argument exception
   */
  public CelsiusTemperature(double tempInCelsius) throws IllegalArgumentException {
    if (tempInCelsius<ABS_ZERO_C) {
      throw new IllegalArgumentException("tempInCelsius is too low");
    }
    this.tempInCelsius = tempInCelsius;
  }

  /**
   * Instantiates a new Celsius temperature.
   *
   * @param tempInFahrenheit the temp in fahrenheit
   * @param isFahrenheit     a boolean variable that indicates input in fahrenheit
   * @throws IllegalArgumentException the illegal argument exception
   */
  public CelsiusTemperature(double tempInFahrenheit, boolean isFahrenheit)
      throws IllegalArgumentException {
    if (!isFahrenheit) {
      throw new IllegalArgumentException("isFahrenheit must be true");
    }

    this.tempInCelsius = (tempInFahrenheit - 32) * 5/9;
    if (this.tempInCelsius<ABS_ZERO_C) {
      throw new IllegalArgumentException("tempInFahrenheit is too low");
    }
  }

  @Override
  public double inCelsius() {
    return this.tempInCelsius;
  }

  @Override
  public double inFahrenheit() {
    return this.tempInCelsius * 9/5 + 32;
  }

  @Override
  public double inKelvin() {
    return this.tempInCelsius - ABS_ZERO_C;
  }

  @Override
  public Temperature add(Temperature t) throws IllegalArgumentException {
    return new CelsiusTemperature(this.tempInCelsius + t.inCelsius());
  }

  @Override
  public String toString() {
    return String.format("%.1f° Celsius", this.tempInCelsius);
  }
}
