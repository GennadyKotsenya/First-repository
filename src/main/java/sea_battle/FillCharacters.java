package sea_battle;

public enum FillCharacters {
    EMPTY(".-. "),SHIP_DECK("8,8 "),HALO(" -  "),
    DAMAGED_PART("0,0 ") ;


    private String designation;

    FillCharacters(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }


}
