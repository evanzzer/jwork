package evanshebert.jwork.enums;

/**
 * Enumeration of Job Category
 *
 * @author Evans Hebert
 * @version 25 March 2021
 */
public enum JobCategory {
    WebDeveloper("Web Developer"),
    FrontEnd("Front End"),
    BackEnd("Back End"),
    UI("UI"),
    UX("UX"),
    DevOps("DevOps"),
    DataScientist("Data Scientist"),
    DataAnalyst("Data Analyst");

    private final String description;

    JobCategory(String description) {
        this.description = description;
    }

    /**
     * Convert an enum to string
     *
     * @return String description of an enum
     */
    public String toString() {
        return description;
    }
}