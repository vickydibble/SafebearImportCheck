package com.safebear.auto;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ToolService {

    List<Tool> toolList = ToolList.getInstance();

    public List<Tool> getAllTools() {
        return toolList;
    }

    public List<Tool> searchToolsByName(String name) {
        Comparator<Tool> groupByComparator = Comparator.comparing(Tool::getName)
                                                    .thenComparing(Tool::getUse);
        List<Tool> result = toolList
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(name) || e.getUse().equalsIgnoreCase(name))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }

    public Tool getTool(long id) throws Exception {
        Optional<Tool> match
                = toolList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The Tool id " + id + " not found");
        }
    }   

    public long addTool(Tool tool) {
        toolList.add(tool);
        return tool.getId();
    }

    public boolean updateTool(Tool customer) {
        int matchIdx = 0;
        Optional<Tool> match = toolList.stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst();
        if (match.isPresent()) {
            matchIdx = toolList.indexOf(match.get());
            toolList.set(matchIdx, customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTool(long id) {
        Predicate<Tool> tool = e -> e.getId() == id;
        if (toolList.removeIf(tool)) {
            return true;
        } else {
            return false;
        }
    }
}
