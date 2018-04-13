package am.tv.program;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 5:50 PM
 */
public class TVProgram {
    
    private String name;
    private List<ProgramItem> programItems;

    public TVProgram() {
        programItems = new ArrayList<ProgramItem>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProgramItem> getProgramItems() {
        return programItems;
    }

    public void setProgramItems(List<ProgramItem> programItems) {
        this.programItems = programItems;
    }
    
    public void addProgramItem(ProgramItem programItem) {
        this.programItems.add(programItem);
    }

    @Override
    public String toString() {
        return "TVProgram{" +
                "name='" + name + '\'' +
                "\n programItems=" + programItems +
                '}';
    }
}
