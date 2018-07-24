
package business;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Reviews implements Serializable {

    public String getReviewsCode() {
        return ReviewsCode;
    }

    public void setReviewsCode(String ReviewsCode) {
        this.ReviewsCode = ReviewsCode;
    }

    public String getAutherEmail() {
        return autherEmail;
    }

    public void setAutherEmail(String autherEmail) {
        this.autherEmail = autherEmail;
    }

    public String getReviewsStatus() {
        return ReviewsStatus;
    }

   
    public void setReviewsStatus(String ReviewsStatus) {
        this.ReviewsStatus = ReviewsStatus;
    }

 
    public String getAuther() {
        return auther;
    }

   
    public void setAuther(String auther) {
        this.auther = auther;
    }

  
    public String getTitle() {
        return title;
    }

   
    public void setTitle(String title) {
        this.title = title;
    }

    
    public Date getDateCreated() {
        return dateCreated;
    }

    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String Description) {
        this.description = Description;
    }


    public String getUrlToImage() {
        return urlToImage;
    }


    public void setUrlToImage(String urlToImange) {
        this.urlToImage = urlToImange;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    private String auther;
    private String ReviewsCode;
    private String title;
    private String autherEmail;
    private Date dateCreated;
    private String ReviewsStatus;
    private String description;
    private String urlToImage;
    private String url;
    
    public Reviews() {
        auther = "";
        title = "";

        description = "";
        urlToImage = "";
        url = "";
    }
    
    
}
