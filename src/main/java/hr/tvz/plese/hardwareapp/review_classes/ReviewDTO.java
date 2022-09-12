package hr.tvz.plese.hardwareapp.review_classes;

import hr.tvz.plese.hardwareapp.hardware_classes.Hardware;

public class ReviewDTO {

    private final String title;
    private final String text;
    private final Integer grade;
    private Hardware hardwareToReview;

    public ReviewDTO(String title, String text, Integer grade, Hardware hardwareToReview) {
        this.title = title;
        this.text = text;
        this.grade = grade;
        this.hardwareToReview = hardwareToReview;
    }

    public ReviewDTO(String title, String text, Integer grade) {
        this.title = title;
        this.text = text;
        this.grade = grade;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Integer getGrade() {
        return grade;
    }

    public Hardware getHardwareToReview() {
        return hardwareToReview;
    }
}
