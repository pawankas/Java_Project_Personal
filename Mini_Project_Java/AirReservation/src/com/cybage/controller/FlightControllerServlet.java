package com.cybage.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.FlightDao;
import com.cybage.model.Flight;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class FlightControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FlightDao flightDao;

    public void init() {
    	flightDao = new FlightDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                	insertFlight(request, response);
                    break;
                case "/delete":
                    deleteFlight(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateFlight(request, response);
                    break;
                default:
                	FlightList(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void FlightList(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Flight > FlightList = flightDao.selectAllFlights();
        request.setAttribute("FlightList",FlightList);        
        RequestDispatcher dispatcher = request.getRequestDispatcher("FlightList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("FlightForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int flightId = Integer.parseInt(request.getParameter("flightId"));
        Flight existingFlight = flightDao.selectFlight(flightId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("FlightForm.jsp");
        request.setAttribute("flight", existingFlight);
        dispatcher.forward(request, response);

    }

    private void insertFlight(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String flightName = request.getParameter("flightName");
        String flightNumber = request.getParameter("flightNumber");
        String source = request.getParameter("source");
        String destination  = request.getParameter("destination");
        String noOfStops  = request.getParameter("noOfStops");
        String date = request.getParameter("date");
        String time  = request.getParameter("time");
        double price  = Double.parseDouble(request.getParameter("price"));
        Flight newFlight = new Flight(flightName, flightNumber,source, destination, noOfStops, date, time, price);
        flightDao.insertFlight(newFlight);
        response.sendRedirect("list");
    }

    private void updateFlight(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int flightId  = Integer.parseInt(request.getParameter("flightId"));
        String flightName = request.getParameter("flightName");
        String flightNumber = request.getParameter("flightNumber");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String noOfStops = request.getParameter("noOfStops");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        double price = Double.parseDouble(request.getParameter("price"));

        Flight flight = new Flight(flightId, flightName, flightNumber,source, destination, noOfStops, date, time, price);
        flightDao.updateFlight(flight);
        response.sendRedirect("list");
    }

    private void deleteFlight(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	System.out.println(request.getParameter("flightId"));
    	try {
			int flightId = Integer.parseInt(request.getParameter("flightId"));
			flightDao.deleteFlight(flightId);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("list");
    }

}


