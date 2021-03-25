/**
 * Enumeration of Job Category
 * 
 * @author Evans Hebert
 * @version 25 March 2021
 */
public enum JobCategory
{
    WebDeveloper, FrontEnd, BackEnd, UI, UX, DevOps, DataScientist, DataAnalyst;
    
    /**
     * Convert an enum to string
     */
    public String toString() {
        switch(this) {
            case WebDeveloper:
                return "Web Developer";
            case FrontEnd:
                return "Front End";
            case BackEnd:
                return "Back End";
            case UI:
                return "UI";
            case UX:
                return "UX";
            case DevOps:
                return "DevOps";
            case DataScientist:
                return "Data Scientist";
            case DataAnalyst:
                return "Data Analyst";
            default:
                return "Not Registered";
        }
    }
}
