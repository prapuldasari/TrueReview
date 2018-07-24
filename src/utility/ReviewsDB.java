
package utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.Reviews;
import business.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewsDB {

    public static Reviews  getReviews (String ReviewsCode) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ReviewsDB "
                + "WHERE ReviewsCode = ?";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, ReviewsCode);
            rs = ps.executeQuery();
            Reviews reviews = null;
            if (rs.next()) {
                reviews = new Reviews();
                reviews.setReviewsCode(rs.getString("ReviewsCode"));
                reviews.setTitle(rs.getString("title"));
                reviews.setAutherEmail(rs.getString("AutherEmail"));
                SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                Date date = parser.parse(rs.getString("DateCreated"));
                reviews.setDateCreated(date);
                reviews.setDescription(rs.getString("Description"));
                reviews.setReviewsStatus(rs.getString("reviewsStatus"));
                reviews.setUrl(rs.getString("url"));
                reviews.setUrlToImage(rs.getString("UrlToImage"));
            }
            connection.close();
            return reviews;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Reviews> getAllReviews() throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ReviewsDB ";
        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Reviews reviews = null;
            ArrayList<Reviews> reviewsList = new ArrayList<>();
            while (rs.next()) {
                reviews = new Reviews();
                reviews.setReviewsCode(rs.getString("ReviewsCode"));
                reviews.setReviewsCode(rs.getString("ReviewsCode"));
                reviews.setTitle(rs.getString("title"));
                SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                Date date = parser.parse(rs.getString("DateCreated"));
                reviews.setDateCreated(date);
                reviews.setDescription(rs.getString("Description"));
                reviews.setReviewsStatus(rs.getString("reviewsStatus"));
                reviews.setUrl(rs.getString("url"));
                reviews.setUrlToImage(rs.getString("UrlToImage"));
                reviewsList.add(reviews);
            }
            connection.close();
            return reviewsList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
        return null;
    }

    public static ArrayList<Reviews> getMyReviews(String email) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ReviewsDB "
                + "WHERE AutherEmail = ? ";

        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            Reviews reviews = null;
            ArrayList<Reviews> studies = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    reviews = new Reviews();
                    reviews.setReviewsCode(rs.getString("ReviewsCode"));
                    reviews.setTitle(rs.getString("title"));
                    SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                    Date date = parser.parse(rs.getString("DateCreated"));
                    reviews.setDateCreated(date);
                    reviews.setDescription(rs.getString("Description"));
                    reviews.setReviewsStatus(rs.getString("reviewsStatus"));
                    reviews.setUrl(rs.getString("url"));
                    reviews.setUrlToImage(rs.getString("UrlToImage"));
                    studies.add(reviews);
                }
            }
            connection.close();
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Reviews> getReviewsByStatus(String status) throws IOException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ReviewsDB "
                + "WHERE reviewsstatus = ?";

        try {
            Connection connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, status);
            rs = ps.executeQuery();
            Reviews reviews = null;
            ArrayList<Reviews> studies = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    reviews = new Reviews();
                    reviews.setReviewsCode(rs.getString("ReviewsCode"));
                    reviews.setTitle(rs.getString("title"));
                    SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                    Date date = parser.parse(rs.getString("DateCreated"));
                    reviews.setDateCreated(date);
                    reviews.setDescription(rs.getString("Description"));
                    reviews.setReviewsStatus(rs.getString("reviewsStatus"));
                    reviews.setUrl(rs.getString("url"));
                    reviews.setUrlToImage(rs.getString("UrlToImage"));
                    studies.add(reviews);
                }
            }
            connection.close();
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static int addReviews(Reviews reviews,User user) throws IOException {

        PreparedStatement ps = null;
        Connection connection = null;
        String query
                = "INSERT INTO ReviewsDB(ReviewsCode,Title, Auther, AutherEmail, Description, url, reviewsstatus, urltoImage,DateCreated) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = ConnectionPool.getConnection();
            System.out.println("conn"+connection);
            ps = connection.prepareStatement(query);
            System.out.println("stmt"+ps);
            ps.setString(1, reviews.getReviewsCode());
            ps.setString(2, reviews.getTitle());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());
            ps.setString(5, reviews.getDescription());
            ps.setString(6, reviews.getUrl());
            ps.setString(7, "Pending for Approval");
            ps.setString(8, reviews.getUrlToImage());
            ps.setString(9, (reviews.getDateCreated()).toString());
            return ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e);
            return 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closePreparedStatement(ps);
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public static int updateReviewsStatus(String reviewsCode, String reviewsstatus) throws IOException {

        PreparedStatement ps = null;
        Connection connection = null;
        String query = "UPDATE ReviewsDB SET "
                + "reviewsStatus = ?"
                + "WHERE ReviewsCode = ?";
        try {
            connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, reviewsstatus);
            ps.setString(2, reviewsCode);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closePreparedStatement(ps);
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReviewsDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
}
