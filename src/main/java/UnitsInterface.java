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

}
