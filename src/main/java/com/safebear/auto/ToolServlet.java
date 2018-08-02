package com.safebear.auto;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "ToolServlet",
        urlPatterns = {"/tools"}
)
public class ToolServlet extends HttpServlet {

    ToolService toolService = new ToolService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("searchAction");
        if (action!=null){
            switch (action) {           
            case "searchById":
                searchToolById(req, resp);
                break;           
            case "searchByName":
                searchToolByName(req, resp);
                break;
            }
        }else{
            List<Tool> result = toolService.getAllTools();
            forwardListTools(req, resp, result);
        }
    }

    private void searchToolById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idTool = Integer.valueOf(req.getParameter("idTool"));
        Tool tool = null;
        try {
            tool = toolService.getTool(idTool);
        } catch (Exception ex) {
            Logger.getLogger(ToolServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("tool", tool);
        req.setAttribute("action", "edit");
        String nextJSP = "/jsp/new-tool.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
    
    private void searchToolByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String toolName = req.getParameter("toolName");
        List<Tool> result = toolService.searchToolsByName(toolName);
        forwardListTools(req, resp, result);
    }

    private void forwardListTools(HttpServletRequest req, HttpServletResponse resp, List employeeList)
            throws ServletException, IOException {
        String nextJSP = "/jsp/list-tools.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("toolList", employeeList);
        dispatcher.forward(req, resp);
    }   
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addToolAction(req, resp);
                break;
            case "edit":
                editToolAction(req, resp);
                break;            
            case "remove":
                removeToolByName(req, resp);
                break;            
        }

    }

    private void addToolAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String use = req.getParameter("use");
        String website = req.getParameter("website");
        Tool tool = new Tool(name, use, website);
        long idTool = toolService.addTool(tool);
        List<Tool> toolList = toolService.getAllTools();
        req.setAttribute("idTool", idTool);
        String message = "The new tool has been successfully created.";
        req.setAttribute("message", message);
        forwardListTools(req, resp, toolList);
    }

    private void editToolAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String use = req.getParameter("use");
        String website = req.getParameter("website");
        long idTool = Integer.valueOf(req.getParameter("idTool"));
        Tool tool = new Tool(name, use, website, idTool);
        tool.setId(idTool);
        boolean success = toolService.updateTool(tool);
        String message = null;
        if (success) {
            message = "The tool has been successfully updated.";
        }
        List<Tool> toolList = toolService.getAllTools();
        req.setAttribute("idTool", idTool);
        req.setAttribute("message", message);
        forwardListTools(req, resp, toolList);
    }  

    private void removeToolByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idTool = Integer.valueOf(req.getParameter("idTool"));
        boolean confirm = toolService.deleteTool(idTool);
        if (confirm){
            String message = "The tool has been successfully removed.";
            req.setAttribute("message", message);
        }
        List<Tool> toolList = toolService.getAllTools();
        forwardListTools(req, resp, toolList);
    }

}
