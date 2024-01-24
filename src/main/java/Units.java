public class Units implements  UnitsInterface{
    private String[] ResistanceUnitNames = {"\u03BC\u03a9", "m\u03a9","\u03a9","k\u03a9", "M\u03a9", "G\u03a9"};
    private int[] ResistancePowers = {-6,-3,0,3,6,9};

    private String[] FrequencyUnitNames = {"Hz", "kHz", "MHz", "GHz"};
    private int[] FrequencyPowers = {0,3,6,9};

    private String[] CapacitanceUnitNames = {"pF", "nF", "\u03BCF", "mF","F"};
    private int[] CapacitancePowers = {-12, -9, -6, -3, 0};

    private String[] InductanceUnitNames = {"nH", "\u03BCH", "mH", "H"};
    private int[] InductancePowers = {-9, -6, -3, 0};



    @Override
    public String[] getResistanceUnitNames() {
        return ResistanceUnitNames;
    }

    @Override
    public String getResistanceUnitNameAtIndex(int index) {
        if(index > 0){
            return ResistanceUnitNames[index];
        }
        return ResistanceUnitNames[0];
    }

    @Override
    public int[] getResistancePowers() {
        return ResistancePowers;
    }

    @Override
    public int getResistanceUnitPowerAtIndex(int index) {
        if(index > 0){
            return ResistancePowers[index];
        }
        return ResistancePowers[0];
    }

    @Override
    public int getResistanceUnitCount() {
        return ResistanceUnitNames.length;
    }

    @Override
    public String[] getFrequencyUnitNames() {
        return FrequencyUnitNames;
    }

    @Override
    public String getFrequencyUnitNameAtIndex(int index) {
        if(index > 0){
            return FrequencyUnitNames[index];
        }
        else{
            return FrequencyUnitNames[0];
        }
    }

    @Override
    public int[] getFrequencyPowers() {
        return FrequencyPowers;
    }

    @Override
    public int getFrequencyPowerAtIndex(int index) {
        if(index > 0){
            return FrequencyPowers[index];
        }
        else{
            return FrequencyPowers[0];
        }
    }

    @Override
    public int getFrequencyUnitCount() {
        return FrequencyPowers.length;
    }

    @Override
    public String[] getCapacitanceUnitNames() {
        return CapacitanceUnitNames;
    }

    @Override
    public String getCapacitanceUnitNameAtIndex(int index) {
        if(index > 0){
            return CapacitanceUnitNames[index];
        }
        return CapacitanceUnitNames[0];
    }

    @Override
    public int[] getCapacitancePowers() {
        return CapacitancePowers;
    }

    @Override
    public int getCapacitanceUnitPowerAtIndex(int index) {
        if(index > 0){
            return CapacitancePowers[index];
        }
        else{
            return CapacitancePowers[0];
        }
    }

    @Override
    public int getCapacitanceUnitCount() {
        return CapacitanceUnitNames.length;
    }

    @Override
    public String[] getInductanceUnitNames() {
        return InductanceUnitNames;
    }

    @Override
    public String getInductanceUnitNameAtIndex(int index) {
        if(index > 0){
            return InductanceUnitNames[index];
        }
        else{
            return InductanceUnitNames[0];
        }
    }

    @Override
    public int[] getInductancePowers() {
        return InductancePowers;
    }

    @Override
    public int getInductanceUnitPowerAtIndex(int index) {
        if(index > 0){
            return InductancePowers[index];
        }
        else{
            return InductancePowers[0];
        }
    }

    @Override
    public int getInductanceUnitCount() {
        return InductanceUnitNames.length;
    }
}
