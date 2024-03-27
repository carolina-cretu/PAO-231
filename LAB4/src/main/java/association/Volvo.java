package association;

/**
 * @author Carolina Cretu
 */
public class Volvo {

    private int fabricationYear;
    private String color;
    private VolvoEngine volvoEngine; //compozitie -> nu are sens ca un motor de Volvo sa existe in afara clasei Volvo; cand Volvo este distrus, dispare si VolvoEngine

    public Volvo(int fabricationYear, String color, VolvoEngine volvoEngine) {
        this.fabricationYear = fabricationYear;
        this.color = color;
        this.volvoEngine = volvoEngine;
    }


    public Volvo() {
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VolvoEngine getVolvoEngine() {
        return volvoEngine;
    }

    public void setVolvoEngine(VolvoEngine volvoEngine) {
        this.volvoEngine = volvoEngine;
    }


    @Override
    public String toString() {
        return "Volvo{" +
                "fabricationYear=" + fabricationYear +
                ", color='" + color + '\'' +
                ", volvoEngine=" + volvoEngine +
                '}';
    }

    class VolvoEngine {
        private int horsePower;
        private String material;

        public VolvoEngine(int horsePower, String material) {
            this.horsePower = horsePower;
            this.material = material;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        @Override
        public String toString() {
            return "VolvoEngine{" +
                    "horsePower=" + horsePower +
                    ", material='" + material + '\'' +
                    '}';
        }
    }
}
