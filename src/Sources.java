public enum Sources {
    //�����
    FOOD("Food"),
    COSMETIC("Cosmetic"),
    FINES("Fines"),//������
    EDUCATION("Education"),
    RESTAURANTS_AND_CAFE("Restaurants and cafe"),
    BUILDING_MATERIALS("Building materials"),
    AUTOMOBILE_PARTS("Automobile parts"),
    ENTERTAINMENTS("Entertainments"),


    //�����
    SCHOLARSHIP("Scholarship"),
    SALARY("Salary"),
    TRANSACTION("Transaction"),
    SOCIAL_PAYMENT("Social payment");

    public final String description;

    Sources(String description) {
        this.description = description;
    }
}
