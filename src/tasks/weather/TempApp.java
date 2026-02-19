package tasks.weather;

public class TempApp {

    public record Weather (
            java.time.LocalDate data,
            double minTemp,
            double maxTemp,
            Unit unit) {

    }

    public enum Unit {
        CELSIUS("C") {
            @Override
            public double convert(double value, Unit target) {
                if ( target == CELSIUS) return value;
                return value * 1.8 + 32;
            }
        },
        FAHRENHEIT("F") {
            @Override
            public double convert(double value, Unit target) {
                if ( target == FAHRENHEIT) return value;
                return value / 1.8 - 32;
            }
        };

        private final String unitSight;

        Unit(String unitSight) {
            this.unitSight = unitSight;
        }

        public String getUnitSight() {
            return unitSight;
        }

        public static Unit fromString(String s) {
            return switch (s.toUpperCase()) {
                case "C" -> CELSIUS;
                case "F" -> FAHRENHEIT;
                default -> throw new IllegalArgumentException("Nieprawidłowa jednostka");
            };
        }

        public abstract double convert(double value, Unit target);

    }




}


