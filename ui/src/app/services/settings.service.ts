import { Injectable } from '@angular/core';
import { ImageService } from '../image/service/image.service';

@Injectable({
  providedIn: 'root',
})
export class SettingsService {
  public snippet;

  constructor(private imageService: ImageService) {}

  ngOnInit() {
    this.imageService.getImages().subscribe((data) => {
      console.log(data);
      this.snippet = data;
    });
  }
}
