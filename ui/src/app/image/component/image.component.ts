import { Component, OnInit, Input } from '@angular/core';
import { ImageService } from 'src/app/image/service/image.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { SettingsService } from 'src/app/services/settings.service';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css'],
})
export class ImageComponent implements OnInit {
  image: any = {};
  comments: Array<any>;
  thumbnail: any;
  @Input('image_id') id: number;

  constructor(
    private imageService: ImageService,
    private route: ActivatedRoute,
    public setting: SettingsService,
    private sanitizer: DomSanitizer,
    public router: Router
  ) {}

  ngOnInit(): void {
    if (this.id == null) {
      this.getImage(this.route.snapshot.params.id);
    } else {
      this.getImage(this.id);
    }
  }

  getImage(id) {
    this.imageService.getImage(id).subscribe(
      (data: any) => {
        this.image = data;
        this.comments = data.comments;
        let objectURL = 'data:image/jpeg;base64,' + data.image;
        this.thumbnail = this.sanitizer.bypassSecurityTrustUrl(objectURL);
      },
      (err) => console.error(err),
      () => console.log('image loaded')
    );
  }
}
