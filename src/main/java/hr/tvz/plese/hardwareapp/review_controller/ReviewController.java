package hr.tvz.plese.hardwareapp.review_controller;

import hr.tvz.plese.hardwareapp.review_classes.ReviewDTO;
import hr.tvz.plese.hardwareapp.review_service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDTO> getAllReviews(){
        return reviewService.findAll();
    }

    @GetMapping("/{code}")
    public List<ReviewDTO> getReviewsByHardwareCode(@PathVariable final String code){
        return reviewService.findAllByHardwareCode(code);
    }

    @GetMapping(params = "str")
    public List<ReviewDTO> getReviewsByString(@RequestParam final String str){
        return reviewService.findAllByString(str);
    }
}
