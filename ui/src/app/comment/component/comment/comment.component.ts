import { Component, OnInit, Input } from '@angular/core';
import { CommentService } from '../../service/comment.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
})
export class CommentComponent implements OnInit {
  comment: any = {};
  thumbnail: any;
  @Input('comment_id') id: number;

  constructor(
    private commentService: CommentService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    if (this.id == null) {
      this.getComment(this.route.snapshot.params.id);
    } else {
      this.getComment(this.id);
    }
  }

  getComment(id) {
    this.commentService.getComment(id).subscribe(
      (data) => {
        this.comment = data;
      },
      (err) => console.error(err),
      () => console.log('comment loaded')
    );
  }
}
