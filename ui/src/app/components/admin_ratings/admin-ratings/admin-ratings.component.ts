import { Component, OnInit } from '@angular/core';
import { RatingService } from 'src/app/rating/service/rating.service';

@Component({
  selector: 'app-admin-ratings',
  templateUrl: './admin-ratings.component.html',
  styleUrls: ['./admin-ratings.component.css'],
})
export class AdminRatingsComponent implements OnInit {
  public ratings;
  displayedColumns: string[] = [
    'id',
    'image_id',
    'user_id',
    'rating',
    'actions',
  ];
  constructor(private ratingService: RatingService) {}

  ngOnInit(): void {
    this.getRatings();
  }

  getRatings() {
    this.ratingService.getRatings().subscribe(
      (data) => {
        this.ratings = data;
      },
      (err) => console.error(err),
      () => console.log('ratings loaded')
    );
  }
}
