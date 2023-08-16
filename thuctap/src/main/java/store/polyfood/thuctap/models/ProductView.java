package store.polyfood.thuctap.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProductView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int productViewId;
    @Column
    private int productId;
    @Column
    private int userId;
    @Column
    private String contentRated;
    @Column
    private int pointEvaluation;
    @Column
    private String contentSeen;
    @Column
    private int status;
    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    public int getProductViewId() {
        return productViewId;
    }

    public void setProductViewId(int productViewId) {
        this.productViewId = productViewId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContentRated() {
        return contentRated;
    }

    public void setContentRated(String contentRated) {
        this.contentRated = contentRated;
    }

    public int getPointEvaluation() {
        return pointEvaluation;
    }

    public void setPointEvaluation(int pointEvaluation) {
        this.pointEvaluation = pointEvaluation;
    }

    public String getContentSeen() {
        return contentSeen;
    }

    public void setContentSeen(String contentSeen) {
        this.contentSeen = contentSeen;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
