import { Component, OnInit } from '@angular/core';
import { ImageService } from 'src/app/image/service/image.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  images: any = [];

  constructor(private imageService: ImageService) {}

  ngOnInit(): void {
    this.getImages();
  }

  getImages() {
    this.imageService.getImages().subscribe(
      (data) => {
        this.images = data;
      },
      (err) => console.error(err),
      () => console.log('images loaded')
    );
  }
}
