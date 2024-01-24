public interface UnitsInterface {
    public String[] getResistanceUnitNames();
    public String getResistanceUnitNameAtIndex(int index);
    public int[] getResistancePowers();
    public  int getResistanceUnitPowerAtIndex(int index);
    public int getResistanceUnitCount();

    public String[] getFrequencyUnitNames();
    public String getFrequencyUnitNameAtIndex(int index);

    public int[] getFrequencyPowers();
    public int getFrequencyPowerAtIndex(int index);

    public int getFrequencyUnitCount();

    public String[] getCapacitanceUnitNames();
    public String getCapacitanceUnitNameAtIndex(int index);
    public int[] getCapacitancePowers();
    public  int getCapacitanceUnitPowerAtIndex(int index);
    public int getCapacitanceUnitCount();

    public String[] getInductanceUnitNames();
    public String getInductanceUnitNameAtIndex(int index);
    public int[] getInductancePowers();
    public  int getInductanceUnitPowerAtIndex(int index);
    public int getInductanceUnitCount();

}
