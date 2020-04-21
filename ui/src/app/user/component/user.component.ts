import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SettingsService } from 'src/app/services/settings.service';
import { DomSanitizer } from '@angular/platform-browser';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  public user;
  images: Array<any>;
  thumbnail: any;

  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    public setting: SettingsService,
    private sanitizer: DomSanitizer
  ) {}

  ngOnInit(): void {
    this.getUser(this.route.snapshot.params.id);
  }

  getUser(id: number) {
    this.userService.getUser(id).subscribe(
      (data: any) => {
        this.user = data;
        this.images = data.images;
        let objectURL = 'data:image/jpeg;base64,' + data.profilePic;
        this.thumbnail = this.sanitizer.bypassSecurityTrustUrl(objectURL);
      },
      (err) => console.error(err),
      () => console.log('user loaded')
    );
  }
}
