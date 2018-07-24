
package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.Reviews;
import business.User;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.ReviewsDB;
import utility.UserDB;

public class ReviewsController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("theUser");
        User admin = (User) session.getAttribute("theAdmin");
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            if (user != null) {
                url = "/main.jsp";
            } else {
                if (admin != null) {
                    url = "/admin.jsp";
                } else {
                    url = "/main.jsp";
                }
            }
        } else if (action.equalsIgnoreCase("addReviews")) {
            if (user != null) {
                try {
                    Reviews newReviews = new Reviews();
                    newReviews.setReviewsCode(request.getParameter("reviewsCode"));
                    newReviews.setTitle(request.getParameter("Title"));
                    newReviews.setDescription(request.getParameter("Description"));
                    newReviews.setUrl(request.getParameter("url"));
                    newReviews.setUrlToImage(request.getParameter("UrlToImage"));
                    SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                    Date date = new Date();
                    //parser.
                    date = parser.parse(date.toString());
                    newReviews.setDateCreated(date);
                    ReviewsDB.addReviews(newReviews,user);
                    user.setNumOfPosts(user.getNumOfPosts()+ 1);
                    UserDB.updateUser(user);
                    url="/main.jsp";
                } catch (ParseException ex) {
                    Logger.getLogger(ReviewsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        else if (action.equalsIgnoreCase("myReviews")) {
            if (user != null) {
                ArrayList<Reviews> reviewsList = new ArrayList<>();
                reviewsList = ReviewsDB.getMyReviews(user.getEmail());
                request.setAttribute("reviewsList", reviewsList);
                url="/reviewslist.jsp";
                }
            }
        else if (action.equalsIgnoreCase("viewReviews")) {
            if (admin != null || user != null) {
                String reviewsCode = (String) request.getParameter("reviewsCode");
                Reviews reviews = ReviewsDB.getReviews(reviewsCode);
                request.setAttribute("reviews", reviews);
                url="/viewreview.jsp";
                }
            }
        else if (action.equalsIgnoreCase("PostedReviews")) {
            if (admin != null) {
                ArrayList<Reviews> reviewsList = new ArrayList<>();
                reviewsList = ReviewsDB.getReviewsByStatus("Pending for Approval");
                request.setAttribute("reviewsList", reviewsList);
                url="/reviewsapproval.jsp";
                }
            }
        else if (action.equalsIgnoreCase("approve")) {
            if (admin != null) {
                String reviewsCode = (String) request.getParameter("reviewsCode");
                System.out.println(reviewsCode);
                ReviewsDB.updateReviewsStatus(reviewsCode, "Approved");
                Reviews reviews = ReviewsDB.getReviews(reviewsCode);
                user = UserDB.getUser(reviews.getAutherEmail());
                user.setNumOfPostedReviews(user.getNumOfPostedReviews() + 1);
                UserDB.updateUser(user);
                url="/approved.jsp";
                }
            }
        else if (action.equalsIgnoreCase("disapprove")) {
            if (admin != null) {
                String reviewsCode = (String) request.getParameter("reviewsCode");
                ReviewsDB.updateReviewsStatus(reviewsCode, "Rejected");
                url="/disapproved.jsp";
                }
            }
        else {
                url = "/login.jsp";
            }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }
        // forward request and response objects to specified URL
        

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
