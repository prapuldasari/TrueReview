package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.User;
import utility.Mailer;
import utility.UserDB;

public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        HttpSession session = request.getSession();
        // get current action
        String action = request.getParameter("action");
        User user = (User) session.getAttribute("theUser");
        User admin = (User) session.getAttribute("theAdmin");
        
        if (action == null) {
            url = "/index.jsp";    // the "main" page
        } else if (action.equalsIgnoreCase("login") || action.equalsIgnoreCase("create") || action.equalsIgnoreCase("how")
                || action.equalsIgnoreCase("about") || action.equalsIgnoreCase("index") || action.equalsIgnoreCase("main") || action.equalsIgnoreCase("logout") 
        	 || action.equalsIgnoreCase("contact") || action.equalsIgnoreCase("sitemap")) {
            String requestingMachine = request.getRemoteAddr();
            int requestingPort = request.getRemotePort();
            String port = String.valueOf(requestingPort);
            String machineDetails = requestingMachine+":"+port;
            Cookie c = new Cookie("hostCookie", machineDetails);
            c.setMaxAge(60 * 60 * 24 * 10);
            c.setPath("/");
            response.addCookie(c);
            if (action.equalsIgnoreCase("login")) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                User loginUser = UserDB.getUser(email);
                if (loginUser != null && loginUser.getPassword().equals(password)) {
                    String type = loginUser.getType();
                    if (type.equalsIgnoreCase("reporter")) {
                        User userBean; 
                        userBean = new User(loginUser.getName(), loginUser.getEmail(), loginUser.getType(), loginUser.getNumOfPosts(), loginUser.getNumOfPostedReviews());
                        session.setAttribute("theUser", userBean);
                        url = "/main.jsp";
                    } else if (type.equalsIgnoreCase("admin")) {
                        User userBean = new User(loginUser.getName(), loginUser.getEmail(), loginUser.getType(), loginUser.getNumOfPosts(), loginUser.getNumOfPostedReviews()); 
                        session.setAttribute("theAdmin", userBean);
                        url = "/admin.jsp";
                    }
                } else {
                    request.setAttribute("msg", "Not a valid user");
                    url = "/login.jsp";
                }
            } else if (action.equalsIgnoreCase("create")) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String type = "Reporter";
                String password = request.getParameter("password");
                String confirmPassword = request.getParameter("confirm_password");
                if (name != null && email != null && type != null && password != null && confirmPassword != null && password.equals(confirmPassword)) {
                    User userBean = new User(name, email, type, 1, 1);
                    userBean.setPassword(password);
                    UserDB.insertUser(userBean);
                    Mailer.sendMail(userBean.getEmail(),"prapul13@gmail.com","True Review","Thank you for joining true review now you can post your own reviews and get them approved.",false);
                    userBean.setPassword("");
                    session.setAttribute("theUser", userBean);
                    url = "/main.jsp";
                } else {
                    request.setAttribute("msg", "Cannot create the account");
                    url = "/signup.jsp";
                }
            } else if (action.equalsIgnoreCase("how")) {
                if (user != null) {
                    url = "/main.jsp";
                } else {
                    url = "/how.jsp";
                }
            } else if (action.equalsIgnoreCase("about")) {
                if (user != null) {
                    url = "/aboutus.jsp";
                } else {
                    url = "/aboutus.jsp";
                }
            } else if (action.equalsIgnoreCase("contact")) {
                if (user != null) {
                    url = "/contact.jsp";
                } else {
                    url = "/contact.jsp";
                }
            } else if (action.equalsIgnoreCase("sitemap")) {
                if (user != null) {
                    url = "/sitemap.jsp";
                } else {
                    url = "/sitemap.jsp";
                }
           
            } else if (action.equalsIgnoreCase("home")) {
                if (user != null) {
                    url = "/main.jsp";
                } else {
                    url = "/admin.jsp";
                }
            }else if (action.equalsIgnoreCase("index")) {
                    if (user != null) {
                        url = "/index.jsp";
                    } else {
                        url = "/index.jsp";
                    }
            } else if (action.equalsIgnoreCase("logout")) {
                if (user != null || admin != null) {
                    session.invalidate();
                    url = "/login.jsp";
                } else {
                    url = "/login.jsp";
                }
            }
            else{
                url="/login.jsp";
            }}
        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
